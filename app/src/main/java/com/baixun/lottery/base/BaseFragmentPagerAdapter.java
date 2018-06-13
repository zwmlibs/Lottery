package com.baixun.lottery.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zwm on 2018/1/22.
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public BaseFragmentPagerAdapter(ArrayList<Fragment> fragments, FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub

        if(null != fragments.get(arg0)){
            return fragments.get(arg0);
        }
        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fragments.size();
    }

}