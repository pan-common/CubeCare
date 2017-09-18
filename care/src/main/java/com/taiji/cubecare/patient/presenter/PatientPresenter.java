package com.taiji.cubecare.patient.presenter;

import android.content.Context;

import com.taiji.cubecare.patient.data.PatientRepository;
import com.taiji.cubecare.patient.data.entity.Patient;
import com.taiji.library.http.entity.PageInfo;
import com.taiji.library.http.entity.Response;
import com.taiji.library.mvp.schedulers.BaseSchedulerProvider;
import com.taiji.library.ui.helper.PageHelp;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by panho on 2017-9-3.
 */

public class PatientPresenter implements PatientContract.Presenter {

    private PatientContract.View mView;

    private PatientRepository mPatientRepository;

    private Context mContext;

    private BaseSchedulerProvider mSchedulerProvider;

    private CompositeSubscription mSubscription;

    private PageHelp<PageInfo<Patient>> mPageHelp;

    public PatientPresenter(Context context,
                            PatientContract.View view,
                            PatientRepository repository,
                            BaseSchedulerProvider schedulerProvider) {
        this.mContext = context;
        this.mView = view;
        this.mPatientRepository = repository;
        this.mSchedulerProvider = schedulerProvider;

        mSubscription = new CompositeSubscription();
        mPageHelp = new PageHelp<>(20);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscription.clear();
    }

    @Override
    public void loadPatients(String area_id, final boolean isRefresh) {
        if (isRefresh)
            mPageHelp.setPageNum(1);

        mSubscription.clear();
        Subscription subscription = mPatientRepository
                .getPatients(area_id, mPageHelp.getPageNum(), mPageHelp.getPageSize())
                .subscribeOn(mSchedulerProvider.io())
                .unsubscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Subscriber<Response<PageInfo<Patient>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(Response<PageInfo<Patient>> pageInfoResponse) {
                        PageInfo<Patient> patientPageInfo = pageInfoResponse.getBody().getEntity();
                        final List<Patient> patients = patientPageInfo.getList();
                        mPageHelp.startPage(patientPageInfo, new PageHelp.OnPageListener() {
                            @Override
                            public void refresh() {
                                mView.showDataList(patients);
                            }

                            @Override
                            public void loadMoreComplate() {
                                mView.loadMoreList(patients);
                                mView.loadMoreComplate();
                            }

                            @Override
                            public void loadMoreEnd() {
                                mView.loadMoreList(patients);
                                mView.loadMoreEnd();
                            }
                        },isRefresh);
                        mView.loadComplate();
                    }
                });
        mSubscription.add(subscription);
    }
}
