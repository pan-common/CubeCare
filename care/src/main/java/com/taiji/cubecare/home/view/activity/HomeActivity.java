package com.taiji.cubecare.home.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.taiji.cubecare.R;
import com.taiji.cubecare.common.netty.NettyClient;
import com.taiji.cubecare.home.view.fragment.FifthFragment;
import com.taiji.cubecare.home.view.fragment.FirstFragment;
import com.taiji.cubecare.home.view.fragment.FourthFragment;
import com.taiji.cubecare.home.view.fragment.SecondFragment;
import com.taiji.cubecare.home.view.fragment.ThirdFragment;
import com.taiji.cubecare.order.view.fragment.OrderFragment;
import com.taiji.cubecare.patient.view.fragment.PatientFragment;
import com.taiji.cubecare.record.view.fragment.RecordFragment;
import com.taiji.cubecare.report.view.fragment.ReportFragment;
import com.taiji.cubecare.sign.view.fragment.SignFragment;
import com.taiji.library.event.TabSelectedEvent;
import com.taiji.library.http.methods.HttpMethod;
import com.taiji.library.ui.activity.BaseActivity;
import com.taiji.library.ui.fragment.BaseFragment;
import com.taiji.library.ui.view.BottomBar;
import com.taiji.library.ui.view.BottomBarTab;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by panho on 2017-9-11.
 */

public class HomeActivity extends BaseActivity implements BaseFragment.OnBackToFirstListener{

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private SupportFragment[] mFragments = new SupportFragment[5];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        SupportFragment firstFragment = findFragment(FirstFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FirstFragment.newInstance();
            mFragments[SECOND] = SecondFragment.newInstance();
            mFragments[THIRD] = ThirdFragment.newInstance();
            mFragments[FOURTH] = FourthFragment.newInstance();
            mFragments[FIFTH] = FifthFragment.newInstance();

            loadMultipleRootFragment(R.id.id_content, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIFTH]);
        } else {
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(SecondFragment.class);
            mFragments[THIRD] = findFragment(ThirdFragment.class);
            mFragments[FOURTH] = findFragment(FourthFragment.class);
            mFragments[FIFTH] = findFragment(FifthFragment.class);
        }

        try {
            NettyClient client = new NettyClient("47.94.152.187",2017);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HttpMethod.setBaseUrl(this, "192.168.31.154", "8080", "eap");

        initView();

    }

    private void initView() {
        mBottomBar.addItem(new BottomBarTab(this,R.drawable.ic_hotel, R.string.patient))
                .addItem(new BottomBarTab(this,R.drawable.ic_library_books,R.string.order))
                .addItem(new BottomBarTab(this,R.drawable.ic_person,R.string.sign))
                .addItem(new BottomBarTab(this,R.drawable.ic_description,R.string.record))
                .addItem(new BottomBarTab(this,R.drawable.ic_wallpaper,R.string.report));
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position],mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                final SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();
                if(count>1){
                    if(currentFragment instanceof FirstFragment){
                        currentFragment.popToChild(PatientFragment.class,false);
                    }else if(currentFragment instanceof SecondFragment){
                        currentFragment.popToChild(OrderFragment.class,false);
                    }else if(currentFragment instanceof ThirdFragment){
                        currentFragment.popToChild(SignFragment.class,false);
                    }else if(currentFragment instanceof FourthFragment){
                        currentFragment.popToChild(RecordFragment.class,false);
                    }else if(currentFragment instanceof FifthFragment){
                        currentFragment.popToChild(ReportFragment.class,false);
                    }
                    return;
                }

                if(count==1){
                    EventBus.getDefault().post(new TabSelectedEvent(position));
                }

            }
        });
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void onBackToFirstFragment() {
        mBottomBar.setCurrentItem(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
