package com.ahchim.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {
    ArrayList<User> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        datas = data.get();

        // 1. 리스트뷰 가져오기
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 2. 아답터 생성
        CardAdapter cardAdapter = new CardAdapter(datas, this);

        // 3. 리스트뷰에 아답터 세팅
        recyclerView.setAdapter(cardAdapter);

        // 4. 레이아웃 매니저 세팅
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // (4단계 고정)
    }
}
