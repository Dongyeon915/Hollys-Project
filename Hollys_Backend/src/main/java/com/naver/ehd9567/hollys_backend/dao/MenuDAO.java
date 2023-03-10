package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuDTO;
import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuRes;
import com.naver.ehd9567.hollys_backend.dto.menuDto.MenuResTest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDAO {

    public List<MenuDTO> getAllMenu();

    public MenuDTO getMenuById(Integer id);

    public MenuDTO getMenuByName(String name);

    public int setMenu(MenuDTO menuDTO);

    public int updateMenu(MenuDTO menu);

    public int deleteMenu(Integer menu_id);

//    public MenuRes getCategoryWithMenusById(int id);

    public MenuResTest getMenuDetail(int id);
}
