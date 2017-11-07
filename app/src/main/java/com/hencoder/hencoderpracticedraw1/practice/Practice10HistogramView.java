package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private List<Data> mDatas = new ArrayList<>();
    private float max = 0;


    private void init() {
        mDatas.add(new Data("Froyo", 5.0f, Color.GREEN));
        mDatas.add(new Data("GB", 25.0f, Color.GREEN));
        mDatas.add(new Data("ICS", 25.0f, Color.GREEN));
        mDatas.add(new Data("JB", 90.0f, Color.GREEN));
        mDatas.add(new Data("KitKat", 180.0f, Color.GREEN));
        mDatas.add(new Data("L", 225.0f, Color.GREEN));
        mDatas.add(new Data("M", 160.0f, Color.GREEN));

        for (Data data : mDatas) {
        	max = Math.max(max, data.getChance());
        }
    }


    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mShapePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    int unit = 100;
    int halfUnit = unit / 2;
    int space = 16;
    String[] strs = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    float[] chances = {0, 50, 50, 180, 360, 450, 320};

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(48);
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("直方图", canvas.getWidth() / 2, canvas.getHeight() * 0.95f, mPaint);

        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.80f);

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.7f, mPaint);
        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, mPaint);

        float width = (canvas.getWidth() * 0.8f - 100) / mDatas.size() * 0.8f;
        float space = (canvas.getWidth() * 0.8f - 100) / mDatas.size() * 0.2f;

        float startX = 0.0f;
        for (Data item : mDatas) {
        	mPaint.setColor(Color.WHITE);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(20);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(item.getName(), startX + space + width / 2, 25, mPaint);

            mPaint.setColor(item.getColor());
            canvas.drawRect(startX + space, -item.getChance() / max * canvas.getHeight() * 0.65f, startX + space + width, 0, mPaint);
            startX = space + width + startX;
        }
    }
}
