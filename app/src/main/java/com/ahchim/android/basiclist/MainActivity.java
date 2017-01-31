package com.ahchim.android.basiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnList, btnHolder, btnRecycler, btnRecyclerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnList = (Button) findViewById(R.id.btnList);
        btnHolder = (Button) findViewById(R.id.btnHolder);
        btnRecycler = (Button) findViewById(R.id.btnRecycler);
        btnRecyclerCard = (Button) findViewById(R.id.btnRecyclerCard);

        // 2. 리스너를 세팅한다.
        btnList.setOnClickListener(listener);
        btnHolder.setOnClickListener(listener);
        btnRecycler.setOnClickListener(listener);
        btnRecyclerCard.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch(v.getId()){
                case R.id.btnList:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    break;
                case R.id.btnHolder:
                    intent = new Intent(MainActivity.this, ListHolderActivity.class);
                    break;
                case R.id.btnRecycler:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.btnRecyclerCard:
                    intent = new Intent(MainActivity.this, RecyclerCardActivity.class);
                    break;
            }
            startActivity(intent);
        }
    };
}
