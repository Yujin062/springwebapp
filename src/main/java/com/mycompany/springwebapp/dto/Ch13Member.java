package com.mycompany.springwebapp.dto;

import lombok.Data;

@Data
public class Ch13Member {
	private String mid;
	private String mname;
	private String mpassword;
	private boolean menablaed; 
	private String mrole;
	private String memail;
}
