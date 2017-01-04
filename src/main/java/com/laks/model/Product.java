package com.laks.model;

import javax.persistence.Entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
//@Table(name="Product")
//@Component
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int fid;
private String name;
private String imgs;
private int sid;
private int cid;
private int quantity;


public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public int getFid() {
	return fid;
}

public void setFid(int fid) {
	this.fid = fid;
}

public int getSid() {
	return sid;
}

public void setSid(int sid) {
	this.sid = sid;
}

public String getImgs() {
	return imgs;
}

public void setImgs(String imgs) {
	this.imgs = imgs;
}
private String desc;
private int price;
@Transient
private MultipartFile file;
public MultipartFile getFile()
{
return file;
}

public void setFile(MultipartFile file) {
	this.file = file;
}
/*
public int getfid() {
	return fid;
}
public void setfid(int fid) {
	this.fid = fid;
}*/
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}


}


