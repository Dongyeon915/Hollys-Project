package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.MenuDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDAO {

  public List<MenuDTO> getAllMenu();
  public MenuDTO getMenuById(Integer id);
  public MenuDTO getMenuByName(String name);
}
