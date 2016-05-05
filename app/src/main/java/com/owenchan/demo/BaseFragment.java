package com.owenchan.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment {
    private static final String KEY_CONTENT = "BaseFragment:Position";
    private int mPosition;


    public static BaseFragment newInstance(int position) {
        BaseFragment fragment = new BaseFragment();
        fragment.mPosition = position;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            mPosition = savedInstanceState.getInt(KEY_CONTENT);
        }
        return inflater.inflate(getLayoutId(mPosition), container, false);
    }

    private int getLayoutId(int position) {
        switch (position) {
            case 0:
                return R.layout.fragment_first_layout;
            case 1:
                return R.layout.fragment_second_layout;
            case 2:
                return R.layout.fagment_third_layout;
            default:
                return 0;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTENT, mPosition);
    }
}
