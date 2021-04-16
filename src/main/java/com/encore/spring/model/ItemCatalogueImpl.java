package com.encore.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.Item;

@Service
public class ItemCatalogueImpl implements ItemCatalogueDAO{

	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public List<Item> getItemList()  throws Exception{
		return shopDAO.getItemList();
	}

	@Override
	public Item getItem(Integer itemId)  throws Exception{
		return shopDAO.getItem(itemId);
	}

}
