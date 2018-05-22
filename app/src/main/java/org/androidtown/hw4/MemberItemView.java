package org.androidtown.hw4;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sec on 2017-06-05.
 */

public class MemberItemView extends LinearLayout {

    TextView tv1, tv2, tv3;

    public MemberItemView(Context context) {
        super(context);
        init(context);
    }

    public MemberItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    // 초기화하는 함수
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_member_item, this, true);
        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
        tv3 = (TextView) findViewById(R.id.textview3);

    }

    public void setName(String name) {
        tv1.setText(name);
    }
    public void setMobile(String mobile) {
        tv2.setText(mobile);
    }
    public void setDate(String date) {
        tv3.setText(date);
    }
}
