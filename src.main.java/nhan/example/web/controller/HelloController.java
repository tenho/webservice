package nhan.example.web.controller;

import nhan.example.web.util.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController{
	
	public HelloController() {
		System.out.println("HelloController");
	}
	 
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Buddies!");
      return Pages.HELLO_PAGE;
   }

}
