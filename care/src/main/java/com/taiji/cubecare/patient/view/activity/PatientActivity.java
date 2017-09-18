package com.taiji.cubecare.patient.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.taiji.cubecare.R;
import com.taiji.cubecare.order.view.fragment.OrderFragment;
import com.taiji.cubecare.patient.view.fragment.PatientFragment;
import com.taiji.cubecare.record.view.fragment.RecordFragment;
import com.taiji.cubecare.report.view.fragment.ReportFragment;
import com.taiji.cubecare.sign.view.fragment.SignFragment;
import com.taiji.library.http.methods.HttpMethod;
import com.taiji.library.ui.activity.BaseActivity;
import com.taiji.library.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by panho on 2017-9-4.
 */

public class PatientActivity extends BaseActivity{

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;

    private SupportFragment[] mFragments = new SupportFragment[5];

    @BindView(R.id.id_content)
    FrameLayout mIdContent;
    @BindView(R.id.order_btn)
    Button mOrderBtn;
    @BindView(R.id.sign_btn)
    Button mSignBtn;
    @BindView(R.id.record_btn)
    Button mRecordBtn;
    @BindView(R.id.education_btn)
    Button mEducationBtn;
    @BindView(R.id.report_btn)
    Button mReportBtn;

    private FragmentManager mFragmentManager;

    private FragmentTransaction mFragmentTransaction;

    private BaseFragment mPatientFragment;
    private BaseFragment mRecordFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        SupportFragment firstFragment = findFragment(OrderFragment.class);
        if(firstFragment==null){
            mFragments[FIRST] = OrderFragment.newInstance();
            mFragments[SECOND] = SignFragment.newInstance();
            mFragments[THIRD] = RecordFragment.newInstance();
            mFragments[FOURTH] = PatientFragment.newInstance();
            mFragments[FIFTH] = ReportFragment.newInstance();

            loadMultipleRootFragment(R.id.id_content,FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        }else {
            mFragments[FIRST] = mPatientFragment;
            mFragments[SECOND] = findFragment(SignFragment.class);
            mFragments[THIRD] = findFragment(RecordFragment.class);
            mFragments[FOURTH] = findFragment(PatientFragment.class);
            mFragments[FIFTH] = findFragment(ReportFragment.class);
        }

        HttpMethod.setBaseUrl(this, "192.168.0.134", "8080", "eap");

        mFragmentManager = getSupportFragmentManager();
        initButton(123123);

    }

    @OnClick({R.id.order_btn,R.id.sign_btn,R.id.record_btn,R.id.education_btn,R.id.report_btn})
    void onClick(View view){
        initButton(view.getId());
    }

    private void initButton(int id){
        mFragmentTransaction = mFragmentManager.beginTransaction();

        mOrderBtn.setBackgroundResource(R.drawable.iv_order_normal);
        mOrderBtn.setClickable(true);
        mSignBtn.setBackgroundResource(R.drawable.iv_sign_normal);
        mSignBtn.setClickable(true);
        mRecordBtn.setBackgroundResource(R.drawable.iv_record_normal);
        mRecordBtn.setClickable(true);
        mEducationBtn.setBackgroundResource(R.drawable.iv_education_normal);
        mEducationBtn.setClickable(true);
        mReportBtn.setBackgroundResource(R.drawable.iv_report_normal);
        mReportBtn.setClickable(true);

        if(mPatientFragment!=null)
            mFragmentTransaction.hide(mPatientFragment);
        if(mRecordFragment!=null)
            mFragmentTransaction.hide(mRecordFragment);

        switch (id){
            case R.id.order_btn:
                mOrderBtn.setBackgroundResource(R.drawable.iv_order_press);
                mOrderBtn.setClickable(false);
                if(mPatientFragment==null){
                    mPatientFragment = new PatientFragment();
                    mFragmentTransaction.add(R.id.id_content,mPatientFragment);
                }else{
                    mFragmentTransaction.show(mPatientFragment);
                }
                break;
            case R.id.sign_btn:
                mSignBtn.setBackgroundResource(R.drawable.iv_sign_press);
                mSignBtn.setClickable(false);
                if(mPatientFragment==null){
                    mPatientFragment = new PatientFragment();
                    mFragmentTransaction.add(R.id.id_content,mPatientFragment);
                }else{
                    mFragmentTransaction.show(mPatientFragment);
                }
                break;
            case R.id.record_btn:
                mRecordBtn.setBackgroundResource(R.drawable.iv_record_press);
                mRecordBtn.setClickable(false);
                if(mRecordFragment==null){
                    mRecordFragment = new ReportFragment();
                    mFragmentTransaction.add(R.id.id_content,mRecordFragment);
                }else{
                    mFragmentTransaction.show(mRecordFragment);
                }
                break;
            case R.id.education_btn:
                mEducationBtn.setBackgroundResource(R.drawable.iv_education_press);
                mEducationBtn.setClickable(false);
                if(mPatientFragment==null){
                    mPatientFragment = new PatientFragment();
                    mFragmentTransaction.add(R.id.id_content,mPatientFragment);
                }else{
                    mFragmentTransaction.show(mPatientFragment);
                }
                break;
            case R.id.report_btn:
                mReportBtn.setBackgroundResource(R.drawable.iv_report_press);
                mReportBtn.setClickable(false);
                if(mPatientFragment==null){
                    mPatientFragment = new PatientFragment();
                    mFragmentTransaction.add(R.id.id_content,mPatientFragment);
                }else{
                    mFragmentTransaction.show(mPatientFragment);
                }
                break;
            case 123123:
                if(mPatientFragment==null){
                    mPatientFragment = new PatientFragment();
                    mFragmentTransaction.add(R.id.id_content,mPatientFragment);
                }else{
                    mFragmentTransaction.show(mPatientFragment);
                }
                break;
        }
        mFragmentTransaction.commit();
    }

}
