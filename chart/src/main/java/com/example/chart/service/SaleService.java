package com.example.chart.service;

import java.util.List;
import java.util.Map;

public interface SaleService {
	
	public Map<String,Object> test();

	public Map<String, Object> getInfo();
	
	public List<Map<String, Object>> getCode(Integer length);

}
