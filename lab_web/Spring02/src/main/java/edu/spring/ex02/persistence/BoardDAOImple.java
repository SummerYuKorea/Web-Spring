package edu.spring.ex02.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

//객체를 한번만 생성하도록 스프링에게 맡긴다 싱글턴 구성하는 대신!
@Repository   //Componenent로 설정  : Repository 저장소!  //영속 계층(Persistent layer)의 DB 관련 기능을 담당하는 Spring component bean으로 등록함
						//스프링 프레임워크가 bean으로 생성하기 위해서는 root-context.xml에서 bean으로 등록해야함 <context:component-scan...>
public class BoardDAOImple implements BoardDAO {
	
	//component가 되기 위한 요소
	//1. <context:component-scan base-package="" /> 에 등록한 패키지 안에 이클래스가 있어야함(하위폴더안에 있어도됨) 
				//servlet-context는 주로 controller(이건 persistence)관련을 다루는 xml이라서 root-context에 새로 적어줬어. 
	//2. 해당 클래스에 annotaion을 등록

	
	private static final String NAMESPACE="edu.spring.ex02.BoardMapper";
	private static final Logger logger=LoggerFactory.getLogger(BoardDAOImple.class);
	
	//DAO에서는 (스프링프레임워크가 만든(root-context.xml에서설정한)) MyBatis의 SqlSession을 사용할것
	@Autowired //Dependency Injection
	private SqlSession sqlSession;
	
	
	@Override
	public List<BoardVO> select() {
		logger.info("select() 호출: select_all");
		return sqlSession.selectList(NAMESPACE+".select_all");
	}


	@Override
	public BoardVO select(int bn) {
		logger.info("select() 호출: select_by_bno");
		BoardVO vo=new BoardVO(bn, null,null,null,null);
		return sqlSession.selectOne(NAMESPACE+".select_by_bno",vo);  //이 두번째 매개변수 bn가 자동으로 sql문장의 #{bno}자리에 들어감(일부러이름다르게해봣음잘들어감)
					// selectOne이라는 메소드가 받은거에서 getInt(1)뭐 해가지고 BoardVO에 넣어서 이케하는거 다 해주는 거지
	}


	@Override
	public int insert(BoardVO vo) {
		logger.info("insert()호출 ");
		return sqlSession.insert(NAMESPACE+".insert",vo);  //vo의 프로퍼티 이름을 보고 spEL (#{})에서 getter메소드 호출해서 가져와서 넣음
																									//#{title} 에 들어가는 값이 vo.getTitle() 이 된다는 얘기
		
	}


	@Override
	public List<BoardVO> select(String userid) {
		logger.info("select()호출 : select_by_userid");
		return sqlSession.selectList(NAMESPACE+".select_by_userid",userid+"%");
	}


	@Override
	public int update(BoardVO vo) {
		logger.info("update() 호출: bno(수정할 글 번호)="+vo.getBno());
		return sqlSession.update(NAMESPACE+".update",vo);
	}


	@Override
	public int delete(int bno) {
		logger.info("delete()호출: bno= "+bno);
		return sqlSession.delete(NAMESPACE+".delete",bno);
	}


	@Override
	public List<BoardVO> select1(String keyword) {
		logger.info("select() 호출: select_by_content_or_title");
		
		//여러개의 값을 넘겨야 할 때는 Map(인터페이스)을 이용 (key값을 spEL에서 사용)
//		Map<String, String> map =new HashMap<String, String>();
//		map.put("title", "%"+gum+"%");
//		map.put("content", "%"+gum+"%");
		//이걸로 넘기면 spEL에서 map.get("title") 같은 식으로 알아서 메소드 부름! 똑띠
		return sqlSession.selectList(NAMESPACE+".select_by_title_or_content", "%"+keyword+"%");
	}
	
	
	@Override
	public int getTotalNumsOfRecords() {
		return sqlSession.selectOne(NAMESPACE+".total_count");
	}
	
	@Override
	public List<BoardVO> select(PageCriteria criteria){//(int start, int end) {
//		Map<String, Integer> args=new HashMap<>();
//		args.put("start", start);
//		args.put("end", end);
		return sqlSession.selectList(NAMESPACE+".paging", criteria);
		//PageCriteria의 start, end 멤버변수가 없더라도 getter만들어놨으므로 spEL이 잘 찾아간다
	}
	

}
