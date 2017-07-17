package com.kniost.library;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

/**
 * Created by kniost on 2017/7/17.
 * input span
 */

public class InputSpan extends ReplacementSpan {
    private int mTop, mBottom, mWidth;
    private float mLeft, mRight;
    private final Paint mPaint;
    private RectF mRectF = new RectF(mLeft, mTop, mRight, mBottom);
    public InputSpan() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, @IntRange(from = 0) int start, @IntRange(from = 0) int end, @Nullable Paint.FontMetricsInt fm) {
        // return text with relative to the Paint
        if (fm != null) {
            fm.ascent -= 10;
            fm.descent += 10;
        }
        mWidth = (int) paint.measureText(text, start, end) + 30;
        return mWidth;
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, @IntRange(from = 0) int start, @IntRange(from = 0) int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        // draw the frame with custom Paint
        mTop = top;
        mBottom = bottom;
        mLeft = x;
        mRight = x + mWidth;
        mRectF = new RectF(mLeft, mTop, mRight, mBottom);
//        Log.d("RectF", mRectF.toString());
        canvas.drawRect(mLeft, mTop, mRight, mBottom, mPaint);
        canvas.drawText(text, start, end, x + 15, y, paint);
    }

    public RectF getRectF() {
        return mRectF;
    }
}
