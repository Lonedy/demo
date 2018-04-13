package cn.lonedy.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lonedy.ssm.mapper.ItemsExtMapper;
import cn.lonedy.ssm.mapper.ItemsMapper;
import cn.lonedy.ssm.po.Items;
import cn.lonedy.ssm.po.ItemsQueryVO;

/**
 * <p>Title: ItemsServiceImpl</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-12 下午3:18:48  
 * @version 1.0
 */
@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemsExtMapper extMapper;
	
	@Autowired
	private ItemsMapper mapper;
	
	@Override
	public List<Items> queryItemsList(ItemsQueryVO vo) throws Exception {
		return extMapper.queryItemsList(vo);
	}

	@Override
	public Items queryItemsById(Integer id) throws Exception {
		if(id == null) return null;
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int editItems(Integer id, Items items) throws Exception {
		if(id == null) return -1;
		items.setId(id);
		return mapper.updateByPrimaryKeySelective(items);
	}

}
