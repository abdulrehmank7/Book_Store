package com.arkapp.bookstore.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.arkapp.bookstore.R;


/**
 * Created by Abdul Rehman on 12/30/2018.
 */
public class TrapeziumView extends View {
    Paint mPaint;

    Path path;

    int mSquareColor;

    private double slopeHeightPercent;

    private float radius;

    private CornerPathEffect corEffect;

    public TrapeziumView(Context context) {
        super(context);
    }

    public TrapeziumView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public TrapeziumView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TrapeziumView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                         int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();

        TypedArray a = getContext().getTheme().obtainStyledAttributes(set, R.styleable.TrapeziumView, 0, 0);

        try {
            mSquareColor = a.getColor(R.styleable.TrapeziumView_shapeColor, Color.BLACK);
            radius = a.getInt(R.styleable.TrapeziumView_edgeRadius, 30);
            slopeHeightPercent = a.getFloat(R.styleable.TrapeziumView_slopeHeightPercent, 30) / 100;
        } finally {
            a.recycle();
        }

        corEffect = new CornerPathEffect(radius);
        mPaint.setColor(mSquareColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setPathEffect(corEffect);

        path.moveTo(0, getHeight() - (int) (getHeight() * slopeHeightPercent));
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), 0);
        path.lineTo(0, 0);
        path.close();
        canvas.drawPath(path, mPaint);
    }

}
