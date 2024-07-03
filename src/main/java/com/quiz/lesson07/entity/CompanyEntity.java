package com.quiz.lesson07.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder= true)
@Getter
@Table(name="company")
@Entity
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String business;
	
	private String scale;
	
	private int headcount;
	
	@CreationTimestamp //update 절대 안되게 해준다.
	@Column(name="createdAt")
	private LocalDateTime createdAt;
	
	@UpdateTimestamp //업데이트 할때마다 변경될 수 있게 해준다.
	@Column(name="updatedAt")
	private LocalDateTime updatedAt;
}	
