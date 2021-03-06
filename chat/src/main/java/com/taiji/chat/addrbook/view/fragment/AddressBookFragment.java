package com.taiji.chat.addrbook.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taiji.chat.R;
import com.taiji.chat.home.fragment.MainFragment;
import com.taiji.library.event.TabSelectedEvent;
import com.taiji.library.ui.fragment.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by panho on 2017-9-18.
 */

public class AddressBookFragment extends BaseFragment{

    public static AddressBookFragment newInstance(){
        Bundle args = new Bundle();

        AddressBookFragment fragment = new AddressBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_book,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }

    @Subscribe
    public void onTabSelectedEvent(TabSelectedEvent event){
        if(event.position != MainFragment.FIRST)
            return;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
