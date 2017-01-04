package com.laks.controller;

import java.io.BufferedOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.laks.model.Product;
import com.laks.services.CategoryService;
import com.laks.services.ProductService;
import com.laks.services.SupplierService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	SupplierService supplierService;

	@Autowired
	CategoryService categoryService;
	
	public ProductController() {
		// super();
		// TODO Auto-generated constructor stub
		System.out.println("product controller");
	}
	@RequestMapping("/listproduct")
	public @ResponseBody ModelAndView getlistproduct(ModelMap m)
	{
		List<Product> list=productService.getList();
		Gson gson=new Gson();
		String st=gson.toJson(list);
		m.addAttribute("priya",st);
		System.out.println("Json"+st);
		 return new ModelAndView("listproduct");
	}
	/*@RequestMapping("/categorypage")
	public ModelAndView gotoThatCategory(@ModelAttribute("cat")Category cat,@RequestParam int id,Model m)
	{
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
	*/
	
	@RequestMapping("/Product")
	public ModelAndView gotoProduct(@ModelAttribute("prod") Product prod,ModelMap m) {
		List categoryLt = categoryService.getList();
		m.addAttribute("priy",categoryLt);
		
		List productList = productService.getList();
		List supplierList = supplierService.getList();
		m.addAttribute("pri",supplierList);
		List categoryList = categoryService.getList();
		m.addAttribute("priy",categoryList);
		
		return new ModelAndView("Product", "ProductList", productList);
		
	}
	@RequestMapping(value = "saveProduct", method = RequestMethod.POST)
	public ModelAndView getForm(@ModelAttribute("prod") Product prod,ModelMap m) 
	{
		
		
			  MultipartFile file = prod.getFile(); 
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
				   image="/resources/ph/"+fileName;
				   //r.setAttribute("img",image);
				   m.addAttribute("img",image);
				   System.out.println("upload success.."+image);
				  }
				   catch (IOException e) {
				   // TODO Auto-generated catch block
					  System.out.println("upload failed..");
				   e.printStackTrace();
				  }
				 
			  }
			  productService.insertRow(prod,image);
			  List productList = productService.getList();
				return new ModelAndView("Product", "ProductList", productList);
					
	}


	@RequestMapping("list")
	public ModelAndView getList() {
		List productList = productService.getList();
		return new ModelAndView("list", "ProductList", productList);
	}

	@RequestMapping("deleteProduct")
	public ModelAndView deleteUser(@ModelAttribute("prod")Product prod,@RequestParam int id) {
		productService.deleteRow(id);
		List productList = productService.getList();
		return new ModelAndView("Product","ProductList", productList);
	}
	
	@RequestMapping("editprod")
	public ModelAndView editUser(@ModelAttribute("prod") Product prod, @RequestParam int id) 
	{
		prod = productService.getRowById(id);
		List productList = productService.getList();
		return new ModelAndView("editProd", "ProductObject", prod);
	}

	@RequestMapping("updateProduct")
	public ModelAndView updateUser(@ModelAttribute("prod") Product prod) {
		productService.updateRow(prod);
		List productList = productService.getList();
		return new ModelAndView("redirect:Product");
	}
//	public void deleteproductquantity(int id) {
//		Product prod = productService.getRowById(id);
//		int quantity = prod.getQuantity();
//		if (quantity == 1) {
//			prod.setQuantity(0);
//			productService.updateRow(prod);
//		} else {
//			prod.setQuantity(quantity - 1);
//			productService.updateRow(prod);
//		}
//	}
//	public void addproctquantity(int id,int cartquantity)
//	{
//		Product prod = productService.getRowById(id);
//		prod.setQuantity(prod.getQuantity()+cartquantity);
//		productService.updateRow(prod);
//	}

}
