package com.taiji.library.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.taiji.library.R;
import com.taiji.library.ui.activity.BaseActivity;
import com.taiji.library.util.T;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * 作者：panho on 2016-12-26 16:22
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class BaseFragment extends SupportFragment{

    protected OnBackToFirstListener mBackToFirstListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnBackToFirstListener) {
            mBackToFirstListener = (OnBackToFirstListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mBackToFirstListener = null;
    }

    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            // 如果不是,则回到第一个Fragment
                mBackToFirstListener.onBackToFirstFragment();
        }
        return true;
    }

    public interface OnBackToFirstListener {
        void onBackToFirstFragment();
    }
}
