package com.sun1023.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freeBoard")
public class FreeController {

	@RequestMapping("/freeList")
	public String freeList() {
		
		return "/freeBoard/freeList";
	}
	
}
