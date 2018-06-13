package com.cnbs.smartLoadingLayout.widgit;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SinTypeEvaluator implements TypeEvaluator<Number> {
    @Override
    public Number evaluate(float fraction, Number from, Number to) {
        return Math.max(0, Math.sin(fraction * Math.PI * 2)) * (to.floatValue() - from.floatValue());
    }
}
