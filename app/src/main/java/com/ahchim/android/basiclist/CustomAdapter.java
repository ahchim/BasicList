package com.ahchim.android.basiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ahchim on 2017-01-31.
 */

public class CustomAdapter extends BaseAdapter {
    private String[] datas;
    private LayoutInflater inflater;

    public CustomAdapter(String[] datas, Context context) {
        // getView 함수에서 사용할 xml 레이아웃을 객체로 변환해 주는 inflater를 가져온다.
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 이거 한 번 이해해보자.
        // xml 코드를 자바 클래스 코드로 바꾸어주는 것이 Inflater.
        // 그동안은 setContentView 로 자동으로 객체로 생성해서 메모리로 올려주었으나
        // 여기서는 커스텀이기 때문에 자동으로 할 수 없기에 이렇게 inflater를 쓴다.
        // 길어서 외울 수 없닼ㅋㅋ

        this.datas = datas;
    }

    /**
     * 사용하는 데이터의 총 개수
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }

    /**
     * 선택된 리스트 아이템
     * @param position
     * @return this.datas[position]
     */
    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**
     * 그냥 아이템의 인덱스 값
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    // 리스트 아답터에서 뷰는 한 행 단위이다.
    // 한 행 단위를 개발자가 직접 만들어서 시스템에 넘겨줘야 한다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. 한 행에 해당하는 레이아웃 xml을 뷰 객체로 만들어준다.
        // inflate 함수 뒤 인자는 항상 그냥 null이당. 걍 그렇게 씀
        // convertView를 돌려쓰기하기 위해서 null일때만 inflate한당.
        // 그 다음부터는 (예시로 5번째?) 가려진 1번째 view를 다시 호출한당.
        if(convertView == null)   // 한번 화면에 세팅됐던 행은 convertView에 담겨져서 돌아온다.
            convertView = inflater.inflate(R.layout.list_item, null);

        // 2. inflate된 뷰를 통해서 findViewById 함수를 사용한다.
        // 액티비티가 아니기 때문에.. view.findViewById
        TextView txtNo = (TextView) convertView.findViewById(R.id.txtNo);
        TextView txtDay = (TextView) convertView.findViewById(R.id.txtDay);

        // 3. inflate된 뷰의 위젯에 값을 세팅한다.
        // 으앙 아까 계속 세팅됐어
        txtNo.setText((position + 1) + "");
        txtDay.setText(datas[position]);

        // 4. 완성된 한 행의 뷰를 시스템에 넘겨준다.
        return convertView;
    }
}
