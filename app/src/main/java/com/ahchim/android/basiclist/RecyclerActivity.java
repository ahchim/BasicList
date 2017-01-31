package com.ahchim.android.basiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    ArrayList<User> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Data data = new Data();
        // 모듈화를 매번 해주면 좋다.
        datas = data.get();

        //(listview에 holder 까지 들어가있는)
        // 1. Recycler 뷰 가져오기
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 2. Adapter 생성하기
        RecyclerCustomAdapter recyclerCustomAdapter = new RecyclerCustomAdapter(datas, R.layout.list_holder_item);
        // 뒤 인자가 itemLayout id값이라는 것을 잊지 말자.
        // list_holder_item 재사용함.


        // 3. Recycler 뷰에 Adapter 세팅하기
        recyclerView.setAdapter(recyclerCustomAdapter);

        // 4. Recycler 뷰 매니저 등록하기... (뷰의모양을 결정 : 그리드, 일반리스트, 비대칭그리드)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
