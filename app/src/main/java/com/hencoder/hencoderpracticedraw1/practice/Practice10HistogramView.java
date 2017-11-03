package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mShapePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int unit = 100;
    int halfUnit = unit / 2;
    int space = 8;
    String[] strs = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    float[] chances = {0, 50, 50, 180, 360, 450, 320};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        int width = getWidth();
        int height = getHeight();

        float lineHeight = height - 3 * unit;
        float lineWidth = width - 2 * unit;

        float baseX = unit;
        float baseY = lineHeight + 65;

        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextSize(48);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("直方图", width / 2, height - 50, mTextPaint);

        mTextPaint.setTextSize(25);
        mShapePaint.setStyle(Paint.Style.FILL);
        mShapePaint.setColor(Color.GREEN);
        for (int i = 0; i < strs.length; i++) {
            canvas.drawText(strs[i], baseX + space * (i + 1) + halfUnit * (2 * i + 1), baseY + 30, mTextPaint);
            //canvas.drawRect(baseX + space * (i + 1) + unit * i, baseY - chances[i], baseX + 2 * (space + unit), baseY, mShapePaint);
        }

        mShapePaint.setColor(Color.WHITE);
        mShapePaint.setStrokeWidth(3);

        float[] pots = {unit, 65, baseX, baseY, baseX, baseY, unit + lineWidth, lineHeight + 65};
        canvas.drawLines(pots, mShapePaint);
    }
}
