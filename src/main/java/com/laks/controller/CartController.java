package com.laks.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laks.model.Item;
import com.laks.model.Product;
import com.laks.model.Shipping;
import com.laks.services.CategoryService;
import com.laks.services.ItemService;
import com.laks.services.ProductService;
import com.laks.services.ShippingService;

@Controller
public class CartController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ItemService itemService;
	@Autowired
ShippingService shippingService;
	
	@Autowired
	ProductService productService;
	
	public String username;

	@ModelAttribute
	public String getuserdata(HttpServletRequest req) {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		String name = au.getName();
		HttpSession ses = req.getSession();
		ses.setAttribute("u", name);
		username = (String) ses.getAttribute("u");
		System.out.println((String) ses.getAttribute("u"));
		return name;

	}
	
	public CartController() {
	System.out.println("cartCtrl");	// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("addToCart")
	public ModelAndView addToCart(@ModelAttribute("item")Item item,@RequestParam int id,Model m,HttpServletRequest r)
	{
		if(username.equals("anonymousUser"))
		{
			m.addAttribute("msg", "Login to add in cart");
			return new ModelAndView("login");
		}
		Product prod=productService.getRowById(id);
		List<Item> itemLt=itemService.getList();
		List<Item> items=itemLt;
		item=null;
		/*for(int i=0;i<items.size();i++)
		{
			int p=items.get(i).getProduct().getPid();
			if((items.get(i).getUserId().equals(username))&&(p==id))
			{
				item=itemService.getRowById(items.get(i).getItemId());
			}
		}*/
		/*Authentication au = SecurityContextHolder.getContext().getAuthentication();
		String name = au.getName();*/
		for(Item i:itemLt)
		{
			if((i.getUserId().equals(username))&&(i.getProduct().getFid()==id))
			{
				item=itemService.updateQuantity(i.getItemId());
			productService.updateStock(i.getProduct().getFid());
			break;
			}
		}
		if(item==null)
		{
			item=new Item(prod,1,username);
			itemService.insertRow(item);
			productService.updateStock(id);
			
		}
		/*else
		{
			m.addAttribute("modi", "modify the quantity of product over here..");
			List<Item> itemsLt=new ArrayList<Item>();
			for(Item p:itemLt)
			{
				if(p.getUserId().equals(username))
				{
					itemsLt.add(p);
				}
			}
			m.addAttribute("cart", itemsLt);
			return new ModelAndView("cartpage");
		}*/
	
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return new ModelAndView("cartpage");
	}
	
	@RequestMapping("cartpage")
	public String toCartPage(@ModelAttribute("item")Item item,Model m)
	{
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "cartpage";
	}

	@RequestMapping("deleteItem")
	public String deleteItem(@ModelAttribute("item")Item item,@RequestParam int id,Model m)
	{
		itemService.deleteRow(id);
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "cartpage";
	}

	@RequestMapping(value="/updateItem",method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("item")Item item,@RequestParam int id,Model m)
	{
		//Product prod=productService.getRowById(id);
		//item.setProduct(prod);
		item.setUserId(username);
		itemService.updateRow(item);
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		List ls2=categoryService.getList();
		m.addAttribute("listCate", ls2);
		m.addAttribute("cart", itemsLt);
		return "cartpage";
	}
	
	@RequestMapping(value="/ShippingForm")
	public ModelAndView gotoshipping(@ModelAttribute("ship") Shipping ship,ModelMap m) {
		 
		  
			return new ModelAndView("ShippingForm");
	}
	@RequestMapping("/pay")
	public String gotopay(@ModelAttribute("ship") Shipping ship,Model m)
	{
		shippingService.insertRow(ship);
		List<Item> itemLt=itemService.getList();
		List<Item> itemsLt=new ArrayList<Item>();
		for(Item p:itemLt)
		{
			if(p.getUserId().equals(username))
			{
				itemsLt.add(p);
			}
		}
		m.addAttribute("cart",itemLt);
		return "pay";
	}
	
	
	
/*	@RequestMapping("addToCart")
	public ModelAndView addToCart(@ModelAttribute("prod")Product prod,@RequestParam int id,Model m,HttpSession s)
	{
		if(s.getAttribute("cart")==null)
		{
			List<Item> cart=new ArrayList<Item>();
			cart.add(new Item(productService.getRowById(id),1));
			s.setAttribute("cart", cart);
		}
		else
		{
			List<Item> cart=(List<Item>) s.getAttribute("cart");
			int index=isExisting(id,s);
			if(index==-1)
			{
				cart.add(new Item(productService.getRowById(id),1));
			}
			else
			{
				int quantity=cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(quantity);
			}
			m.addAttribute("cart", cart);
		}
		return new ModelAndView("cartpage");
	}
	
	@RequestMapping("deleteThisProduct")
	public ModelAndView toRemoveThatProduct(@ModelAttribute("prod")Product prod,@RequestParam int id,Model m,HttpSession s)
	{
		List<Item> cart=(List<Item>) s.getAttribute("cart");
		int index=isExisting(id,s);
		cart.remove(index);
		m.addAttribute("cart", cart);
		return new ModelAndView("cartpage");
	}
	
	private int isExisting(int id,HttpSession s)
	{
		List<Item> cart=(List<Item>) s.getAttribute("cart");
		for(int i=0;i<cart.size();i++)
		{
			if(cart.get(i).getProduct().getFid()==id)
			{
				return i;
			}
		}
		return -1;
	}
*/
}
