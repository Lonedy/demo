package cn.lonedy.ssm.mapper;

import java.util.List;

import cn.lonedy.ssm.po.Items;
import cn.lonedy.ssm.po.ItemsQueryVO;

/**
 * <p>Title: ItemsExtMapper</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-12 下午3:12:04  
 * @version 1.0
 */
public interface ItemsExtMapper {
	
	//查询商品列表
	public List<Items> queryItemsList(ItemsQueryVO vo) throws Exception;
}
