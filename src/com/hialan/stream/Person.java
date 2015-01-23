package com.hialan.stream;

import java.time.LocalDate;

/**
 * User: Alan
 * Email:alan@hialan.com
 * Date: 12/10/14 11:39
 */
public class Person {
	String name;
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	public int getAge() {
		return LocalDate.now().getYear() - birthday.getYear();
	}

	public void setBirthday(LocalDate birthday){
		this.birthday = birthday;
	}

	public void setGender(Sex sex){
		this.gender = sex;
	}

	public void printPerson() {
		System.out.println("The name is " + name);
	}

	public Sex getGender(){
		return gender;
	}

	public enum Sex {
		MALE, FEMALE
	}
}
