package com.wlw.admin.mvp;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.wlw.admin.mvp.adapter.MainFragmentPagerAdapter;
import com.wlw.admin.mvp.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bottomNavigationView = findViewById(R.id.design_bottom);
        viewPager = findViewById(R.id.viewPager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener((menuItem) -> {
            int position = 0;
            switch (menuItem.getItemId()) {
                case R.id.item_home:
                    position = 0;
                    break;
                case R.id.item_chat:
                    position = 1;
                    break;
                case R.id.item_company:
                    position = 2;
                    break;
                case R.id.item_mine:
                    position = 3;
                    break;
            }
            viewPager.setCurrentItem(position);
            return true;

        });




        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                selectedMenuItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void selectedMenuItem(int position) {
        MenuItem item = bottomNavigationView.getMenu().getItem(position);
        bottomNavigationView.setSelectedItemId(item.getItemId());
    }
}
