package com.glitterlabs.home.skeleton1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneNumber extends Fragment {


    private EditText number;
    private Button phoneSubmit;
    private Spinner spinner;
    String codeSent;

    public PhoneNumber() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone__number, container, false);
        phoneSubmit = view.findViewById(R.id.btnPhone);
        number = view.findViewById(R.id.phone_Text);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_phone__number, container, false);
        phoneSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number.getText().toString().equals("")){
                    return;
                }

                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new ConfirmOTP(),null).commit();
                //sendVerificationCode();
            }


        });
        return view;
    }

}
