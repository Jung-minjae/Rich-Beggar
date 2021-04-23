package Ju.Join;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;

//
//	public List<JoinVO> joinall(){
//		return sqlSession.selectList("joinall");
//	}

	public void joininsert(JoinVO join) {
		sqlSession.insert("joininsert", join);
	}

	public int idcheck(String id) {
		System.out.println("111111111111111111111");
		return sqlSession.selectOne("idcheck", id);
	}






}
