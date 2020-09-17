package kr.or.ddit.basic;

import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

// ibatis를 이용하여 DB자료를 처리하는 예제
public class LprodIbatisTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 처리 순서
		
		// 1. ibatis 설정 파일을 읽어와서 실행한다. (sqlMapConfig.xml파일)
		try {
			// 1-1. 문자 인코딩 캐릭터 셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경 설정파일 읽어오기
			Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			//		sql문을 호출해서 실행할 수 있는 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close(); // 스트림 닫기
			
			// ----------------------------------------------
			
			// 2. 실행할 sql문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
			
			// 2-1. insert연습
//			System.out.println("insert 작업 시작...");
//			System.out.print("Lprod_id 입력 : ");
//			int lprodId = Integer.parseInt(sc.nextLine());
//			
//			System.out.println("Lprod_gu 입력 : ");
//			String lprodGu = sc.nextLine();
//			
//			System.out.println("Lprod_nm 입력 : ");
//			String lprodNm = sc.nextLine();
//			
//			// 1) insert 할 데이터를 VO 객체에 담는다.
//			LprodVO lprodVo = new LprodVO();
//			
//			lprodVo.setLprod_id(lprodId);
//			lprodVo.setLprod_gu(lprodGu);
//			lprodVo.setLprod_nm(lprodNm);
//			
//			// 2) sqlMapClient객체의 객체변수를 이용하여 처리할 쿼리문을 호출하여 실행한다.
//			// 형식) smc.insert("실행할 쿼리문이있는 문서의 namespace.실행할쿼리문의 id속성값", 파라미터 클래스);
//			// 		반환값 : insert성공 : null, insert실패 : 오류객체
//			Object obj = smc.insert("lprod.insertLprod", lprodVo);
//			if(obj == null){
//				System.out.println("insert작업 성공~~");
//			} else {
//				System.out.println("insert작업 실패~~");
//			}
			
			// 2-2. update 작업
//			System.out.println("update 작업 시작");
//			
//			System.out.print("수정할 Lprod_gu 입력 :");
//			String lprodGu = sc.nextLine();
//			lprodGu = (lprodGu + "    ").substring(0,4);
//			
//			System.out.print("수정할 Lprod_id 입력 :");
//			int lprodId = Integer.parseInt(sc.nextLine());
//			
//			System.out.print("수정할 Lprod_nm 입력 :");
//			String lprodNm = sc.nextLine();
//			
//			// 1) update 할 데이터를 VO 객체에 담는다.
//			LprodVO lprodVo = new LprodVO();
//			
//			lprodVo.setLprod_id(lprodId);
//			lprodVo.setLprod_gu(lprodGu);
//			lprodVo.setLprod_nm(lprodNm);
//			
//			// 2) smc.update("namespace값.id속성값", 파라미터 클래스);
//			// 		반환값 : 성공한 레코드 수
//			int cnt = smc.update("lprod.updateLprod", lprodVo);
//			if(cnt > 0){
//				System.out.println("update 작업 성공~~");
//			} else {
//				System.out.println("update 작업 실패~~");
//			}
			
			// 3. delete 작업
//			System.out.println("delete 작업 시작");
//			System.out.print("삭제할 Lprod_gu 입력 :");
//			String lprodGu = sc.nextLine();
//			lprodGu = (lprodGu + "    ").substring(0,4);
//			
//			// 형식) smc.delete("namespace값.id값", 파라미터클래스);
//			//		반호나값 : 작업에 성공한 레코드 수
//			int cnt = smc.delete("lprod.deleteLprod",lprodGu);
//			if(cnt > 0){
//				System.out.println("delete 작업 성공~~");
//			} else {
//				System.out.println("delete 작업 실패~~");
//			}
			
			// 4. select 작업
			
			// 1) select한 결과가 여러개의 레코드일 경우
//			System.out.println("select작업 시작 (결과가 여러개일 경우...)");
//			
//			// select의 응답 결과가 여러개일 경우에는 queryForList()메소드를 사용하는데
//			// 이 메소드는 여러개의 레코드 각각을 VO에 담은 후 이 VO데이터를 List에 추가해 주는 작업을 
//			// 자동으로 수행한다.
//			// 형식) smc.queryForList("namespace값.id속성값", 파라미터 클래스)
//			// 		반환값 : VO객체가 저장된 List객체
//			
//			
//			List<LprodVO> lprodList = smc.queryForList("lprod.getAllLprod"); // 전송할 파라미터 클래스가 없으면 생략한다.
//			
//			for(LprodVO lpvo : lprodList){
//				System.out.println("ID : " + lpvo.getLprod_id());
//				System.out.println("GU : " + lpvo.getLprod_gu());
//				System.out.println("NM : " + lpvo.getLprod_nm());
//				System.out.println("---------------------------");
//			}
			
			// 2) select한 결과가 한개의 레코드 일 경우
			System.out.println("select작업 시작 (결과가 1개 일 경우...)");
			
			System.out.print("검색할 Lprod_gu 입력 : ");
			String lprod_gu = sc.nextLine();
			
			// select의 처리 결과가 1개가 확실할 경우에는 queryForObject() 메소드를 사용한다.
			// 형식) smc.queryForObject("namespace값.id속성값", 파라미터클래스)
//					반환값 : select한 결과가 저장된 객체(resultClass에 지정한 객체)
			LprodVO lpvo = (LprodVO)smc.queryForObject("lprod.getLprod", lprod_gu);
			if(lpvo == null){
				System.out.println("검색한 데이터가 하나도 없습니다.");
			} else {
				System.out.println("ID : " + lpvo.getLprod_id());
				System.out.println("GU : " + lpvo.getLprod_gu());
				System.out.println("NM : " + lpvo.getLprod_nm());
				System.out.println("---------------------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}









