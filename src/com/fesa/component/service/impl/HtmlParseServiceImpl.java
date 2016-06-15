package com.fesa.component.service.impl;

import com.fesa.component.service.HtmlParseService;

public class HtmlParseServiceImpl implements HtmlParseService {

	@Override
	public String parse(String htmlstr) {
		return "result:"+htmlstr;
	}

}
