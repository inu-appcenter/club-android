package com.jhyejin99.inuclub.Settings;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jhyejin99.inuclub.R;

import java.util.ArrayList;


public class Setting extends Fragment {

    ListView settingList;
    SettingListAdapter settingListAdapter ;
    TextView student_name; //이름
    TextView student_num; //학번
    String club_num;
    int c_num;

    public Setting() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting, container, false);
        student_name = (TextView) view.findViewById(R.id.student_name);
        student_num = (TextView)view.findViewById(R.id.student_num);

        // 가상키보드 숨김
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager touch_hide = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                touch_hide.hideSoftInputFromWindow(container.getWindowToken(), 0);
            }
        });

        Intent intent = getActivity().getIntent();
        club_num = intent.getStringExtra("clubIDNumber");
        String noLogin = "로그인 하세요";

        if(club_num == null)
            student_name.setText(noLogin);

        else {
            c_num=Integer.parseInt(club_num);
            getClubName();
        }

        settingList = (ListView) view.findViewById(R.id.setting_list);
        settingListAdapter = new SettingListAdapter();
        settingList.setAdapter(settingListAdapter);
        settingList.setDivider(new ColorDrawable(Color.TRANSPARENT));

        final ArrayList<String> settingArrayList = new ArrayList<String>();

        settingArrayList.add("행사 관리");
        settingArrayList.add("동아리 소개 수정");
        settingArrayList.add("알림 설정");

        if(student_name.getText().toString() == noLogin)
            settingArrayList.add("로그인");
        else
            settingArrayList.add("로그아웃");

        for(int i=0;i<settingArrayList.size();i++) {
            String setting_name = settingArrayList.get(i);
            settingListAdapter.addItem(setting_name);
        }

        settingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //String strColor = "#ffa292";
                //TextView settingname = view.findViewById(R.id.setting_list_item);
                //settingname.setTextColor(Color.parseColor(strColor));
                //settingname.setTextSize(22);
                //settingname.setTypeface(null,Typeface.BOLD);

                Intent intent = new Intent(getActivity(), Loading.class);
                intent.putExtra("settingValue", settingArrayList.get(position).toString());
                //intent.putExtra("clubIdNumber", club_num);
                startActivity(intent);

                /* if(settingArrayList.get(4).toString() == "로그인") {
                    if (settingArrayList.get(position).toString() == "로그인") {
                        Intent intent = new Intent(getActivity(), Loading.class);
                        intent.putExtra("settingValue", settingArrayList.get(position).toString());
                        intent.putExtra("clubIDNumber", club_num);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getActivity(),"로그인이 필요한 서비스입니다",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else{
                    if(settingArrayList.get(5).toString() == "로그아웃"){
                        if(settingArrayList.get(position).toString() == "로그아웃"){
                            getActivity().finish();
                        }

                        else{
                            Intent intent = new Intent(getActivity(), Loading.class);
                            intent.putExtra("settingValue", settingArrayList.get(position).toString());
                            intent.putExtra("clubIdNumber", club_num);
                            startActivity(intent);
                        }
                    }
                } */

                }
        });

       return view;
    }

    public void getClubName() {
        // 서버에서 학생이름 가져와 setText
    }
}

