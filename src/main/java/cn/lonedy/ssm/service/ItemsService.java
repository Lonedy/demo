package cn.lonedy.ssm.service;

import java.util.List;

import cn.lonedy.ssm.po.Items;
import cn.lonedy.ssm.po.ItemsQueryVO;

/**
 *  
 * <p>
 * Title: ItemsService
 * </p>
 *  
 * <p>
 * Description: TODO(这里用一句话描述这个类的作用) 
 * <p>
 * <p>
 * Company: www.itcast.com
 * </p>
 *  @author 传智.关云长   @date 2015-10-12 下午3:18:07    @version 1.0
 */
public interface ItemsService {

	// 查询商品列表
	public List<Items> queryItemsList(ItemsQueryVO vo) throws Exception;

	public Items queryItemsById(Integer id) throws Exception;

	public int editItems(Integer id, Items items) throws Exception;
}
