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
	
	
}
