package com.namewu.androidlearningnotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private RecycleviewAdapter recycleviewAdapter;
    private ArrayList<Note> listdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        initView();
    }

    private void initDate() {
        listdata.add(new Note("阿违法姐啊了就","好那个卡挤公交阿额立刻赶赴南京阿文化宫阿额会努力"));
        listdata.add(new Note("金刚狼领导机构阿娇可怜","天气没号阿发恶法俄法阿违法阿违法噶我额天气没" +
                "号阿发恶法俄法阿违法阿违法噶我额天气没号阿发恶法俄法阿违法阿违法噶我额"));
        listdata.add(new Note("吴振宇","阿尔法阿额额阿我为 "));
        listdata.add(new Note("哈哈哈哈","恶搞瓦罐煨个噶we噶围观然后他哈饿好热"));
    }

    private void initView() {
        recyclerview = (RecyclerView) findViewById(R.id.recycler_show);
        recycleviewAdapter = new RecycleviewAdapter(this,listdata);
        recyclerview.setAdapter(recycleviewAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
    }
}
