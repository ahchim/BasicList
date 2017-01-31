package com.ahchim.android.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ahchim on 2017-01-31.
 */
//                                                    여기 제네릭을봐 ㅠㅠㅠ 미쳤어; 여튼 함수만들고 뒤에 붙여준다.
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder>{
    ArrayList<User> datas;
    // 리스트 각 행에서 사용되는 레이아웃 xml의 아이디.
    Context context; // 클릭처리, 애니메이션 등을 위해 시스템 자원 사용이 필요.

    // 뒷 인자에서 화면에 뿌려줄 레이아웃을 주고받는다. integer 아이디로 (으으 예전에 뜯어봤던 그거 끔찍ㅋㅋ)
    public CardAdapter(ArrayList<User> datas, Context context){
        this.datas = datas;
        this.context = context;
    }

    // View를 생성해서 홀더에 저장하는 역할 (개발자가 관리하지 않는다.)
    // 선언변수 CustomViewHolder로 교체
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //                                                                              attachToRoot : 내부 리스트 더 붙일 때.. 거의 false로 쓴다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
                    // context.getSystemService(~~) 와 같은 코드
        return new CustomViewHolder(view);
    }

    // listView 에서의 getView를 대체하는 함수.
    // list가 한개 생성될 때마다 호출된당.
    // 첫번째 인자 CustomViewHolder로 교체
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        // 이게 final로 정의되야한다닠ㅋㅋㅋㅋ intent.putExtra 에서 값을 넣을 때 user값이 고정되어야 하므로 그렇다.
        final User user = datas.get(position);

        holder.getTxtId().setText(user.getId() + "");
        holder.getTxtName().setText(user.getName());
        holder.getTxtAge().setText(user.getAge() + "");

        holder.getCardView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.getId());
                intent.putExtra("day", user.getName());

                context.startActivity(intent);
            }
        });

        // cardview 애니메이션 동작시키기                              무언가 정의되어 있는 부분 -> android.R.~
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left); // 속성이 정의되어 있는 애니메이션 xml
        // 뷰에 정의한 애니메이션을 세팅해준다.
        holder.cardView.setAnimation(animation);
    }

    // 데이터 총 개수
    @Override
    public int getItemCount() {
        return datas.size();
    }

    // <VH>로 ViewHolder를 제네릭으로 넣어줘야 하기 때문에 매번 하기 그래서 CustomViewHolder 생성기를 만듬.
    // Recycler 뷰에서 사용하는 뷰홀더
    // 이 뷰홀더를 사용하는 Adapter는 generic으로 선언된 부모객체를 상속받아 구현해야 한다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView txtId, txtName, txtAge;
        private CardView cardView;

        public CustomViewHolder(View view) {
            super(view);

            // 생성자가 호출되는 순간(new 하는 순간) 내부의 위젯을 생성해서 변수에 담아둔다.
            this.txtId = (TextView) view.findViewById(R.id.txtId);
            this.txtName = (TextView) view.findViewById(R.id.txtName);
            this.txtAge = (TextView) view.findViewById(R.id.txtAge);

            this.cardView = (CardView) view.findViewById(R.id.cardView);
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

        public CardView getCardView() { return cardView; }
    }
}
