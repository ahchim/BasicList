package com.ahchim.android.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ahchim on 2017-01-31.
 */
// 실습 때 ListHolderActivity 아래에 있었으나 통일성을 위해..
public class CustomHolderAdapter extends BaseAdapter {
    ArrayList<User> datas;
    LayoutInflater inflater;

    // Context 로 받는게 좋다.
    public CustomHolderAdapter(ArrayList<User> datas, Context context) {
        this.datas = datas;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        // 뷰 행이 화면에 보여져서 생성된 적이 있다면 재사용
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_holder_item, null);
            // 생성한 위젯을 담아놓기 위한 임시 공간
            // 속도가 어마어마하게 빨라짐. 화면의 n개만 만들고 계속 재사용한다.
            holder = new Holder();

            // 위젯을 생성해서 holder에 담는다
            holder.setTxtId((TextView) convertView.findViewById(R.id.txtId));
            holder.setTxtName((TextView) convertView.findViewById(R.id.txtName));
            holder.setTxtAge((TextView) convertView.findViewById(R.id.txtAge));

            convertView.setTag(holder);
        } else{
            holder = (Holder) convertView.getTag();
        }

        // 사용할 데이터  instance를 ArrayList에서 꺼낸다
        User user = datas.get(position);

        holder.getTxtId().setText(user.getId() + "");
        holder.getTxtName().setText(user.getName());
        holder.getTxtAge().setText(user.getAge() + "");

        return convertView;
    }

    // 각 행에서 사용되는 위젯을 재사용하기 위한 Holder 클래스
    class Holder {
        private TextView txtId;
        private TextView txtName;
        private TextView txtAge;

        public void setTxtId(TextView txtId) {
            this.txtId = txtId;
        }

        public void setTxtName(TextView txtName) {
            this.txtName = txtName;
        }

        public void setTxtAge(TextView txtAge) {
            this.txtAge = txtAge;
        }

        public TextView getTxtId() {
            return txtId;
        }

        public TextView getTxtName() {
            return txtName;
        }

        public TextView getTxtAge() {
            return txtAge;
        }
    }
}