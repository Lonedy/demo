package cn.lonedy.ssm.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import cn.lonedy.ssm.exception.BusinessException;
import cn.lonedy.ssm.po.Items;
import cn.lonedy.ssm.po.ItemsQueryVO;
import cn.lonedy.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.lonedy.ssm.controller.group.Group1;

/**
 *  
 * <p>
 * Title: ItemsController1
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-10-12 上午9:44:25    @version 1.0
 */
@RequestMapping("/items")
@Controller
public class ItemsController {

	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/queryItems")
	public String queryItems(Model model, HttpServletRequest req,
			ItemsQueryVO vo) throws Exception {

		System.out.println(req.getParameter("id"));

		// 获取商品列表信息（暂时使用静态数据）
		List<Items> itemsList = itemsService.queryItemsList(vo);

		// 把商品信息放到request域中
		model.addAttribute("itemsList", itemsList);

		return "items/itemsList";
	}

	// @RequestMapping("/editItems")
	// public ModelAndView
	// editItems(@RequestParam(value="itemsid",defaultValue="1") Integer id)
	// throws Exception {
	@RequestMapping(value = "/editItems", method = { RequestMethod.POST,
			RequestMethod.GET })
	public ModelAndView editItems(Integer id) throws Exception {
		// 根据商品id查找商品信息
		Items items = itemsService.queryItemsById(id);

		if (items == null)
			throw new BusinessException("根据该商品ID无法查询到商品信息！！！");

		ModelAndView mv = new ModelAndView();
		// 把商品信息放到request域中
		mv.addObject("items", items);
		// 指定要响应的页面
		// 可以指定逻辑视图名称
		mv.setViewName("items/editItems");
		return mv;
	}

	// @Validated:该注解对后面的pojo参数进行校验，校验信息将由与他配对使用的BindingResult对象来获取，
	// Validated注解和BindingResult对象是成对出现，且位置是一前一后
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(
			Integer id,
			@Validated(value = { Group1.class }) @ModelAttribute("item") Items item,
			BindingResult br, Model model, MultipartFile pictureFile)
			throws Exception {

		if (br.hasErrors()) {
			List<ObjectError> errors = br.getAllErrors();

			for (ObjectError objectError : errors) {
				System.out.println(objectError.getDefaultMessage());
			}

			// 将错误信息放到request域中
			model.addAttribute("errors", errors);

			// 校验错误，停留在当前页面
			return "items/editItems";
		}

		if (pictureFile != null) {
			// 获取原图片的名称，目的是为了获取图片的格式
			String filename = pictureFile.getOriginalFilename();

			if (filename != null && !"".equals(filename)) {

				// 指定保存图片的目录
				String basePath = "E:\\03-teach\\07-upload\\temp\\";

				File dir = new File(basePath);
				if (!dir.exists())
					dir.mkdirs();

				String newFileName = UUID.randomUUID()
						+ filename.substring(filename.lastIndexOf("."));

				// 将图片信息输出到新文件中
				pictureFile.transferTo(new File(basePath + newFileName));

				item.setPic(newFileName);
			}
		}

		// 修改商品信息
		itemsService.editItems(id, item);
		// 请求转发到商品列表页面
		// return "forward:queryItems.do";
		// 请求重定向
		// model.addAttribute("item", items);
		return "redirect:queryItems.do";
	}

	@RequestMapping("/deleteItemsAll")
	public String deleteItemsAll(Integer[] itemsId) {

		return "success";
	}

	@RequestMapping("/editItemsAll")
	public String editItemsAll(Model model) throws Exception {

		// 获取商品列表信息（暂时使用静态数据）
		List<Items> itemsList = itemsService.queryItemsList(null);

		// 把商品信息放到request域中
		model.addAttribute("itemsList", itemsList);

		return "items/itemsEditList";
	}

	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVO vo) {

		return "success";
	}

	@ModelAttribute("itemsType")
	public Map<String, String> itemsType() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("101", "手机");
		map.put("102", "电视");
		return map;
	}

	@RequestMapping("/queryItemsById/{itemsid}")
	@ResponseBody
	public Items queryItemsById(@PathVariable("itemsid") Integer id) throws Exception {
		// 根据商品id查找商品信息
		return itemsService.queryItemsById(id);
	}

}
