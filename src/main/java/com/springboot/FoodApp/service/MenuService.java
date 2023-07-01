package com.springboot.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.FoodApp.config.ResponseStruct;
import com.springboot.FoodApp.dao.MenuDao;
import com.springboot.FoodApp.dto.Menu;
import com.springboot.FoodApp.exception.UserNameNotFoundException;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;
	
	public ResponseEntity<ResponseStruct<Menu>> saveMenu(Menu menu)
	{
		Menu saveMenu = dao.saveMenu(menu);
		if(saveMenu != null)
		{
			ResponseStruct<Menu> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.CREATED.value());
			resp.setMessaga("Menu Successufully saved");
			resp.setData(menu);
			return new ResponseEntity<ResponseStruct<Menu>>(resp, HttpStatus.CREATED);
		}
		return null;
	}

	public ResponseEntity<ResponseStruct<Menu>> updateMenu(int id, Menu menu) {

		Menu updateMenu = dao.updateMenu(id, menu);
		if(updateMenu != null) {
			ResponseStruct<Menu> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessaga("Menu Successufully Updated");
			resp.setData(menu);
			return new ResponseEntity<ResponseStruct<Menu>>(resp, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<ResponseStruct<Menu>> deleteMenu(int id) {
        
		Menu deleteMenu = dao.deleteMenu(id);
		if(deleteMenu != null)
		{
			ResponseStruct<Menu> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.OK.value());
			resp.setMessaga("Menu Successufully Deleted");
			resp.setData(deleteMenu);
			return new ResponseEntity<ResponseStruct<Menu>>(resp, HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStruct<Menu>> getMenuById(int id)
	{
		Menu menuById = dao.getMenuById(id);
		if(menuById != null)
		{
			ResponseStruct<Menu> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.FOUND.value());
			resp.setMessaga("Menu Successufully Found");
			resp.setData(menuById);
			return new ResponseEntity<ResponseStruct<Menu>>(resp, HttpStatus.FOUND);
		}
		return null;
	}

	public ResponseEntity<ResponseStruct<Menu>> getMenuByName(String mname) {
		
		Menu menuByName = dao.getMenuByName(mname);
		if(menuByName != null)
		{
			ResponseStruct<Menu> resp = new ResponseStruct<>();
			resp.setStatus(HttpStatus.FOUND.value());
			resp.setMessaga("Menu Successufully Found");
			resp.setData(menuByName);
			return new ResponseEntity<ResponseStruct<Menu>>(resp, HttpStatus.FOUND);
		}
		else {
			throw new UserNameNotFoundException("Item with this name is not present");
		}
	}

}
