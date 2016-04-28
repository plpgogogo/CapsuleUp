package com.plpgogogo.capsuleup.utils;

import android.content.res.ColorStateList;
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

    static ColorStateList indicator_noselect = ColorStateList.valueOf(COLOR_INDICATOR_DARK);
    static ColorStateList indicator_selected = ColorStateList.valueOf(0xff1976D2);
    static ColorStateList indicator_light = ColorStateList.valueOf(COLOR_INDICATOR_LIGHT);
    public static void changeTint(ImageView view, int target){
        switch (target){
            case INDICATOR_TO_NOSELECT:
            case INDICATOR_TO_DARK:
                view.setImageTintList(indicator_noselect);
                break;
            case INDICATOR_TO_SELECTED:
                view.setImageTintList(indicator_selected);
                break;
            case INDICATOR_TO_LIGHT:
                view.setImageTintList(indicator_light);
                break;
        }

    }
}
