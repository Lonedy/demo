package cn.lonedy.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * <p>Title: DateConverter</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-12 下午5:02:34  
 * @version 1.0
 */
public class DateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
