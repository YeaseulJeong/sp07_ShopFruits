package com.encore.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;

@Service
public class ShopImpl implements ShopDAO{

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public List<Item> getItemList() throws Exception{
		return itemDAO.getItemList();
	}

	@Override
	public Item getItem(Integer itemId)  throws Exception{
		return itemDAO.getItem(itemId);
	}

}
