package com.hrw.smartcalendar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/09/20 14:59
 * @desc:
 */
public class DrawUtils {

    public static void drawText(Canvas canvas, Paint paint, String label, RectF rectF, DrawPadding drawPadding, Gravity gravity) {
        float x = rectF.right + rectF.left;
        float y = rectF.bottom + rectF.top;

        Paint.FontMetrics fontMetricsInt = paint.getFontMetrics();
        y = y / 2 + (Math.abs(fontMetricsInt.ascent) + Math.abs(fontMetricsInt.leading) - Math.abs(fontMetricsInt.descent)) / 2;

        switch (gravity) {
            case Bottom:
                paint.setTextAlign(Paint.Align.CENTER);
                y += y / 2;
                y -= drawPadding.paddingBottom;
                break;
            case Top:
                paint.setTextAlign(Paint.Align.CENTER);
                y = (Math.abs(fontMetricsInt.ascent) + Math.abs(fontMetricsInt.leading));
                y += drawPadding.paddingTop;
                break;
            case Left:
                paint.setTextAlign(Paint.Align.LEFT);
                x = 0;
                y = Math.abs(fontMetricsInt.ascent) + Math.abs(fontMetricsInt.leading);
                if (drawPadding.paddingLeft != 0) {
                    x += drawPadding.paddingLeft;
                }
                if (drawPadding.paddingTop != 0) {
                    y += drawPadding.paddingTop;
                }
                break;
            case Right:
                paint.setTextAlign(Paint.Align.RIGHT);
                x += x;
                y = Math.abs(fontMetricsInt.ascent) + Math.abs(fontMetricsInt.leading);
                if (drawPadding.paddingRight != 0) {
                    x -= drawPadding.paddingRight;
                }
                if (drawPadding.paddingTop != 0) {
                    y += drawPadding.paddingTop;
                }
                break;
            case Center:
                paint.setTextAlign(Paint.Align.CENTER);
                y -= drawPadding.paddingBottom - drawPadding.paddingTop;
                break;
        }
        canvas.drawText(label, x / 2, y, paint);
    }

    public static void drawIcon(Canvas canvas, Bitmap bitmap, RectF rectF, DrawPadding drawPadding, Gravity gravity) {
        float x = rectF.right - rectF.left;
        float y = rectF.bottom - rectF.top;
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        switch (gravity) {
            case Bottom:
//                paint.setTextAlign(Paint.Align.CENTER);
                y -= bitmapHeight;
                x = x / 2 - bitmapWidth / 2;
                y -= drawPadding.paddingBottom;
                break;
            case Top:
//                paint.setTextAlign(Paint.Align.CENTER);
                y = 0;
                x = x / 2 - bitmapWidth / 2;
                y += drawPadding.paddingTop;
                break;
            case Left:
//                paint.setTextAlign(Paint.Align.LEFT);
                x = 0;
                y = 0;
                if (drawPadding.paddingLeft != 0) {
                    x += drawPadding.paddingLeft;
                }
                if (drawPadding.paddingTop != 0) {
                    y += drawPadding.paddingTop;
                }
                break;
            case Right:
//                paint.setTextAlign(Paint.Align.RIGHT);
                x -= bitmapWidth;
                y = 0;
                if (drawPadding.paddingRight != 0) {
                    x -= drawPadding.paddingRight;
                }
                if (drawPadding.paddingTop != 0) {
                    y += drawPadding.paddingTop;
                }
                break;
            case Center:
//                paint.setTextAlign(Paint.Align.CENTER);
                x = x / 2 - bitmapWidth / 2;
                y = y / 2 - bitmapHeight / 2;
                break;
        }
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public static void drawCellBG(Canvas canvas, Paint paint, RectF rectF, float rx, float ry, CellShowStyle showStyle) {
        float x = rectF.right - rectF.left;
        float y = rectF.bottom - rectF.top;
        switch (showStyle) {
            case Circle:
                if (x >= y) {
                    canvas.drawCircle((rectF.right + rectF.left) / 2, (rectF.bottom + rectF.top) / 2, y / 2, paint);
                } else {
                    canvas.drawCircle((rectF.right + rectF.left) / 2, (rectF.bottom + rectF.top) / 2, x / 2, paint);
                }
                break;
            case Square:
                canvas.drawRoundRect(rectF, rx, ry, paint);
                break;
        }
    }

   /* private void initPaint() {
        // 步骤1：创建一个画笔
        Paint mPaint = new Paint();

        // 步骤2：初始化画笔
        // 根据需求设置画笔的各种属性，具体如下：

        // 设置最基本的属性
        // 设置画笔颜色
        // 可直接引入Color类，如Color.red等
        mPaint.setColor( int color);
        // 设置画笔模式
        mPaint.setStyle(Style style);
        // Style有3种类型：
        // 类型1：Paint.Style.FILLANDSTROKE（描边+填充）
        // 类型2：Paint.Style.FILL（只填充不描边）
        // 类型3：Paint.Style.STROKE（只描边不填充）
        // 具体差别请看下图：
        // 特别注意：前两种就相差一条边
        // 若边细是看不出分别的；边粗就相当于加粗

        //设置画笔的粗细
        mPaint.setStrokeWidth( float width)
        // 如设置画笔宽度为10px
        mPaint.setStrokeWidth(10f);

        // 不常设置的属性
        // 得到画笔的颜色
        mPaint.getColor()
        // 设置Shader
        // 即着色器，定义了图形的着色、外观
        // 可以绘制出多彩的图形
        // 具体请参考文章：http://blog.csdn.net/iispring/article/details/50500106
        Paint.setShader(Shader shader)

        //设置画笔的a,r,p,g值
        mPaint.setARGB( int a, int r, int g, int b)
        //设置透明度
        mPaint.setAlpha( int a)
        //得到画笔的Alpha值
        mPaint.getAlpha()


        // 对字体进行设置（大小、颜色）
        //设置字体大小
        mPaint.setTextSize( float textSize)

        // 文字Style三种模式：
        mPaint.setStyle(Style style);
        // 类型1：Paint.Style.FILLANDSTROKE（描边+填充）
        // 类型2：Paint.Style.FILL（只填充不描边）
        // 类型3：Paint.Style.STROKE（只描边不填充）

        // 设置对齐方式
        setTextAlign（）
        // LEFT：左对齐
        // CENTER：居中对齐
        // RIGHT：右对齐

        //设置文本的下划线
        setUnderlineText( boolean underlineText)

        //设置文本的删除线
        setStrikeThruText( boolean strikeThruText)

        //设置文本粗体
        setFakeBoldText( boolean fakeBoldText)

        // 设置斜体
        Paint.setTextSkewX(-0.5f);


        // 设置文字阴影
        Paint.setShadowLayer(5, 5, 5, Color.YELLOW);

    }*/

}
