package com.example.chart.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SaleDao {
	
	public Map<String,Object> test();
	
	public List<Map<String,Object>> getSalesInfo();
	
	public List<Map<String,Object>> getCode(Integer length);

}
