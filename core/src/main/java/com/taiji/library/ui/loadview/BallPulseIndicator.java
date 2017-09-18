package com.taiji.library.ui.loadview;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-11-21
 */

public class BallPulseIndicator extends Indicator{

    public static final float SCALE = 1.0f;

    private float[] scaleFloats = new float[]{
            SCALE,SCALE,SCALE,SCALE,SCALE,SCALE
    };

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing = 20;
        float radius = (Math.min(getWidth(),getHeight())-circleSpacing*2)/6;
        float x = getWidth()/2 - (radius*2+circleSpacing);
        float y = getHeight()/2;
        for (int i = 0; i < scaleFloats.length; i++) {
            canvas.save();
            float translateX = x+(radius*1)*i+circleSpacing*i;
            canvas.translate(translateX,y);
            canvas.scale(scaleFloats[i],scaleFloats[i]);
            canvas.drawCircle(0,0,radius,paint);
            canvas.restore();
        }
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
        int[] delays = new int[]{240,480,720,960,1180,1420};
        for (int i = 0; i < scaleFloats.length; i++) {
            final int index = i;
            ValueAnimator scaleAnim = ValueAnimator.ofFloat(1,0.3f,1);

            scaleAnim.setDuration(1000);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);

            addUpdateListener(scaleAnim, new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            animators.add(scaleAnim);
        }
        return animators;
    }
}
