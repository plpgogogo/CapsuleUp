package com.plpgogogo.capsuleup.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by 大舅哥 on 2016/5/1.
 */
public class ScaleUtil {
    private static final int SCALE_TO_NOSELECT = 0;
    private static final int SCALE_TO_SELECTED = 1;
    private static final float SCALEADD = 0.1f;
    public static void changeScale(ImageView view, int target){
        switch (target){
            case SCALE_TO_NOSELECT:
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                break;
            case SCALE_TO_SELECTED:
                view.setScaleX(1.0f + SCALEADD);
                view.setScaleY(1.0f + SCALEADD);
                break;
        }
    }
    public static void changeScaleByOffset(ImageView fromView, ImageView toView, float positionoffset){
        fromView.setScaleX(1.0f + (1 - positionoffset)*SCALEADD);
        fromView.setScaleY(1.0f + (1 - positionoffset)*SCALEADD);
        toView.setScaleX(1.0f + positionoffset*SCALEADD);
        toView.setScaleY(1.0f + positionoffset*SCALEADD);
    }
}
