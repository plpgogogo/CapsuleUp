package com.plpgogogo.capsuleup;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.plpgogogo.capsuleup.database.DaoMaster;
import com.plpgogogo.capsuleup.database.DaoSession;
import com.plpgogogo.capsuleup.database.DataDao;
import com.plpgogogo.capsuleup.database.UserDao;
import com.plpgogogo.capsuleup.utils.TintUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private ViewPager viewPager;
    private ImageView analysisIndicator;
    private ImageView recordIndicator;
    private ImageView queryIndicator;
    private List<Fragment> fragments;

    public static SQLiteDatabase db;
    public static DaoMaster daoMaster;
    public static DaoSession daoSession;
    public static DataDao dataDao;
    public static UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        analysisIndicator = (ImageView) findViewById(R.id.analysisIndicator);
        recordIndicator = (ImageView) findViewById(R.id.recordIndicator);
        queryIndicator = (ImageView) findViewById(R.id.queryIndicator);

        analysisIndicator.setOnClickListener(this);
        recordIndicator.setOnClickListener(this);
        queryIndicator.setOnClickListener(this);

        fragments = new ArrayList<>();
        AnalysisFragment analysisFragment = new AnalysisFragment();
        RecordFragment recordFragment = new RecordFragment();
        QueryFragment queryFragment = new QueryFragment();
        fragments.add(analysisFragment);
        fragments.add(recordFragment);
        fragments.add(queryFragment);

        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                viewPager.setCurrentItem(position, true);
                changeIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        initDAO();

    }

    private void resetIndicator(){
        TintUtil.changeTint(analysisIndicator, TintUtil.INDICATOR_TO_NOSELECT);
        TintUtil.changeTint(recordIndicator, TintUtil.INDICATOR_TO_NOSELECT);
        TintUtil.changeTint(queryIndicator, TintUtil.INDICATOR_TO_NOSELECT);
    }

    private void changeIndicator(int i){
        resetIndicator();
        switch (i){
            case 0:
                TintUtil.changeTint(analysisIndicator, TintUtil.INDICATOR_TO_SELECTED);
                break;
            case 1:
                TintUtil.changeTint(recordIndicator, TintUtil.INDICATOR_TO_SELECTED);
                break;
            case 2:
                TintUtil.changeTint(queryIndicator, TintUtil.INDICATOR_TO_SELECTED);
                break;
        }
    }


    private void initDAO(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "capsuleup-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        dataDao = daoSession.getDataDao();
        userDao = daoSession.getUserDao();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.analysisIndicator:
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.recordIndicator:
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.queryIndicator:
                viewPager.setCurrentItem(2, true);
                break;
        }
    }
}
