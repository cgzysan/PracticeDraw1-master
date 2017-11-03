package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        Path path = new Path();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(340, 283, 540, 483, -225, 225);
            path.arcTo(540, 283, 740, 483, -225, 225, false);
        } else {
            RectF arc = new RectF(340, 283, 540, 483);
            path.addArc(arc, -225, 225);
            RectF oval = new RectF(540, 283, 740, 483);
            path.arcTo(oval, 180, 225, false);
        }
        path.lineTo(540, 600);
        canvas.drawPath(path, mPaint);
    }
}
