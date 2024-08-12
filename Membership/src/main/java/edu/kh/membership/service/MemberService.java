package edu.kh.membership.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.MemberDTO;

public interface MemberService {

	/**
	 * 전달받은 정보로 새 MemberDTO 객체 생성후 List에 추가하기
	 * @param name 회원 이름
	 * @param phone 회원 전화번호
	 * @return	전화번호가 일치하면 추기하지 않고 false반환 / 성공하면 true
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	boolean addMember(String name, String phone) throws FileNotFoundException, IOException;

	/**
	 * 멤버리스트 반환
	 * @return
	 */
	List<MemberDTO> getAllMembers();
	
	/**
	 * 숫자 4개 받아서 뒤에서부터 4자리 검색
	 */
	List<MemberDTO> searchMembership(String searchPH);

}
