package cn.lonedy.ssm.po;

import java.util.List;

/**
 * <p>Title: ItemsQueryVO</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-12 下午3:10:11  
 * @version 1.0
 */
public class ItemsQueryVO {

	//商品信息
	private Items items;
	//用户信息
	
	//商品集合信息
	private List<Items> itemsList;
	
	

	public List<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
}
