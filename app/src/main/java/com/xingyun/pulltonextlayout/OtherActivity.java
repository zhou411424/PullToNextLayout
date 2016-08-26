package com.xingyun.pulltonextlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mingle.pulltonextlayout.OnItemSelectListener;
import com.mingle.pulltonextlayout.PullToNextLayout;
import com.mingle.pulltonextlayout.adapter.PullToNextModelAdapter;
import com.mingle.pulltonextlayout.model.PullToNextModel;
import com.xingyun.pulltonextlayout.model.OtherViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyun on 2016/8/26.
 */
public class OtherActivity extends AppCompatActivity {

    private PullToNextLayout mPullToNextLayout;
    private List<PullToNextModel> mModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        mPullToNextLayout = (PullToNextLayout) findViewById(R.id.pulltonextlayout);
        mModelList = new ArrayList<>();

        mModelList.add(new OtherViewModel(0));
        mModelList.add(new OtherViewModel(1));
        mModelList.add(new OtherViewModel(2));
        mModelList.add(new OtherViewModel(3));

        mPullToNextLayout.setAdapter(new PullToNextModelAdapter(this, mModelList));

        mPullToNextLayout.setOnItemSelectListener(new OnItemSelectListener() {
            @Override
            public void onSelectItem(int position, View view) {
                Toast.makeText(OtherActivity.this, "onSelectItem==>position="+position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
