package com.ahchim.android.basiclist;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ahchim on 2017-01-31.
 */

public class Data {
    private ArrayList<User> datas;
    public static final int DATASIZE = 1000;
    public static final int RANDOM_SET = 80;

    public Data(){
        this.datas = new ArrayList<>();
        load();
    }

    public ArrayList<User> get() {
        return datas;
    }

    private void load(){
        Random random = new Random();

        // datas에 100명의 User를 생성해서 담는다.
        for(int i=0; i<DATASIZE; i++){
            User user = new User();
            user.setId(i+1);
            user.setName("홍길동" + user.getId());
            user.setAge(random.nextInt(RANDOM_SET));

            Log.i("랜덤값: ","number=" + random.nextInt(RANDOM_SET));

            datas.add(user);
        }
    }

}
