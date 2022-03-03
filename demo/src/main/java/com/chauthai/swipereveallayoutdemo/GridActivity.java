package com.chauthai.swipereveallayoutdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chau Thai on 4/12/16.
 */
public class GridActivity extends AppCompatActivity {
    private GridAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        setupActionBar();
        setupGrid();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (adapter != null) {
            adapter.saveStates(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (adapter != null) {
            adapter.restoreStates(savedInstanceState);
        }
    }

    private void setupGrid() {
        GridView gridView = (GridView) findViewById(R.id.gridview);
        adapter = new GridAdapter(this, createList());
        gridView.setAdapter(adapter);
    }

    private List<String> createList() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add("View " + i);
        }

        return list;
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            toolbar.setNavigationOnClickListener(v -> finish());
        }
    }
}
