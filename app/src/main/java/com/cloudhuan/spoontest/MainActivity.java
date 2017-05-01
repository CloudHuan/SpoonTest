package com.cloudhuan.spoontest;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    TextView tv;
    String[] strings = {"test00","test01","test02"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)this.findViewById(R.id.btn);
        tv = (TextView)this.findViewById(R.id.tv);
        btn.setOnClickListener(new BtnListener());
    }

    class BtnListener implements View.OnClickListener{

        int num = 0;

        @Override
        public void onClick(View v) {
            tv.setText(strings[num++]);
            if (num > 2) {
                num = 0;
            }
        }
    }
}
