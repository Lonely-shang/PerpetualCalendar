

public class Day03 {

    //1.判断是否为闰年
    static boolean Year(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ;
        
    }

    // 2.求给定年有多少天
    static int getDay(int year) {
        return Year(year) ? 366 : 365;
    }

    //3.求给定年月有多少天
    static int getDay(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (Year(year))
                    return 29;
                else
                    return 28;
        }
        return 0;
    }

    //4.求给定年月日周几
    //给个基准点    求得与基准点差总的几天数
    static int getweek(int year, int month, int day) {
        int days = 0;
        for (int i = 1; i < year; i++)
            days += getDay(i);              //求相差年的天数
        for (int i = 1; i < month; i++)
            days += getDay(year, i);        //求相差月的天数
        days += day - 1;                    //求相差的天数
        return (days + 1) % 7;              //计算待求的天为星期几

    }

    //5.输出年历
    static void print(int year) {
        for (int i = 1; i <= 12; i++)
            print(year, i);
    }

    //6.输出月历
    static void print(int year, int month) {
        //打印日历表头
        System.out.printf("\n%4d年%2d月\n", year, month);
        System.out.print("Sun\tMon\tTue\tWed\tThu\tFri\tSta\n");

        //打印每月空白日
        int weekday = getweek(year, month, 1);
        for (int i = 0; i < weekday; i++) {
            System.out.print("\t");
        }

        //打印到月底最一天结束打印
        int lastday = getDay(year, month);
        for (int i = 1; i <= lastday; i++) {
            System.out.printf("%2d\t", i);
            //当打印到星期六是换行
            if (getweek(year, month, i) == 6)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        print(2018);
    }
}
