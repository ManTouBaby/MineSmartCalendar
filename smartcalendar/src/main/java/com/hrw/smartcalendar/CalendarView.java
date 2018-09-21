package com.hrw.smartcalendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/09/20 15:05
 * @desc:
 */
public class CalendarView extends View {
    Paint mPaintDay;
    Paint mPaintDayLunar;
    Paint mPaintDayBG;
    Paint mPaintCurrent;
    Paint mPaintClick;

    private float cellPaddingTop;
    private float cellPaddingBottom;
    private float cellPaddingLeft;
    private float cellPaddingRight;

    float mWidth;
    float mHeight;
    float mCellWidth;
    float mCellHeight;
    float density;

    private boolean isShowFestival;
    private int showStyle = -1;//0:表示圆形 1:表示圆角方形

    String mCurrentYearMonth = "2018-09";
    List<CellBO> cellBOS;

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        density = context.getResources().getDisplayMetrics().density;
        initPaint();
    }

    private void initPaint() {
        mPaintDay = new Paint();
        mPaintDay.setColor(Color.WHITE);
        mPaintDay.setStyle(Paint.Style.FILL);
        mPaintDay.setTextAlign(Paint.Align.CENTER);
        mPaintDay.setAntiAlias(true);
        mPaintDay.setTextSize(getTextSize(16));

        mPaintDayBG = new Paint();
        mPaintDayBG.setColor(Color.RED);
        mPaintDayBG.setStyle(Paint.Style.FILL);
        mPaintDayBG.setTextAlign(Paint.Align.CENTER);
        mPaintDayBG.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        RectF rectF = new RectF(0, 0, mHeight, mWidth);
//        DrawPadding drawPadding = new DrawPadding();
////        drawPadding.paddingTop = getSize(10);
////        drawPadding.paddingBottom = getSize(5);
//        mPaintDay.setTextSize(getTextSize(12));
//        DrawUtils.drawText(canvas, mPaintDay, "车数", rectF, drawPadding, Gravity.Center);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_rmb);
//
//        DrawUtils.drawIcon(canvas, bitmap, rectF, drawPadding, Gravity.Right);

        initCell(canvas);
    }

    /**
     * 初始化日历单元背景
     *
     * @param canvas
     */
    private void initCell(Canvas canvas) {
        for (CellBO cellBO : cellBOS) {
            RectF rectF = new RectF(cellBO.getLeft(), cellBO.getTop(), cellBO.getRight(), cellBO.getBottom());
//            System.out.println("left:" + cellBO.getLeft() + " top:" + cellBO.getTop() + " right:" + cellBO.getRight() + " bottom:" + cellBO.getBottom());
            DrawUtils.drawCellBG(canvas, mPaintDayBG, rectF, getSize(4), getSize(4), CellShowStyle.Circle);
            DrawPadding drawPadding = new DrawPadding();
            DrawUtils.drawText(canvas, mPaintDay, cellBO.getShowDay(), rectF, drawPadding, Gravity.Center);
        }
    }

    /**
     * 设置显示月份
     *
     * @param yearMonth
     */
    public void setMonthShow(String yearMonth) {
        mCurrentYearMonth = yearMonth;
        postInvalidate();
    }

    /**
     * 设置选中颜色
     *
     * @param datOfMonths
     * @param statusTextColor
     * @param statusBGColor
     * @param status
     */
    public void setCellStatus(List<String> datOfMonths, int statusTextColor, int statusBGColor, int status) {
        for (String s : datOfMonths) {
            for (CellBO cellBO : cellBOS) {
                if (cellBO.getCellDate().equals(s)) {
                    cellBO.setStatusBGColor(statusBGColor);
                    cellBO.setStatus(status);
                    cellBO.setStatusTextColor(statusTextColor);
                    break;
                }
            }
        }
        postInvalidate();
    }

    public boolean isShowFestival() {
        return isShowFestival;
    }

    public void setShowFestival(boolean showFestival) {
        isShowFestival = showFestival;
        postInvalidate();
    }

    public int getShowStyle() {
        return showStyle;
    }

    public void setShowStyle(CellShowStyle showStyle) {
        switch (showStyle) {
            case Circle:
                this.showStyle = 0;
                break;
            case Square:
                this.showStyle = 1;
                break;
        }
        postInvalidate();
    }

    /**
     * 获取本月天数
     *
     * @return
     */
    public int getDayOfMonthCount() {
        int count = 0;
        for (CellBO cellBO : cellBOS) {
            if (cellBO.isUsable()) count++;
        }
        return count;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();

        mWidth = w - (paddingLeft + paddingRight);
        mHeight = h - (paddingBottom + paddingTop);

        mCellHeight = mHeight / 6;
        mCellWidth = mWidth / 7;
//        System.out.println("w:" + w + " h:" + h + " oldW:" + oldw + " oldh:" + oldh);
        cellBOS = CreateCellData.getCells(mCurrentYearMonth, getPaddingLeft(), getPaddingTop(), mCellWidth, mCellHeight);
    }

    private float getTextSize(float size) {
        return size * density;
    }

    private float getSize(float size) {
        return size * density;
    }
}
