package com.android.swanandroid;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.base.BaseActivity;
import com.android.core.prefs.Constants;
import com.android.swanandroid.fragment.KnowledgeHierarchyFragment;
import com.android.swanandroid.fragment.NavigationFragment;
import com.android.swanandroid.fragment.ProjectFragment;
import com.android.swanandroid.fragment.leftnav.CollectFragment;
import com.android.swanandroid.fragment.leftnav.SettingFragment;
import com.android.utils.StatusBarUtil;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private ArrayList<Fragment> mFragments;
    private KnowledgeHierarchyFragment mKnowledgeHierarchyFragment;
    private NavigationFragment mNavigationFragment;
    private ProjectFragment mProjectFragment;
    private FloatingActionButton mFloatingActionButton;
    private BottomNavigationView mBottomNavigationView;
    private NavigationView mNavigationView;
    private int mLastFgIndex;
    private TextView mToorbarText;
    private Toolbar mToolbar;

    @Override
    protected void initEventAndData() {
        initToolBarAndRes();
        initFragment();
    }
    private void initFragment() {
        mFragments = new ArrayList<>();
        mKnowledgeHierarchyFragment = KnowledgeHierarchyFragment.newInstance(null, null);
        mNavigationFragment = NavigationFragment.newInstance(null, null);
        mProjectFragment = ProjectFragment.newInstance(null, null);
        CollectFragment collectFragment = CollectFragment.newInstance(null, null);
        SettingFragment settingFragment = SettingFragment.newInstance(null, null);

        mFragments.add(mKnowledgeHierarchyFragment);
        mFragments.add(mNavigationFragment);
        mFragments.add(mProjectFragment);
        mFragments.add(collectFragment);
        mFragments.add(settingFragment);
    }

    private void initToolBarAndRes() {
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.main_status_bar_blue), 1f);
        mFloatingActionButton = findViewById(R.id.main_floating_action_btn);
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mNavigationView = findViewById(R.id.nav_view);
        mToorbarText = findViewById(R.id.common_toolbar_title_tv);
        mToolbar = findViewById(R.id.common_toolbar);
        //initToorbar
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mToorbarText.setText(getString(R.string.home_pager));
        mFloatingActionButton.setOnClickListener(this);
        mToolbar.setNavigationOnClickListener(this);
    }

    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_floating_action_btn:
                jumpToTheTop();
                break;
        }
    }

    private void jumpToTheTop() {
        //
    }


}
