package com.glitterlabs.home.skeleton.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glitterlabs.home.skeleton.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmOTP extends Fragment {


    public ConfirmOTP() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirm_ot, container, false);
    }

}
