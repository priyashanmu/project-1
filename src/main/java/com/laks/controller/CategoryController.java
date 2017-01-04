package com.laks.controller;

import java.io.BufferedOutputStream;




import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import com.laks.model.Category;
import com.laks.services.CategoryService;


@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	public CategoryController() {
		// super();
		// TODO Auto-generated constructor stub
		System.out.println("category controller");
	}
	@RequestMapping("/listcategory")
	public @ResponseBody ModelAndView getlistcategory(ModelMap m)
	{
		List<Category> list=categoryService.getList();
		Gson gson=new Gson();
		String st=gson.toJson(list);
		m.addAttribute("priya",st);
		System.out.println("Json"+st);
		 return new ModelAndView("listcategory");
	}
	@RequestMapping("/Category")
	public ModelAndView gotoCategory(@ModelAttribute("cat") Category cat,ModelMap m) {
		List categoryLt = categoryService.getList();
		m.addAttribute("priy",categoryLt);
		
		List categoryList = categoryService.getList();
		return new ModelAndView("Category", "CategoryList", categoryList);
		
	}
		@RequestMapping(value = "saveCategory", method = RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute("cat") Category cat) {
		categoryService.insertRow(cat);
		List categoryList = categoryService.getList();
		return new ModelAndView("Category", "CategoryList", categoryList);
	}

	// @RequestMapping("register")
	// public ModelAndView registerUser(@ModelAttribute Category category) {
	// categoryService.insertRow(category);
	// return new ModelAndView("redirect:list");
	// }

	@RequestMapping("list1")
	public ModelAndView getList() {
		List categoryList = categoryService.getList();
		return new ModelAndView("list1", "CategoryList", categoryList);
	}

	@RequestMapping("deleteCategory")
	public ModelAndView deleteUser(@ModelAttribute("cat")Category cat,@RequestParam int id) {
		categoryService.deleteRow(id);
		List categoryList = categoryService.getList();
		return new ModelAndView("Category","CategoryList", categoryList);
	}
	
	@RequestMapping("editcategory")
	public ModelAndView editUser(@ModelAttribute("cat") Category cat, @RequestParam int id) 
	{
		cat = categoryService.getRowById(id);
		List categoryList = categoryService.getList();
		return new ModelAndView("editcat", "CategoryObject", cat);
	}

	@RequestMapping("updateCategory")
	public ModelAndView updateUser(@ModelAttribute("cat") Category cat) {
		categoryService.updateRow(cat);
		List categoryList = categoryService.getList();
		return new ModelAndView("redirect:Category");
	}

}
