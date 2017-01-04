package com.laks.demohandler;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.laks.model.UserBean;
import com.laks.services.UserBeanService;

 
@Component
public class Demohandler {
 
	@Autowired
	UserBeanService userBeanService;
	
	public UserBean initFlow(){
		return new UserBean();
	}
 
	public String validateDetails(UserBean userBean,MessageContext messageContext){
		String status = "success";
		if(userBean.getUserName().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"userName").defaultText("UserName cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getEmail().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"email").defaultText("Email cannot be Empty").build());
			status = "failure";
		}
		if(userBean.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		List<UserBean> usrLt=userBeanService.getList();
		for(UserBean usr:usrLt)
		{
			if(userBean.getUserName().equals(usr.getUserName()))
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"userName").defaultText("UserName already exists..").build());
				status="failure";
			}
		}
		List<UserBean> usr1=userBeanService.getList();
		for(UserBean usr:usr1)
		{
			if(userBean.getEmail().equals(usr.getEmail()))
			{
				messageContext.addMessage(new MessageBuilder().error().source(
						"email").defaultText("Email id already exists..").build());
				status="failure";
			}
		}
		if(!(userBean.getPassword().equals(userBean.getConform_password())))
		{
			messageContext.addMessage(new MessageBuilder().error().source(
					"conform_password").defaultText("Password doesnot match..").build());
			status="failure";
		}
		if(status.equals("success"))
		{
			userBeanService.insertRow(userBean);
		}
		return status;
	}
}