package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.CategoryDTO;
import com.naver.ehd9567.hollys_backend.dto.ProductDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryDAO {

  public List<CategoryDTO> getAllCategory();

  public CategoryDTO getById(Integer id);

  public List<CategoryDTO> getByMenu_fk(Integer menu_fk);

  public CategoryDTO getByType(String type);

  public int setCategory(CategoryDTO setDTO);

  public int putCategory(CategoryDTO putDTO);
}
