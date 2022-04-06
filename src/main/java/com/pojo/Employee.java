package com.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(setterPrefix = "set")
public class Employee {

	private String first_name;
	private String last_name;
	private String id;
	private String email;

		
}
