package com.taiji.chat.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.taiji.chat.R;
import com.taiji.chat.home.fragment.MainFragment;
import com.taiji.library.ui.activity.BaseActivity;
import com.taiji.library.ui.fragment.BaseFragment;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class HomeActivity extends BaseActivity implements BaseFragment.OnBackToFirstListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(findFragment(MainFragment.class)==null){
            loadRootFragment(R.id.layout_container,MainFragment.newInstance());
        }

    }

    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void onBackToFirstFragment() {

    }
}
