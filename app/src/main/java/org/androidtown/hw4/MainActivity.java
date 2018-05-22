package org.androidtown.hw4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    Button bInformation, bSearch, bAdd;
    TextView bCount;
    ListView listview;

    MemberAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new MemberAdapter();

        bCount = (TextView) findViewById(R.id.bCount);
        listview = (ListView)findViewById(R.id.listview);

        bInformation = (Button)findViewById(R.id.bInformation);

        bSearch = (Button)findViewById(R.id.bSearch);

        bAdd = (Button)findViewById(R.id.bAdd);
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });


    }


    class MemberAdapter extends BaseAdapter {
        ArrayList<MemberItem> items = new ArrayList<MemberItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(MemberItem item) {

            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MemberItemView view = new MemberItemView(getApplicationContext());
            MemberItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setDate(item.getDate());
            return view;
        }

    }
    // 리스트를 추가하기 위한 함수
    public void addItem() {
        Intent intent = new Intent(getApplicationContext(), MemberAdd.class);
        startActivityForResult(intent,REQUEST_CODE_MENU);
    }

    // 인원수를 카운트할 수 있는 함수
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_MENU) {
            if(resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                String birth = data.getStringExtra("birth");
                String num = data.getStringExtra("mobile");
                adapter.addItem(new MemberItem(name,num,birth));
                listview.setAdapter(adapter);
                bCount.setText(adapter.getCount()+"명");
            }
        }
    }

}
