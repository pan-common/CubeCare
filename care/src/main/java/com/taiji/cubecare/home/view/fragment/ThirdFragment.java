package com.taiji.cubecare.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taiji.cubecare.R;
import com.taiji.cubecare.report.view.fragment.ReportFragment;
import com.taiji.cubecare.sign.view.fragment.SignFragment;
import com.taiji.library.ui.fragment.BaseFragment;

/**
 * Created by panho on 2017-9-11.
 */

public class ThirdFragment extends BaseFragment{

    public static ThirdFragment newInstance(){
        Bundle args = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if(findChildFragment(SignFragment.class)==null){
            loadRootFragment(R.id.layout_container, SignFragment.newInstance());
        }
    }

}
