package com.springboot.FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

	@Query("select m From Menu m WHERE m.mname =?1")
	public Menu getMenuByMenuName(String mname);
}
