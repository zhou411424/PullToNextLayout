package com.xingyun.pulltonextlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mingle.pulltonextlayout.OnItemSelectListener;
import com.mingle.pulltonextlayout.PullToNextLayout;
import com.mingle.pulltonextlayout.adapter.PullToNextModelAdapter;
import com.mingle.pulltonextlayout.model.PullToNextModel;
import com.xingyun.pulltonextlayout.model.ScrollViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyun on 2016/8/26.
 */
public class ScrollViewActivity extends AppCompatActivity {

    private PullToNextLayout mPullToNextLayout;
    private List<PullToNextModel> mModelList;
    private int  currentIndex = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);
        mPullToNextLayout = (PullToNextLayout) findViewById(R.id.pulltonextlayout);
        Button toTopBtn = (Button) findViewById(R.id.to_top_btn);
        Button deleteItemBtn = (Button) findViewById(R.id.delete_item_btn);
        toTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPullToNextLayout.setCurrentItem(0);
            }
        });
        deleteItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPullToNextLayout.deleteCurrentItem();
            }
        });

        mModelList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            mModelList.add(new ScrollViewModel(currentIndex++));
        }

        mPullToNextLayout.setAdapter(new PullToNextModelAdapter(this, mModelList));
        mPullToNextLayout.setOnItemSelectListener(new OnItemSelectListener() {
            @Override
            public void onSelectItem(int position, View view) {
                Toast.makeText(ScrollViewActivity.this, "onSelectItem==>position="+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
