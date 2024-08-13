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


	/**
	 * 전화번호와 금액을 전달받고 전화번호에 일치하는 객체에 금액 누적 후
	 * 성공결과 반환
	 * @param phone
	 * @param amount
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	boolean addAmount(String phone, int amount) throws FileNotFoundException, IOException;


	/**
	 * 핸드폰번호를 받고 해당하는 멤버 삭제
	 * @param phone
	 * @return 삭제한 MemberDTO를 담은 객체
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	MemberDTO deleteMember(String phone) throws FileNotFoundException, IOException;

	/**
	 * 전화번호와 이름, 새 전화번호를 입력받아 회원정보 수정
	 * 1. 검색할 전화번호 길이가 10,11이 아니면 false
	 * 2. 새 전화번호 길이가 10,11이 아니면 false
	 * 3. 새 전화번호가 이전에 있는 번호라면 false
	 * 4. 값이 없다면 이전 값을 그대로 사용
	 * @param beforePhone
	 * @param name
	 * @param phone
	 * @return 성공여부
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	boolean updateMember(String beforePhone, String name, String phone) throws FileNotFoundException, IOException;

}
