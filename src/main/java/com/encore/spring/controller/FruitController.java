package com.encore.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Item;
import com.encore.spring.model.ItemCatalogueDAO;

@Controller
public class FruitController {
	
	@Autowired
	private ItemCatalogueDAO itemCatalogueDAO;
	
	@RequestMapping("fruit.do")   // 이렇게 짧게 써도 된다 
	public ModelAndView list(HttpServletRequest request) throws Exception {       // form에 입력된 name들의 값과 vo 의 필드의 이름이 같으면 form 의 값들이 vo의 자동 바인딩 된다
		/*
		 * 1. form 의 입력 값 받아서
		 * 2. vo 생성
		 * 3. service 의 insert 호출
		 * 4. 결과 페이지와 message를 modelAndView 에 바인딩
		 */
		
		/////////////// 브라우저의 모든 쿠키 정보를 받아오는 로직을 추가 > 그 후 allFruits_result 에서 해당 쿠키 판별해서 특정 쿠키 사용 ////////////////////
		ArrayList<String> fruits = new ArrayList<String>();
		Cookie [] cs = request.getCookies();
		if(cs!=null) {
			for(Cookie c : cs) {
				if(c.getName().startsWith("fruitShop")) {
					fruits.add(c.getValue());
				}
			}
		}
		request.setAttribute("fruits", fruits);   // 오늘 본 상품들의 정보가 들어있는 쿠키를 결과 페이지로 바인딩 해서 보냄
		
		List<Item> itemList = itemCatalogueDAO.getItemList();
		
		return new ModelAndView("allFruits_result", "itemList", itemList);  // beans.xml 에서 InternalResourceViewResolver 로 써놨기때문에 위치와 확장자를 안써도 됨
}
	
	@RequestMapping(value="detail.do", method=RequestMethod.GET)
	public ModelAndView getProducts(int itemnumber, HttpServletResponse response) throws Exception {  
		// ?뒤에 붙여준 값은 form에 입력된 name들의 값 갖고 오는것과 동일. 이때  파라미터의 이름이 같으면 form 의 값이 자동 바인딩 된다 !!! get 해서 set 할 필요 없다
		
		/*
		 * 1. form 의 입력 값 받아서
		 * 2. vo 생성
		 * 3. service 의 insert 호출
		 * 4. 결과 페이지와 message를 modelAndView 에 바인딩
		 */
		
		Item item = itemCatalogueDAO.getItem(itemnumber);
		
		
		////////////////// 오늘 본 상품정보를 저장하는 쿠키 로직을 추가////////////////
		//1) 쿠키 생성  
		Cookie cookie = new Cookie ("fruitShop"+itemnumber, "img/"+item.getUrl());  // 쿠키를 보내기 전에 상징적인 값을 붙여준 것 (그 많은 쿠키들 중에서 바로 골라내기 위해서)
		cookie.setMaxAge(24*60*60); // 하루동안 브라우저에서 유지된다
		
		//2) 생성한 쿠키를 브라우저로 보냄
		response.addCookie(cookie);
		
		//return new ModelAndView("detail", "item", item);
		return new ModelAndView("detail2", "item", item);
}

}
