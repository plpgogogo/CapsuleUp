package com.plpgogogo.capsuleup.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.ImageView;

/**
 * Created by 大舅哥 on 2016/4/28.
 */
public class TintUtil {
    public static final int INDICATOR_TO_NOSELECT = 0;
    public static final int INDICATOR_TO_SELECTED = 1;
    public static final int INDICATOR_TO_LIGHT = 2;
    public static final int INDICATOR_TO_DARK = 3;
    public static final int COLOR_INDICATOR_DARK = 0xff616161;
    public static final int COLOR_INDICATOR_LIGHT = 0xff1976D2;
    public static final int COLOR_INDICATOR_SELECTED = 0xff1976D2;
    public static final int COLOR_INDICATOR_NOSELECT = 0xff616161;


    public static void changeTint(ImageView view, int target){
        switch (target){
            case INDICATOR_TO_NOSELECT:
                view.setImageTintList(getColorStateListByColor(COLOR_INDICATOR_NOSELECT));
                break;
            case INDICATOR_TO_DARK:
                view.setImageTintList(getColorStateListByColor(COLOR_INDICATOR_DARK));
                break;
            case INDICATOR_TO_SELECTED:
                view.setImageTintList(getColorStateListByColor(COLOR_INDICATOR_SELECTED));
                break;
            case INDICATOR_TO_LIGHT:
                view.setImageTintList(getColorStateListByColor(COLOR_INDICATOR_LIGHT));
                break;
        }
    }
    public static void changeTintByOffset(ImageView fromView, ImageView toView, float positionoffset){
        fromView.setImageTintList(ColorStateList.valueOf(blendColor(COLOR_INDICATOR_DARK, COLOR_INDICATOR_LIGHT, positionoffset)));
        toView.setImageTintList(ColorStateList.valueOf(blendColor(COLOR_INDICATOR_LIGHT, COLOR_INDICATOR_DARK, positionoffset)));
    }
    private static int blendColor(int toColor, int fromColor, float positionoffset){
        final float inverseRation = 1f - positionoffset;
        float r = (Color.red(toColor) * positionoffset) + (Color.red(fromColor) * inverseRation);
        float g = (Color.green(toColor) * positionoffset) + (Color.green(fromColor) * inverseRation);
        float b = (Color.blue(toColor) * positionoffset) + (Color.blue(fromColor) * inverseRation);
        return Color.rgb((int) r, (int) g, (int) b);
    }
    private static ColorStateList getColorStateListByColor(int color){
        return ColorStateList.valueOf(color);
    }
}
