package com.ahchim.android.basiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {
    ArrayList<User> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);

        Data data = new Data();
        // 모듈화를 매번 해주면 좋다.
        datas = data.get();

        // 1. 리스트 뷰 가져오기
        ListView listView = (ListView) findViewById(R.id.listView);

        // 2. 아답터 생성
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas, this);

        // 3. 리스트 뷰에 아답터 세팅
        listView.setAdapter(adapter);
    }

}
