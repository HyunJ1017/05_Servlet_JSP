package edu.kh.membership.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.kh.membership.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	
	List<MemberDTO> memberList = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	final String FILE_PATH = "/workspace/files/membership.dat";
	
	// 기본생성자
	public MemberDAOImpl() throws IOException {
		
		try {
			File file = new File(FILE_PATH);
			if ( !file.exists() ) {
				memberList = new ArrayList<MemberDTO>();
			} else {
				ois = new ObjectInputStream( new FileInputStream( FILE_PATH ));
				memberList = (List<MemberDTO>) ois.readObject();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if( ois != null ) ois.close();
		}
		
	}
	
	//------------------------------------------------------------------------------
	
	/**
	 * 파일저장메서드
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		oos = new ObjectOutputStream( new FileOutputStream(FILE_PATH));
		oos.writeObject(memberList);
	}
	
	//------------------------------------------------------------------------------
	private void reEnterGrade(String phone) {
		for(MemberDTO member : memberList) {
			if(member.getPhone().equals(phone)) {
				int amount = member.getAmount();
				if(amount<100000)member.setGrade(0);
				else if(amount<200000)member.setGrade(1);
				else if(amount<500000)member.setGrade(2);
				else member.setGrade(3);
			}
		}
	}
	
	//------------------------------------------------------------------------------
	/**
	 * 전달받은 정보로 새 MemberDTO 객체 생성후 List에 추가하기
	 * @param name 회원 이름
	 * @param phone 회원 전화번호
	 * @return	전화번호가 일치하면 추기하지 않고 false반환 / 성공하면 true
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public boolean addMember(String name, String phone) throws FileNotFoundException, IOException {
		
		for(MemberDTO member : memberList) {
			if(member.getPhone().equals(phone)) return false;
		}
		
		MemberDTO newMem = new MemberDTO(name, phone, 0, 0);
		memberList.add(newMem);
		saveFile();
		return true;
	}
	//------------------------------------------------------------------------------

	@Override
	public List<MemberDTO> getAllMembers() {
		return memberList;
	}
	
	//------------------------------------------------------------------------------
	/**
	 * 전화번호와 금액을 전달받고 전화번호에 일치하는 객체에 금액 누적 후
	 * 성공결과 반환
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public boolean addAmount(String phone, int amount) throws FileNotFoundException, IOException {
		for(MemberDTO member : memberList) {
			if(member.getPhone().equals(phone)) {
				member.setAmount(member.getAmount()+amount);
				reEnterGrade(phone);
				saveFile();
				return true;
			}
		}
		return false;
	}
	
	//------------------------------------------------------------------------------
	/**핸드폰번호를 받고 해당하는 멤버 삭제
	 * @param phone
	 * @return 삭제한 MemberDTO를 담은 객체
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public MemberDTO deleteMember(String phone) throws FileNotFoundException, IOException {
		MemberDTO delMem = null;
		for(int i=0 ; i<memberList.size();i++) {
			if(memberList.get(i).getPhone().equals(phone)) {
				delMem=memberList.remove(i);
				saveFile();
				break;
			}
		}
		return delMem;
	}
	
	//------------------------------------------------------------------------------
	/**
	 * 전화번호와 이름, 새 전화번호를 입력받아 회원정보 수정
	 * 1. 검색할 전화번호 길이가 10,11이 아니면 false
	 * 2. 새 전화번호 길이가 10,11이 아니면 false
	 * 3. 새 전화번호가 이전에 있는 번호라면 false
	 * 4. 값이 없다면 이전 값을 그대로 사용
	 * 1~3 service에서 처리 완료
	 * @param beforePhone
	 * @param name
	 * @param phone
	 * @return 성공여부
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	@Override
	public boolean updateMember(String beforePhone, String name, String phone) throws FileNotFoundException, IOException {
		
		for( MemberDTO member : memberList) {
			
			if( member.getPhone().equals(beforePhone) ) {
				
				if(name.length()==0) name = member.getName();
				if(phone.length()==0) phone = member.getPhone();
				member.setName(name);
				member.setPhone(phone);
				
				saveFile();
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
