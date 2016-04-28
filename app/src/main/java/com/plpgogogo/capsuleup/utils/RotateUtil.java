package com.plpgogogo.capsuleup.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by 大舅哥 on 2016/4/28.
 */
public class RotateUtil {

    public static final int ROTATE_TO_LIGHT = 0;
    public static final int ROTATE_TO_DARK = 1;
    public static final int ROTATE_TO_LIGHT_WITH_TRANSITION = 2;
    public static final int ROTATE_TO_DARK_WITH_TRANSITION = 3;
    public static void changeRotation(final ImageView view, int target, float transition){
        switch (target){
            case ROTATE_TO_LIGHT:
                ObjectAnimator rotate1 = ObjectAnimator.ofFloat(view, "rotation", 45.0f).setDuration(300);
                rotate1.start();
                rotate1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        view.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setEnabled(true);
                        TintUtil.changeTint(view, TintUtil.INDICATOR_TO_LIGHT);
                    }
                });
                break;
            case ROTATE_TO_DARK:
                ObjectAnimator rotate2 = ObjectAnimator.ofFloat(view, "rotation", 0.0f).setDuration(300);
                rotate2.start();
                rotate2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        view.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setEnabled(true);
                        TintUtil.changeTint(view, TintUtil.INDICATOR_TO_DARK);
                    }
                });
                break;
            case ROTATE_TO_LIGHT_WITH_TRANSITION:
                AnimatorSet set1 = new AnimatorSet();
                ObjectAnimator rotation1 = ObjectAnimator.ofFloat(view, "rotation", 45.0f).setDuration(300);
                ObjectAnimator translation1 = ObjectAnimator.ofFloat(view, "translationY", transition).setDuration(300);
                ObjectAnimator gradient1 = ObjectAnimator.ofArgb(view.getDrawable().mutate(), "tint", TintUtil.COLOR_INDICATOR_DARK, TintUtil.COLOR_INDICATOR_LIGHT).setDuration(300);
                set1.playTogether(rotation1, translation1, gradient1);
                set1.start();
                break;
            case ROTATE_TO_DARK_WITH_TRANSITION:
                AnimatorSet set2 = new AnimatorSet();
                ObjectAnimator rotation2 = ObjectAnimator.ofFloat(view, "rotation", 0.0f).setDuration(300);
                ObjectAnimator translation2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, transition).setDuration(300);
                ObjectAnimator gradient2 = ObjectAnimator.ofArgb(view.getDrawable().mutate(), "tint", TintUtil.COLOR_INDICATOR_LIGHT, TintUtil.COLOR_INDICATOR_DARK).setDuration(300);
                set2.playTogether(rotation2, translation2, gradient2);
                set2.start();
                break;
        }
    }
}
