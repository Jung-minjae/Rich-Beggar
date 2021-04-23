package Ju.User;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;



	public UserVO insertlogin(UserVO param) {
		return sqlSession.selectOne("insertlogin", param);
	}

	



}
