package edu.kh.membership.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.kh.membership.dto.MemberDTO;

public interface MemberDAO {
	
	/**
	 * 파일저장메섣
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	void saveFile() throws FileNotFoundException, IOException;

	
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
	 * @return memberList
	 */
	List<MemberDTO> getAllMembers();

}
