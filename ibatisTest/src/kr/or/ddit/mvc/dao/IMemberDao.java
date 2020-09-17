package kr.or.ddit.mvc.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 
 * service에 전달하는 Dao의 interface
 * 
 * @author PC-13
 *
 */
public interface IMemberDao {
	/**
	 * MemberVO에 담겨진 자료를 DB에 insert하는 메소드
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return insert 작업성공 : 1, 작업실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메소드
	 * @param memId 삭제할 회원 ID
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO자료를 이용하여 DB에 update하는 메소드
	 * @param memVo update할 회원 정보가 들어있는 MemberVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 전체 회원 정보를 db에서 가져와 List에 담아서 반환하는 메소드 
	 * @return 회원정보(MemberVO)가 저장될 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메소드
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원 ID의 개수
	 */
	public int getMemberCount(String memId);
	
	/**
	 * 특정 정보만 DB에 update하는 메소드
	 * @param updateField
	 * @param updateData
	 * @param memId
	 * @return
	 */
	public int updateMember2(Map<String, String> param);
}
















