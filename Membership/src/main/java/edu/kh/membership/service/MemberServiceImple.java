package edu.kh.membership.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.membership.dao.MemberDAO;
import edu.kh.membership.dao.MemberDAOImpl;
import edu.kh.membership.dto.MemberDTO;

public class MemberServiceImple implements MemberService {
	
	MemberDAO dao = null;
	
	public MemberServiceImple() throws IOException {
		dao = new MemberDAOImpl();
	}
	
	//--------------------------------------------------------------
	@Override
	public boolean addMember(String name, String phone) throws FileNotFoundException, IOException {
		if(phone.length()<10 || phone.length()>11) {
			return false;
		}
		
		return dao.addMember(name,phone);
	}
	
	//--------------------------------------------------------------
	
	@Override
	public List<MemberDTO> getAllMembers() {
		return dao.getAllMembers();
	}
	
	//--------------------------------------------------------------
	/**
	 * 4자리의 전화번호 검색 후 일치하는 멤버리스트 반환
	 */
	@Override
	public List<MemberDTO> searchMembership(String searchPH) {
		List<MemberDTO> searchMembership = new ArrayList<MemberDTO>();
		
		List<MemberDTO> memberList = dao.getAllMembers();
		
		for(MemberDTO member : memberList) {
			String phone = member.getPhone();
			if( ( phone.substring(phone.length()-4) ).equals(searchPH)) searchMembership.add(member);
		}
		
		return searchMembership;
	}
	
	//--------------------------------------------------------------
	/**
	 * 전화번호 검색 후 일치하는 멤버반환
	 */
	@Override
	public MemberDTO searchMember(String phone) {
		// 전호번호 10~11자리인지 검사
		if(phone.length() < 10 || phone.length() >11) return null;
		
		List<MemberDTO> memberList = dao.getAllMembers();
		for(MemberDTO member : memberList) {
			if(member.getPhone().equals(phone)) return member;
		}
		return null;
	}
	
	//--------------------------------------------------------------
	/**
	 * 전화번호와 금액을 전달받고 전화번호에 일치하는 객체에 금액 누적 후
	 * 성공결과 반환
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public boolean addAmount(String phone, int amount) throws FileNotFoundException, IOException {
		return dao.addAmount(phone, amount);
	}
	
	//--------------------------------------------------------------
	/**
	 * 이름을 입력받아 전달받은이름이 포함된 모든 객체를
	 * searchList에 저장해서 return
	 */
	@Override
	public List<MemberDTO> searchName(String name) {
		List<MemberDTO> searchList = new ArrayList<MemberDTO>();
		List<MemberDTO> memberList = getAllMembers();
		
		for(MemberDTO member : memberList) {
			if(member.getName().contains(name)) {
				searchList.add(member);
			}
		}
		
		return searchList;
	}
	
	//--------------------------------------------------------------
	/**핸드폰번호를 받고 해당하는 멤버 삭제
	 * @param phone
	 * @return 삭제한 MemberDTO를 담은 객체
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public MemberDTO deleteMember(String phone) throws FileNotFoundException, IOException {
		return dao.deleteMember(phone);
	}
	
	
	//--------------------------------------------------------------
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
	@Override
	public boolean updateMember(String beforePhone, String name, String phone) throws FileNotFoundException, IOException {
		
		// 전화번호 확인
		// 2.새 전화번호 길이가 10,11이 아니면 false, 0일수도 있으니까 봐줌
		if(phone.length() != 10 && phone.length() != 11 && phone.length() != 0) return false;
		// 3.새 전화번호가 이전에 있는 번호라면 false
		//   같은경우라면 pass
		List<MemberDTO> memberList = getAllMembers();
		
		if( !beforePhone.equals(phone) ) {
			for(MemberDTO member : memberList) {
				if(member.getPhone().equals(phone)) {
					return false;
				}
			}
		}
		return dao.updateMember(beforePhone, name, phone);
	}
	
	
	
	
	
	
	
}
