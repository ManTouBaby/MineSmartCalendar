package com.hrw.smartcalendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @version 1.0.0
 * @author:hrw
 * @date:2018/09/20 14:58
 * @desc:
 */
public class CreateCellData {

    public static List<CellBO> getCells(String yearMonth, float paddingLeft, float paddingTop, float mCellWidth, float mCellHeight) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);
        int month = Integer.parseInt(yearMonth.split("-")[1]);

        int firstDayIndex = getFirstDayOfMonth(year, month);
        int monthCount = getDayOfMonthCount(year, month);

        int lastMonthCount;
        if (month == 1) {
            lastMonthCount = getDayOfMonthCount(year - 1, 12);
        } else {
            lastMonthCount = getDayOfMonthCount(year, month - 1);
        }
        System.out.println("firstDayIndex:" + firstDayIndex + " monthCount:" + monthCount);

        List<CellBO> cellBOS = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                float left = paddingLeft + j * mCellWidth;
                float top = paddingTop + i * mCellHeight;
                float right = left + mCellWidth;
                float bottom = top + mCellHeight;
                CellBO cellBO = new CellBO();
                cellBO.setBottom(bottom);
                cellBO.setTop(top);
                cellBO.setLeft(left);
                cellBO.setRight(right);

                int index = (i * 7) + (j + 1);
                if (index < firstDayIndex) {//本月前日期
                    cellBO.setUsable(false);
                    int dayOfLastMonth = lastMonthCount - firstDayIndex + index;
                    cellBO.setShowDay(dayOfLastMonth + "");
                    if (month == 1) {
                        cellBO.setCellDate((year - 1) + "-12-" + dayOfLastMonth);
                    } else {
                        cellBO.setCellDate(year + "-" + (month - 1) + "-" + dayOfLastMonth);
                    }
                } else if (index < (firstDayIndex + monthCount)) {//本月的日期
                    int dayOfMonth = index - firstDayIndex + 1;
                    String dayOfMonthStr = dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth + "";
                    cellBO.setShowDay(dayOfMonth + "");
                    cellBO.setCellDate(yearMonth + "-" + dayOfMonthStr);
                } else {//本月后的日期
                    cellBO.setUsable(false);
                    int dayOfNextMonth = index - (firstDayIndex + monthCount) + 1;
                    String dayOfNextMonthStr = dayOfNextMonth < 10 ? "0" + dayOfNextMonth : dayOfNextMonth + "";
                    cellBO.setShowDay(dayOfNextMonth + "");
                    if (month == 12) {
                        cellBO.setCellDate((year + 1) + "-01-" + dayOfNextMonthStr);
                    } else {
                        cellBO.setCellDate(year + "-" + (month - 1) + "-" + dayOfNextMonthStr);
                    }
                }
                cellBOS.add(cellBO);
//                System.out.println("left:" + left + " top:" + top + " right:" + right + " bottom:" + bottom);
            }
        }
        return cellBOS;
    }

    public static int getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static int getDayOfMonthCount(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.get(Calendar.DATE);
    }
}
