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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class ProfileFragment extends Fragment {

    EditText mEdDate, mEdUser, mEdName, mEdPass, mEdDiaChi, mEdSDT;
    Button mBtnDate, mBtnBack;
    Calendar cal;
    String Name,SDT,DiaChi,Email,NgaySinh,Pass;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView= inflater.inflate(R.layout.fragment_profile, container, false);
        getFormWidgets();
        getDefaultInfor();
        pick_Date();
        Back();
        return mRootView;
    }

    public void getFormWidgets()
    {
        Intent intent = getActivity().getIntent();
        if(intent.getIntExtra("key",1) == 0){
         Email = "Email@gmail.com";
         Pass="Pass";
         Name="Tên người dùng";
         SDT="0123456789";
         NgaySinh="2000-1-1";
         DiaChi="Địa chỉ";
        }
        else{
            Email = intent.getStringExtra("Email");
            Pass = intent.getStringExtra("Pass");
            Name =intent.getStringExtra("Ten");
            SDT = intent.getStringExtra("SDT");
            NgaySinh = intent.getStringExtra("Ngaysinh");
            DiaChi =intent.getStringExtra("Diachi");
        }

        mEdUser = mRootView.findViewById(R.id.edt_UserName);
        mEdPass = mRootView.findViewById(R.id.edt_Pass);
        mEdName = mRootView.findViewById(R.id.edt_Name);
        mEdSDT = mRootView.findViewById(R.id.edt_Phone);
        mEdDate = mRootView.findViewById(R.id.edt_Date);
        mEdDiaChi = mRootView.findViewById(R.id.edt_Address);
        mBtnDate = mRootView.findViewById(R.id.btn_pick_date);
        mBtnBack= mRootView.findViewById(R.id.btn_Back);

            mEdUser.setText(Email);
            mEdPass.setText(Pass);
            mEdName.setText(Name);
            mEdSDT.setText(SDT);
            mEdDate.setText(NgaySinh);
            mEdDiaChi.setText(DiaChi);
    }

    public void getDefaultInfor()
    {
        //lấy ngày hiện tại của hệ thống
        cal=Calendar.getInstance();
        String s=mEdDate.getText()+"";
        String strArrtmp[]=s.split("-");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1])-1;
        int nam=Integer.parseInt(strArrtmp[2]);

        cal.set(ngay,thang,nam);
    }

    public void pick_Date()
    {
        mBtnDate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener(){
                    public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                        //Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView Date
                        mEdDate.setText(dayOfMonth +"-"+(monthOfYear+1)+"-"+year);
                        //Lưu vết lại biến ngày hoàn thành
                        cal.set(dayOfMonth, monthOfYear, year);
                    }
                };
                //các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
                //sẽ giống với trên TextView khi mở nó lên
                String s=mEdDate.getText()+"";
                String strArrtmp[]=s.split("-");
                int ngay=Integer.parseInt(strArrtmp[0]);
                int thang=Integer.parseInt(strArrtmp[1])-1;
                int nam=Integer.parseInt(strArrtmp[2]);
                DatePickerDialog pic=new DatePickerDialog(getContext(),
                        callback, ngay, thang, nam);
                pic.setTitle("Chọn ngày sinh");
                pic.show();
            }

        });
    }

    public void Back()
    {
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),InforActivity.class);
                startActivity(intent);
            }
        });
    }

//    public void Spinner_City()
//    {
//        list = new ArrayList<>();
//        list.add("Hồ Chí Minh");
//        list.add("Hà Nội");
//        list.add("Bến Tre");
//        list.add("Đà Nẵng");
//        list.add("Đà Lạt");
//        list.add("Vũng Tàu");
//        list.add("Tiền Giang");
//        list.add("Cà Mau");
//        spinner = (Spinner) mRootView.findViewById(R.id.spin_City);
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
//        spinner.setAdapter(spinnerAdapter);
//    }
//
//    public void Spinner_District()
//    {
//        list = new ArrayList<>();
//        list.add("Quận 1");
//        list.add("Quận 2");
//        list.add("Quận 3");
//        list.add("Quận 4");
//        list.add("Quận 5");
//        list.add("Quận 6");
//        list.add("Quận 7");
//        list.add("Quận 8");
//        spinner = (Spinner) mRootView.findViewById(R.id.spin_District);
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
//        spinner.setAdapter(spinnerAdapter);
//    }
//
//    public void Spinner_Ward()
//    {
//        list = new ArrayList<>();
//        list.add("Phường 1");
//        list.add("Phường 2");
//        list.add("Phường 3");
//        list.add("Phường 4");
//        list.add("Phường 5");
//        list.add("Phường 6");
//        list.add("Phường 7");
//        list.add("Phường 8");
//        spinner = (Spinner) mRootView.findViewById(R.id.spin_Ward);
//        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
//        spinner.setAdapter(spinnerAdapter);
//    }
}