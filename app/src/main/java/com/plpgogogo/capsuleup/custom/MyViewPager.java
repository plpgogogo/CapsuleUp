package com.plpgogogo.capsuleup.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by 大舅哥 on 2016/5/1.
 */
public class MyViewPager extends ViewPager {

    private boolean isSrollable = true;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSrollable(boolean srollable) {
        isSrollable = srollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(isSrollable){
            return super.onTouchEvent(ev);
        }else{
            return false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(isSrollable){
            return super.onTouchEvent(ev);
        }else{
            return false;
        }
    }
}
