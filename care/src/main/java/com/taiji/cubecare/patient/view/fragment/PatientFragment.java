package com.taiji.cubecare.patient.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.taiji.cubecare.R;
import com.taiji.cubecare.home.view.activity.HomeActivity;
import com.taiji.cubecare.patient.data.PatientRepository;
import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.cubecare.patient.presenter.PatientContract;
import com.taiji.cubecare.patient.presenter.PatientPresenter;
import com.taiji.cubecare.patient.view.adapter.PatientAdapter;
import com.taiji.library.event.TabSelectedEvent;
import com.taiji.library.mvp.schedulers.SchedulerProvider;
import com.taiji.library.ui.fragment.BaseFragment;
import com.taiji.library.util.L;
import com.taiji.library.util.T;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by panho on 2017-9-3.
 */

public class PatientFragment extends BaseFragment implements PatientContract.View {

    @BindView(R.id.patient_rv)
    RecyclerView mPatientRv;
    Unbinder unbinder;
    @BindView(R.id.patient_sr)
    SwipeRefreshLayout mPatientSr;
    private PatientAdapter mPatientAdapter;
    private List<Patient> mPatients = new ArrayList<>();
    private PatientContract.Presenter mPresenter;

    private int mScrollTotal;
    private boolean mInAtTop = true;

    public static PatientFragment newInstance(){
        Bundle args = new Bundle();
        PatientFragment fragment = new PatientFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPatientSr.setColorSchemeColors(ContextCompat.getColor(_mActivity,R.color.colorPrimary));
        mPatientSr.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadPatients("129",true);
            }
        });
        mPatientAdapter = new PatientAdapter(mPatients);
        mPatientAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mPatientRv.setLayoutManager(new LinearLayoutManager(_mActivity));
        mPatientRv.setAdapter(mPatientAdapter);
        mPatientAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.loadPatients("129",false);
            }
        },mPatientRv);
        mPatientAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                T.showShort(_mActivity,"点击了"+((Patient)adapter.getItem(position)).getP_name());
            }
        });

        mPatientRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollTotal+=dy;
                if(mScrollTotal<=0){
                    mInAtTop = true;
                }else {
                    mInAtTop = false;
                }
            }
        });

        mPresenter = new PatientPresenter(_mActivity, this, PatientRepository.getmInstance(_mActivity), SchedulerProvider.getInstance());
        mPresenter.loadPatients("129",true);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void showDataList(List<Patient> data) {
        mPatientAdapter.setNewData(data);
    }

    @Override
    public void showLoadView(boolean isShow) {

    }

    @Override
    public void showError(String errorMessage) {
        mPatientSr.setRefreshing(false);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void loadComplate() {
        mPatientSr.setRefreshing(false);
    }

    @Override
    public void loadMoreList(List<Patient> data) {
        mPatientAdapter.addData(data);
    }

    @Override
    public void loadMoreComplate() {
        mPatientAdapter.loadMoreComplete();
    }

    @Override
    public void loadMoreEnd() {
        mPatientAdapter.loadMoreEnd();
    }

    @Override
    public void loadMoreinit() {

    }

    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event){
        if(event.position!= HomeActivity.FIRST)return;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
