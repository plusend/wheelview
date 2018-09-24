package com.plusend.wheelview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button addView;
    private Button deleteView;
    private Button allView;

    private List<String> wheelDataItemList;
    private WheelAdapter wheelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addView = findViewById(R.id.add);
        deleteView = findViewById(R.id.delete);
        allView = findViewById(R.id.all);

        addView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                wheelDataItemList.add("add");
//                wheelAdapter.notifyItemInserted(wheelDataItemList.size() - 1);
                wheelAdapter.add("add");
                wheelAdapter.notifyItemInserted(0);
                wheelAdapter.notifyItemChanged(1);
                recyclerView.scrollToPosition(0);
            }
        });

        deleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelDataItemList.remove(0);
                wheelAdapter.notifyItemRemoved(0);
            }
        });

        allView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheelDataItemList.remove(0);
                wheelDataItemList.add("all");
                wheelAdapter.notifyItemRemoved(0);
                wheelAdapter.notifyItemInserted(wheelDataItemList.size() - 1);
            }
        });

        wheelDataItemList = new ArrayList<>();
        wheelAdapter = new WheelAdapter(wheelDataItemList);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(wheelAdapter);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        initData();
    }

    private void initData() {
        for (int i = 0; i < 2; i++) {
            wheelDataItemList.add("item " + i);
        }

        wheelAdapter.notifyDataSetChanged();
    }


}
