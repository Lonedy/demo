package cn.lonedy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.lonedy.ssm.po.Items;

/**
 *  
 * <p>
 * Title: JsonController
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-10-13 下午4:05:26    @version 1.0
 */
@Controller
public class JsonController {

	@RequestMapping("/responseJson")
	@ResponseBody
	public Items responseJson(Items items) {

		return items;
	}
	
	@RequestMapping("/requestJson")
	@ResponseBody
	public Items requestJson(@RequestBody Items items) {

		return items;
	}
}
