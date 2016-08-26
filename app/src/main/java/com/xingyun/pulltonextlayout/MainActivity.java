package com.xingyun.pulltonextlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button otherBtn = (Button) findViewById(R.id.other_btn);
        Button scrollViewBtn = (Button) findViewById(R.id.scroll_view_btn);
        Button webViewBtn = (Button) findViewById(R.id.web_view_btn);
        otherBtn.setOnClickListener(this);
        scrollViewBtn.setOnClickListener(this);
        webViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.other_btn:
                Intent intent1 = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent1);
                break;
            case R.id.scroll_view_btn:
                break;
            case R.id.web_view_btn:
                break;
        }
    }
}
