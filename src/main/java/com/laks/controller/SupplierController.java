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

import com.laks.model.Supplier;
import com.laks.services.CategoryService;
import com.laks.services.SupplierService;


@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	@Autowired
	CategoryService categoryService;

	public SupplierController() {
		// super();
		// TODO Auto-generated constructor stub
		System.out.println("supplier controller");
	}
	@RequestMapping("/listsupplier")
	public @ResponseBody ModelAndView getlistsupplier(ModelMap m)
	{
		List<Supplier> list=supplierService.getList();
		Gson gson=new Gson();
		String st=gson.toJson(list);
		m.addAttribute("priya",st);
		System.out.println("Json"+st);
		 return new ModelAndView("listsupplier");
	}
	@RequestMapping("/Supplier")
	public ModelAndView gotoSupplier(@ModelAttribute("sub") Supplier sub,ModelMap m) {
		List categoryLit = categoryService.getList();
		m.addAttribute("priy",categoryLit);
		
		List supplierList = supplierService.getList();
		return new ModelAndView("Supplier", "SupplierList", supplierList);
		
	}
	/*@RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute("sub") Supplier sub,ModelMap m) 
	{
		
		
			  MultipartFile file = sub.getFile(); 
			  String fileName = "";
			  
			  String image="";
			  if(!file.isEmpty())		 
			  {
				  try 
				  {
					  System.out.println("inside try");
				  fileName = file.getOriginalFilename();
				  byte[] filesize=file.getBytes();
				  BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\Selvam\\workspace\\aa\\src\\main\\webapp\\resources\\pho\\" + fileName)));
				   bout.write(filesize);
				   bout.close();
				   image="/resources/pho/"+fileName;
				   //r.setAttribute("img",image);
				   m.addAttribute("img",image);
				   System.out.println("upload success.."+image);
				  }
				   subch (IOException e) {
				   // TODO Auto-generated subch block
					  System.out.println("upload failed..");
				   e.printStackTrace();
				  }
				 
			  }
			  supplierService.insertRow(sub,image);
			  List supplierList = supplierService.getList();
				return new ModelAndView("Supplier", "SupplierList", supplierList);
					
	}

*/	@RequestMapping(value = "saveSupplier", method = RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute("sub") Supplier sub) {
		supplierService.insertRow(sub);
		List supplierList = supplierService.getList();
		return new ModelAndView("Supplier", "SupplierList", supplierList);
	}

	// @RequestMapping("register")
	// public ModelAndView registerUser(@ModelAttribute Supplier supplier) {
	// supplierService.insertRow(supplier);
	// return new ModelAndView("redirect:list");
	// }

	@RequestMapping("list2")
	public ModelAndView getList() {
		List supplierList = supplierService.getList();
		return new ModelAndView("list2", "SupplierList", supplierList);
	}

	@RequestMapping("deleteSupplier")
	public ModelAndView deleteUser(@ModelAttribute("sub")Supplier sub,@RequestParam int id) {
		supplierService.deleteRow(id);
		List supplierList = supplierService.getList();
		return new ModelAndView("Supplier","SupplierList", supplierList);
	}
	
	@RequestMapping("editsupplier")
	public ModelAndView editUser(@ModelAttribute("sub") Supplier sub, @RequestParam int id) 
	{
		sub = supplierService.getRowById(id);
		List supplierList = supplierService.getList();
		return new ModelAndView("editsub", "SupplierObject", sub);
	}

	@RequestMapping("updateSupplier")
	public ModelAndView updateUser(@ModelAttribute("sub") Supplier sub) {
		supplierService.updateRow(sub);
		List supplierList = supplierService.getList();
		return new ModelAndView("redirect:Supplier");
	}

}
