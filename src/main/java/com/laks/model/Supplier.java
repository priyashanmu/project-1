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
//@Table(name="Supplier")
//@Component
public class Supplier {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int fid;
private String name;
private String address;

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public int getfid() {
	return fid;
}
public void setfid(int fid) {
	this.fid = fid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}




}


