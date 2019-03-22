package cn.wen.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张文军
 * @Description:日期转换类
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2019/3/1813:16
 */
public class DateUtils {
		/**
		 * 日期转换字符串
		 * @param date ：时间
		 * @param patt:时间格式
		 * @return
		 */
		public static String data2String(Date date, String patt){
				SimpleDateFormat format = new SimpleDateFormat(patt);
				String format1 = format.format(date);
				return format1;
		}

		/**
		 * 字符串转换为日期
		 * @param str
		 * @param patt
		 * @return
		 * @throws ParseException
		 */
		public static Date string2Date(String str,String patt) throws ParseException {
				SimpleDateFormat format = new SimpleDateFormat(patt);
				Date parse = format.parse(str);
				return parse;
		}
}
