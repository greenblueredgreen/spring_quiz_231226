package com.quiz.lesson05.domain;


import java.time.LocalDateTime;

public class Member {
	
	//member.setName("유비");
//	member.setPhoneNumber("010-1234-5678");
//	member.setEmail("youbee@gmail.com");
//	member.setNationality("삼국시대 촉한");
//	member.setIntroduce("저는 촉의 군주 유비입니다. 삼국통일을 위해 열심히 일하겠습니다.");
//	member.setBirth(LocalDate.of(161, 7, 9));
//	members.add(member);
	
	private String name;
	private String phoneNumber;
	private String email;
	private String nationality;
	private String introduce;
	private LocalDateTime birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public LocalDateTime getBirth() {
		return birth;
	}
	public void setBirth(LocalDateTime birth) {
		this.birth = birth;
	}
}

