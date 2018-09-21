package com.hrw.smartcalendar;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/09/19 15:26
 * @desc:
 */
public class CellBO {
    private String showDay;//日历显示日期
    private String showLunar;//日历显示农历

    private int colorTextUnusable;//不可使用日历单元文字颜色
    private int colorTextUsable;//可使用日历单元文字颜色
    private int colorTextClick;//单击日历单元文字颜色
    private int colorTextCurrentDay;//当天日历单元文字颜色

    private int colorBGUnusable;//不可使用日历单元文字颜色
    private int colorBGUsable;//可使用日历单元文字颜色
    private int colorBGClick;//单击日历单元文字颜色
    private int colorBGCurrentDay;//当天日历单元文字颜色

    private String cellDate;//日历单元所携带日期--yyyy-MM-dd
    private String cellLunarDate;//日历单元所携带农历

    private float left;
    private float top;
    private float right;
    private float bottom;

    private int index;//日历单元所处位置
    private int indexMonth;//日历单元所处位置
    private int status;//日历单元表示状态
    private int statusBGColor;//日历单元表示状态背景色
    private int statusTextColor;//日历单元表示状态文字表示颜色
    private int iconRes;//日历单元图标

    private boolean isSelect;//是否被选中
    private boolean isClick; //是否被单击
    private boolean isUsable;//是否可用

    public String getShowDay() {
        return showDay;
    }

    public void setShowDay(String showDay) {
        this.showDay = showDay;
    }

    public String getShowLunar() {
        return showLunar;
    }

    public void setShowLunar(String showLunar) {
        this.showLunar = showLunar;
    }

    public int getColorTextUnusable() {
        return colorTextUnusable;
    }

    public void setColorTextUnusable(int colorTextUnusable) {
        this.colorTextUnusable = colorTextUnusable;
    }

    public int getColorTextUsable() {
        return colorTextUsable;
    }

    public void setColorTextUsable(int colorTextUsable) {
        this.colorTextUsable = colorTextUsable;
    }

    public int getColorTextClick() {
        return colorTextClick;
    }

    public void setColorTextClick(int colorTextClick) {
        this.colorTextClick = colorTextClick;
    }

    public int getColorTextCurrentDay() {
        return colorTextCurrentDay;
    }

    public void setColorTextCurrentDay(int colorTextCurrentDay) {
        this.colorTextCurrentDay = colorTextCurrentDay;
    }

    public int getColorBGUnusable() {
        return colorBGUnusable;
    }

    public void setColorBGUnusable(int colorBGUnusable) {
        this.colorBGUnusable = colorBGUnusable;
    }

    public int getColorBGUsable() {
        return colorBGUsable;
    }

    public void setColorBGUsable(int colorBGUsable) {
        this.colorBGUsable = colorBGUsable;
    }

    public int getColorBGClick() {
        return colorBGClick;
    }

    public void setColorBGClick(int colorBGClick) {
        this.colorBGClick = colorBGClick;
    }

    public int getColorBGCurrentDay() {
        return colorBGCurrentDay;
    }

    public void setColorBGCurrentDay(int colorBGCurrentDay) {
        this.colorBGCurrentDay = colorBGCurrentDay;
    }

    public String getCellDate() {
        return cellDate;
    }

    public void setCellDate(String cellDate) {
        this.cellDate = cellDate;
    }

    public String getCellLunarDate() {
        return cellLunarDate;
    }

    public void setCellLunarDate(String cellLunarDate) {
        this.cellLunarDate = cellLunarDate;
    }

    public float getLeft() {
        return left;
    }

    public void setLeft(float left) {
        this.left = left;
    }

    public float getTop() {
        return top;
    }

    public void setTop(float top) {
        this.top = top;
    }

    public float getRight() {
        return right;
    }

    public void setRight(float right) {
        this.right = right;
    }

    public float getBottom() {
        return bottom;
    }

    public void setBottom(float bottom) {
        this.bottom = bottom;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndexMonth() {
        return indexMonth;
    }

    public void setIndexMonth(int indexMonth) {
        this.indexMonth = indexMonth;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatusBGColor() {
        return statusBGColor;
    }

    public void setStatusBGColor(int statusBGColor) {
        this.statusBGColor = statusBGColor;
    }

    public int getStatusTextColor() {
        return statusTextColor;
    }

    public void setStatusTextColor(int statusTextColor) {
        this.statusTextColor = statusTextColor;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }

    public boolean isUsable() {
        return isUsable;
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
    }
}
