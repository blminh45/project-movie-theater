package com.example.movieapp.Profile;

import androidx.fragment.app.Fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.movieapp.InforActivity;
import com.example.movieapp.ProfileActivity;
import com.example.movieapp.R;

import java.util.ArrayList;
import java.util.Calendar;


public class ProfileFragment extends Fragment {

    EditText mEd;
    Button mBtn;
    Calendar c;
    DatePickerDialog dpd;
    private View mRootView;
    private ArrayList<String> list;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.fragment_profile, container, false);
        pick_Date();
        Back();
        Spinner_City();
        Spinner_Ward();
        Spinner_District();
        return mRootView;
    }
    public void pick_Date()
    {
        mEd =(EditText) mRootView.findViewById(R.id.edt_Date);
        mBtn = (Button) mRootView.findViewById(R.id.btn_pick_date);

        mBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                c= Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month=c.get(Calendar.MONTH);
                int year=c.get(Calendar.YEAR);

                dpd=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        mEd.setText(mDay + "/" + (mMonth+1) +"/" + mYear);
                    }
                },day,month,year);
                dpd.show();
            }
        });
    }

    public void Back()
    {
        mBtn = (Button) mRootView.findViewById(R.id.btn_Back);
        mBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InforActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Spinner_City()
    {
        list = new ArrayList<>();
        list.add("Hồ Chí Minh");
        list.add("Hà Nội");
        list.add("Bến Tre");
        list.add("Đà Nẵng");
        list.add("Đà Lạt");
        list.add("Vũng Tàu");
        list.add("Tiền Giang");
        list.add("Cà Mau");
        spinner = (Spinner) mRootView.findViewById(R.id.spin_City);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(spinnerAdapter);
    }

    public void Spinner_District()
    {
        list = new ArrayList<>();
        list.add("Quận 1");
        list.add("Quận 2");
        list.add("Quận 3");
        list.add("Quận 4");
        list.add("Quận 5");
        list.add("Quận 6");
        list.add("Quận 7");
        list.add("Quận 8");
        spinner = (Spinner) mRootView.findViewById(R.id.spin_District);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(spinnerAdapter);
    }

    public void Spinner_Ward()
    {
        list = new ArrayList<>();
        list.add("Phường 1");
        list.add("Phường 2");
        list.add("Phường 3");
        list.add("Phường 4");
        list.add("Phường 5");
        list.add("Phường 6");
        list.add("Phường 7");
        list.add("Phường 8");
        spinner = (Spinner) mRootView.findViewById(R.id.spin_Ward);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(spinnerAdapter);
    }
}