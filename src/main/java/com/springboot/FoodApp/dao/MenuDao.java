package com.springboot.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.FoodApp.dto.Menu;
import com.springboot.FoodApp.repo.MenuRepo;

@Repository
public class MenuDao {

	@Autowired
	private MenuRepo repo;
	
	public Menu saveMenu(Menu menu)
	{
		return repo.save(menu);
	}

	public Menu updateMenu(int id, Menu menu) {
		
		Optional<Menu> menu2 = repo.findById(id);
		if(menu2.isPresent())
		{
			menu.setMid(id);
			return repo.save(menu);
		}
		else {
			return null;
		}
	}

	public Menu deleteMenu(int id) {

          Menu menu = repo.findById(id).get();
         if(menu != null)
         {
        	 repo.deleteById(id);
        	 return menu;
         }
		return null;
	}
	
	public Menu getMenuById(int id)
	{
		Optional<Menu> menu = repo.findById(id);
		if(menu.isPresent()) {
			return menu.get();
		}
		return null;
	}

	public Menu getMenuByName(String mname) {
		Menu menu = repo.getMenuByMenuName(mname);
		if(menu != null) {
			return menu;
		}
		return null;
	}
	

}
