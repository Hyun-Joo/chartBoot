package com.example.chart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.chart.service.SaleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SaleController extends AbstractController {
	
	@Autowired
	SaleService saleService;
	
	@GetMapping("/test1")
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = saleService.test();
		mav.addObject("data", map);
		mav.setViewName("test");
		return mav;
	}
	
	@GetMapping("/chart/index")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageName", "GOOGLE CHART");
		
		List<Map<String,Object>> regionList = saleService.getCode(2);
		List<Map<String,Object>> colorList = saleService.getCode(0);
		mav.addObject("regionList", regionList);
		mav.addObject("colorList", colorList);
		log.info("regionList => {}",regionList);
		log.info("colorList => {}",colorList);
		
		mav.setViewName("chartIndex");
		return mav;
	}
	
	@PostMapping("/chart/getData")
	public Map<String,Object> getData() throws Exception {
		Map<String,Object> result = saleService.getInfo();
		return result;
	}

}
