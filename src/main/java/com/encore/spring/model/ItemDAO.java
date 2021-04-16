package com.encore.spring.model;

import java.util.List;

import com.encore.spring.domain.Item;

public interface ItemDAO {
	
	public List<Item> getItemList() throws Exception;
	public Item getItem(Integer itemId) throws Exception;

}
