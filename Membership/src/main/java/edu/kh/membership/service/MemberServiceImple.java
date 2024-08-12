package edu.kh.membership.service;

import java.io.FileNotFoundException;
import java.io.IOException;
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
		return dao.addMember(name,phone);
	}
	
	//--------------------------------------------------------------
	
	@Override
	public List<MemberDTO> getAllMembers() {
		return dao.getAllMembers();
	}
	
	//--------------------------------------------------------------
	/**
	 * 전화번호 검색 후 일치하는 멤버리스트 반환
	 */
	@Override
	public List<MemberDTO> searchMembership(String searchPH) {
		List<MemberDTO> searchMembership = null;
		
		List<MemberDTO> memberList = dao.getAllMembers();
		
		for(MemberDTO member : memberList) {
			if(member.getPhone().substring(0, 4).equals(searchPH)) searchMembership.add(member);
		}
		
		return searchMembership;
	}
	
}
