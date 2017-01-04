package com.laks.controller;

import java.util.ArrayList;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laks.model.Category;
import com.laks.model.Product;
import com.laks.services.CategoryService;
import com.laks.services.ProductService;

@Controller
public class Women {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	public void women()
	{
		System.out.println("welcome");
	}
	
	@RequestMapping("/")
	public ModelAndView ff(Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		return new ModelAndView("pro");
		
	}
	
	@RequestMapping("/index")
	public ModelAndView gotoIndex(Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("/categorypage")
	public ModelAndView gotoThatCategory(@ModelAttribute("cat")Category cat,@RequestParam int id,Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		
		List<Product> prodList=productService.getList();
		List<Product> list=new ArrayList<Product>();
		for(Product p:prodList)
		{
			if(p.getCid()==id)
			{
				list.add(p);
			}
		}
		return new ModelAndView("categorypage","prodLt",list);
		
	}
	
	@RequestMapping("/productpage")
	public ModelAndView gotoThatCategory(@ModelAttribute("prod")Product prod,Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		
		List prodList=productService.getList();
		
		return new ModelAndView("productpage","prodLt",prodList);
		
	}
	
	
	@RequestMapping("/pro")
	public ModelAndView gotopro(Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		return new ModelAndView("pro");		
	}
	@RequestMapping("/login")
	public String gotologin(@RequestParam(value="error",required = false) String error, @RequestParam(value="logout",required = false) String logout, Model model) 
	{
		
		if(error!=null)
		{
			model.addAttribute("error","Invalid credentials to enter");
		}
		if(logout!=null)
		{
			model.addAttribute("msg", "You logged out successfully...");
		}
		return  "login";
  	}

	
	@RequestMapping("/admin")
	public String gotoadmin()
	{
		return "admin";
	}
	@RequestMapping("/Thanks")
	public String gotothanks()
	{
		return "Thanks";
	}
	
	
	@RequestMapping("/AdminLogin")
	public String gotoadm()
	{
		return "AdminLogin";
	}
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public String validateLogin(HttpServletRequest r)
	{
		String v=r.getParameter("username");
		String p=r.getParameter("password");
		if((v.equals("priya"))&&(p.equals("1234"))){
			return "admin";
		}
		else
		{
			return "AdminLogin";
		}
	}
	@RequestMapping("/aboutas")
	public ModelAndView gotoabout(Model m)
	{
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		return new ModelAndView("aboutas");
		
	}
	@RequestMapping("/earring")
	public String gotosig()
	{
		return "earring";
	}
	@RequestMapping("/images")
	public String gotor()
	{
		return "images";
	}
	
	@RequestMapping("/bangle")
	public String gotoban()
	{
		return "bangle";
	}
	@RequestMapping("/bracelet")
	public String gotobrace()
	{
		return "bracelet";
	}
	@RequestMapping("/rings")
	public String gotoring()
	{
		return "rings";
	}

	
//Webflow
	@RequestMapping("/index2")
	public String gotoin()
	{
		return "index2";
	}
	
	@RequestMapping("home")
	public String home(){
		return "index2";
	}
}

