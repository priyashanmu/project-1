package com.laks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laks.model.Item;
import com.laks.model.UserBean;
import com.laks.services.ItemService;
import com.laks.services.UserBeanService;



@Controller
public class MailController {
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired 
	UserBeanService userBeanService;
    @Autowired
    ItemService itemService;
    @Autowired
    CartController ca;
	public MailController() {
//		super();
		// TODO Auto-generated constructor stub
		System.out.println("inside controller");
	}

	@RequestMapping("/mail")
	public String gotoHome(Model m)
	{
		String username=ca.username;
		List<UserBean> userLt=userBeanService.getList();
		List<Item> itemLt=itemService.getList();
		List<Item> items=new ArrayList<Item>(); 
		for(UserBean u:userLt)
		{
			if(u.getUserName().equals(username))
			{
				m.addAttribute("email",u.getEmail() );
				break;
			}
		}
		for(Item i:itemLt)
		{
		if(i.getUserId().equals(username))
		{
			items.add(i);
		}
		}
		m.addAttribute("cart", items);
	
		return "mail";
	}
	
	@RequestMapping(value="/sendEmail", method = RequestMethod.POST)
	public String doSendEmail(HttpServletRequest request) {
		// takes input from e-mail form
		String recipientAddress = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String from = "r.priya8940@gmail.com";
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		
		// forwards to the view named "Result"
		return "Thanks";
	}
}