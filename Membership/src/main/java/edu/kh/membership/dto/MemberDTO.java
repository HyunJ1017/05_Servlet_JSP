package edu.kh.membership.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO implements Serializable {

	private String name;	// 이름
	private String phone;	// 폰넘버
	private int amount;		// 누적금액
	private int grade;		// 멤버등급	0,1,2,3
	
}
