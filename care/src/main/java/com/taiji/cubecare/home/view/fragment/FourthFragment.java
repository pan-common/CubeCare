package com.taiji.cubecare.home.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taiji.cubecare.R;
import com.taiji.cubecare.record.view.fragment.RecordFragment;
import com.taiji.cubecare.report.view.fragment.ReportFragment;
import com.taiji.library.ui.fragment.BaseFragment;

/**
 * Created by panho on 2017-9-11.
 */

public class FourthFragment extends BaseFragment{

    public static FourthFragment newInstance(){
        Bundle args = new Bundle();
        FourthFragment fragment = new FourthFragment();
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if(findChildFragment(RecordFragment.class)==null){
            loadRootFragment(R.id.layout_container, RecordFragment.newInstance());
        }
    }
}
