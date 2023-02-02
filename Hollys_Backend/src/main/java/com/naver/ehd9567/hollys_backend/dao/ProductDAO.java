package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.productDto.ProductDTO;
import com.naver.ehd9567.hollys_backend.dto.productDto.ProductRes;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {
  public List<ProductDTO> getAllProducts();

  public ProductDTO getProductById(int id);

  public ProductDTO getProductByName(String name);

  public int setProduct(ProductDTO product);

  public int putProduct(ProductDTO putID);

  public int deleteProduct(int id);

  public ProductRes getProductMap(int id);

  public List<ProductRes> getProductInfos();
}
