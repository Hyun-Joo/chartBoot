package com.example.chart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chart.repository.SaleDao;
import com.example.chart.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	SaleDao saleDao;

	@Override
	public Map<String, Object> test() {
		
		Map<String, Object> result = null;
		try {
			result = saleDao.test();
		} catch (Exception e) {
			log.error("테스트 조회 실패: {}",e.getMessage());
		}
		
		return result;
	}

	@Override
	public Map<String, Object> getInfo() {
		Map<String, Object> result = null;
		try {
			long start = System.currentTimeMillis();
			List<Map<String, Object>> list = saleDao.getSalesInfo();
			long end = System.currentTimeMillis();
			double time = (end-start)/1000.0;
			
			result = new HashMap<>();
			result.put("list", list);
			result.put("time", time);
		} catch (Exception e) {
			log.error("리스트 조회 실패: {}",e.getMessage());
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getCode(Integer length) {
		List<Map<String, Object>> result = null;
		try {
			result = saleDao.getCode(length);
		} catch (Exception e) {
			log.error("코드 조회 실패: {}",e.getMessage());
		}
		return result;
	}

}
