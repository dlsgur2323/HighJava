package kr.or.ddit.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberController {
	private Scanner sc;
	private IMemberService service;
	
	public MemberController() {
		sc = new Scanner(System.in);
		service = new MemberServiceImpl();
	}
	
	public static void main(String[] args) {
		new MemberController().start();
	}
		
	private void start() {
		while(true){
			System.out.println("\n\n\n");
			System.out.println("-- 작업 선택 --");
			System.out.println("1. 자료 추가");
			System.out.println("2. 자료 삭제");
			System.out.println("3. 자료 수정");
			System.out.println("4. 전체 자료 출력");
			System.out.println("5. 자료 수정2");
			System.out.println("0. 작업 끝");
			System.out.println("------------");
			System.out.print("원하는 작업 선택 >");
			int input = Integer.parseInt(sc.nextLine());
			switch(input){
			case 1 :
				insertData();
				break;
			case 2 :
				deleteData();
				break;
			case 3 :
				updateData();
				break;
			case 4 :
				printData();
				break;
			case 5 :
				updateData2();
				break;
			case 0 :
				System.out.println("작업 종료...");
				System.exit(0);
			default :
				System.out.println("잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}

	private void updateData2() {
		System.out.println("-- 자료 수정2 --");
		String memId = "";

		System.out.print("수정 할 ID를 입력하세요 >>");
		memId = sc.nextLine();
		int cnt = service.getMemberCount(memId);
		if(cnt==0){
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} 
		
		int num;
		String updateField = null; // 수정 작업을 진행할 컬럼이 저장될 변수
		String updateTitle = null; // 
		do{
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1. 회원 이름  2. 전화번호  3. 주소");
			System.out.println("-----------------------------");
			System.out.print("수정할 항목 >>");
			num = Integer.parseInt(sc.nextLine());
			switch(num){
				case 1 :
					updateField = "MEM_NAME";
					updateTitle = "회원이름";
					break;
				case 2 :
					updateField = "MEM_TEL";
					updateTitle = "전화번호";
					break;
				case 3 :
					updateField = "MEM_ADDR";
					updateTitle = "주소";
					break;
				default :
					System.out.println("잘못 선택했습니다.");
					System.out.println("다시 선택하세요.");
			}
		}while(num <1 || num >3);
		
		// 수정할 데이터 입력 받기
		System.out.println();
		System.out.print("새로운" + updateTitle + " >>");
		String updateData = sc.nextLine();
		
		Map<String, String> param = new HashMap<>();
		param.put("field", updateField);
		param.put("data", updateData);
		param.put("id", memId);
		
		int count = service.updateMember2(param);
		if(count>0){
			System.out.println("Update 성공!!");
		} else {
			System.out.println("Update 실패~~");
		}
		
		
	}
	
	private void printData() {
		List<MemberVO> memList = service.getAllMember();
		System.out.println("\t-- 전체 자료 출력 --\n");
		System.out.println("ID\t이름\t전화번호\t\t주소");
		System.out.println("-----------------------------------");
		if(memList==null || memList.size()==0){
			System.out.println("회원 정보가 하나도 없습니다...");
		} else {
			for(MemberVO mem : memList){
				System.out.println(mem.getMem_id() + "\t" + mem.getMem_name() + "\t" + mem.getMem_tel() + "\t" + mem.getMem_addr());
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("출력 작업 끝...");
		
	}

	private void updateData() {
		System.out.println("-- 자료 수정 --");
		String memId = "";
		System.out.print("수정 할 ID를 입력하세요 >>");
		memId = sc.nextLine();
		int cnt = service.getMemberCount(memId);
		if(cnt==0){
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} 
		System.out.print("이 름 >");
		String name = sc.nextLine();
		System.out.print("PH >");
		String ph = sc.nextLine();
		System.out.print("주 소 >");
		String addr = sc.nextLine();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(name);
		memVo.setMem_tel(ph);
		memVo.setMem_addr(addr);
		
		int count = service.updateMember(memVo);
		if(count >0){
			System.out.println(memId + "회원 정보 수정 성공");
		} else {
			System.out.println(memId + "회원 정보 수정 실패");
		}
	}

	private void deleteData() {
		System.out.println("-- 자료 삭제 --");
		String memId = "";
		System.out.print("수정 할 ID를 입력하세요 >>");
		memId = sc.nextLine();
		int cnt = service.getMemberCount(memId);
		if(cnt==0){
			System.out.println("존재하지 않는 ID입니다.");
			return;
		} 
		
		int count = service.deleteMember(memId);
		if(count >0){
			System.out.println(memId + "회원 정보 삭제 성공");
		} else {
			System.out.println(memId + "회원 정보 삭제 실패");
		}
	}

	private void insertData() {
		System.out.println("-- 자료 추가 --");
		String memId = "";
		int cnt = 0;
		do{
			System.out.print("ID를 입력하세요 >>");
			memId = sc.nextLine();
			cnt = service.getMemberCount(memId);
		}while(cnt>0);
		
		System.out.print("이 름 >");
		String name = sc.nextLine();
		System.out.print("PH >");
		String ph = sc.nextLine();
		System.out.print("주 소 >");
		String addr = sc.nextLine();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(name);
		memVo.setMem_tel(ph);
		memVo.setMem_addr(addr);
		
		int count = service.insertMember(memVo);
		if(count >0){
			System.out.println(memId + "회원 정보 추가 성공");
		} else {
			System.out.println(memId + "회원 정보 추가 실패");
		}
	}

}
