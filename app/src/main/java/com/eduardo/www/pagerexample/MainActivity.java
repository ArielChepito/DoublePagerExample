package com.eduardo.www.pagerexample;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.emoiluj.doubleviewpager.DoubleViewPager;
import com.emoiluj.doubleviewpager.DoubleViewPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DoubleViewPager viewPager;
    private int horizontalChild = 4;
    private int verticalChild = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        makePager();


    }


    private void makePager() {
        ArrayList<PagerAdapter> verticalAdapters = new ArrayList<>();
        generateVerticalAdapters(verticalAdapters);
        viewPager = (DoubleViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new DoubleViewPagerAdapter(MainActivity.this, verticalAdapters));
    }

    private void generateVerticalAdapters(ArrayList<PagerAdapter> verticalAdapters) {
        for (int i = 0; i < horizontalChild; i++) {
            verticalAdapters.add(new CustomVerticalAdapter(MainActivity.this, i, verticalChild, this.getSupportFragmentManager()));
        }
    }
}
