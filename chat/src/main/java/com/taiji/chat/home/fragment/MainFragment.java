package com.taiji.chat.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.taiji.chat.R;
import com.taiji.chat.addrbook.view.fragment.AddressBookFragment;
import com.taiji.chat.message.view.fragment.MessageFragment;
import com.taiji.chat.mine.view.fragment.MineFragment;
import com.taiji.library.event.TabSelectedEvent;
import com.taiji.library.ui.fragment.BaseFragment;
import com.taiji.library.ui.view.BottomBar;
import com.taiji.library.ui.view.BottomBarTab;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by panho on 2017-9-18.
 */

public class MainFragment extends BaseFragment {

    private static final int REQ_MSG = 10;

    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    @BindView(R.id.fl_tab_container)
    FrameLayout mFlTabContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;
    Unbinder unbinder;

    private SupportFragment[] mFragments = new SupportFragment[3];

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(MessageFragment.class);
        if(firstFragment==null){
            mFragments[FIRST] = MessageFragment.newInstance();
            mFragments[SECOND] = AddressBookFragment.newInstance();
            mFragments[THIRD] = MineFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container,FIRST,
                    mFragments[FIRST],mFragments[SECOND],mFragments[THIRD] );
        }else {
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(AddressBookFragment.class);
            mFragments[THIRD] = findChildFragment(MineFragment.class);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBottomBar
                .addItem(new BottomBarTab(_mActivity,R.drawable.ic_message,R.string.message))
                .addItem(new BottomBarTab(_mActivity,R.drawable.ic_people,R.string.addressbook))
                .addItem(new BottomBarTab(_mActivity,R.drawable.ic_person,R.string.mine));

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
                EventBus.getDefault().post(new TabSelectedEvent(position));
            }
        });
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if(requestCode == REQ_MSG&&resultCode == RESULT_OK){

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
