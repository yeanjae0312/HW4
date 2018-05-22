package org.androidtown.hw4;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MemberAdd extends AppCompatActivity {
    EditText et1, et2;
    DatePicker dp;
    Button bt1;

    //데이타베이스 만들기
    SQLiteDatabase db;
    String db_name = "db_member", tb_name = "tb_member";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_add);

        //데이터베이스와 테이블을 생성
        createDB(db_name);
        createTable(tb_name);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        dp = (DatePicker) findViewById(R.id.dp);

        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();
                int month = dp.getMonth()+1;
                int day = dp.getDayOfMonth();
                String datepicker = year+"년 "+month+"월 "+day+" 일";

                //insertRecord(et1.getText().toString(), datepicker, et2.getText().toString());


                Intent intent = new Intent();
                intent.putExtra("name", et1.getText().toString());
                intent.putExtra("birth", datepicker);
                intent.putExtra("mobile", et2.getText().toString());
                setResult(RESULT_OK, intent);

                finish();

            }
        });
    }

    public void createDB(String db_name) {
        try{
            db = openOrCreateDatabase(db_name, Activity.MODE_PRIVATE, null);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createTable(String tb_name) {
        // sql과 동일한 구문이 들어가면 된다. PRIMARY KEY는 중복된 값을 가질 수 없다(가진다면 오류난다.)
        // 띄어쓰기 중요하다.
        db.execSQL("create table if not exists "+tb_name+" ("+"_id integer PRIMARY KEY autoincrement, "
                +"name text, age integer, phone text);"   ); // 동일한 테이블이 없다면 만들어라.

    }

    public void insertRecord(String name, String age, String phone) {
        int n_age = Integer.parseInt(age); // age는 integer로 쓰기 때문에 int로 변환해줘야 한다.

        //text타입은 ''로 묶어줘야한다.
        // 띄어쓰기 중요하다.
        db.execSQL("insert into "+tb_name+" (name, age, phone) values ('"+name+"', "+n_age+", '"+phone+"'); ");

    }
}
