package com.example.zhufenghua.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by zhufenghua on 2017/5/2.
 */

public class MyView extends RelativeLayout {

    public MyView(final Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_startbtn, this);
        Button btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn_strt", "" + v);
                Toast.makeText(context, "这里还没实现", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public MyView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_startbtn, this);
        Button btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn_strt", "" + v);
                Toast.makeText(context, "这里还没实现", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
