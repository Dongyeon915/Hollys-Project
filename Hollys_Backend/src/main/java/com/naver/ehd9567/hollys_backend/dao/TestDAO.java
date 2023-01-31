package com.naver.ehd9567.hollys_backend.dao;

import com.naver.ehd9567.hollys_backend.dto.TestDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDAO {

    public int setTest(TestDTO testDTO);

    public List<TestDTO> getTest();

    public int putTest(TestDTO testDTO);

    public int deleteTest(int id);

}