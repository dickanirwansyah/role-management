package com.arms.app.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/sample")
@ResponseBody
public class SampleController {

	
	@RequestMapping(path = "/list-sample", method = RequestMethod.GET)
	public Map listSample() throws NamingException {
		List<Map<String, Object>> lData=new ArrayList<>();
		
		Map<String,Object> m1=new LinkedHashMap<>();
		m1.put("id", "001");
		m1.put("nama", "ANTON");
		m1.put("alamat", "MERUYA");
		
		Map<String,Object> m2=new LinkedHashMap<>();
		m2.put("id", "002");
		m2.put("nama", "MIRNA");
		m2.put("alamat", "BOGOR");
		
		
		lData.add(m1);
		lData.add(m2);
		lData.add(m2);
		
		Map<String,Object> map=new LinkedHashMap<>();
		map.put("data", lData);
		
		
		return map;
		
	}
}
