package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryDTO;
import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryRes;
import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryWithMenuRes;
import com.naver.ehd9567.hollys_backend.dto.categoryDto.CategoryWithMenuTypeNameRes;
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

  public int deleteCategory(int category_id);

  public CategoryRes getCategoryWithMenuById(int id);

  public List<CategoryWithMenuRes> getCategoryWithMenu();

  public CategoryWithMenuTypeNameRes getCategoryMenuType(int id);
}
