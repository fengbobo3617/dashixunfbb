package cn.jiyun.start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 计算销售日期
 */
public class SpecialDateDemo {
    public static void main(String[] args) throws ParseException {
        //键盘录入四部曲(缩减版)
        Scanner console = new Scanner(System.in);
        System.out.println("请输入生产日期");
        //生产日期
        String s = console.nextLine();
        //创建 SimpleDateFormat格式 数据用于转换时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       //转入生产日期
        Date proc = sdf.parse(s);
        //提前一周时间 计算时间
        Date date = specialDay(proc, 1);
        System.out.println("促销日期为:"+sdf.format(date));
    }
    /**
     * 根据输入的商品生产日期,以及保质期(单位:月份),计算促销日期
     * 先计算出过期日期
     * 在计算出促销日期(保质期前一周的周五)
     * 最后得出这个周五是几号
     */

    public static Date specialDay(Date proc,int exp){
        //运用Calender计算时间
        Calendar cal =new GregorianCalendar();
        //调用setTime方法传入时间 并为其赋值
        cal.setTime(proc);
        //计算出过期日期 月份+几个月
        cal.add(Calendar.MONTH,exp);
        //回调一周
        cal.add(Calendar.WEEK_OF_YEAR,-1);
        //调到当前周的周五
        cal.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
        //获取时间
        return  cal.getTime();
    }
}
