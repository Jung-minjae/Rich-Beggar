package Ju.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSvc {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Integer selectBoardCount(PageVO param) { // board row 카운트

		return sqlSession.selectOne("selectBoardCount", param);
	}

	public List<?> selectBoardList(PageVO param) { // board list 출력

		return sqlSession.selectList("selectBoardList", param);
	}

	public List<BoardVO> selectBoardView(int contentID) {

		return sqlSession.selectList("selectBoardView", contentID);
	}

	public List<CommentVO> selectcommnet(String code) {

		return sqlSession.selectList("selectcommnet", code);
	}

	public void selectinsertComment(CommentVO CV) {

		sqlSession.selectList("selectinsertComment", CV);
	}

	public void selectBoardUpdate(BoardVO BV) {
		sqlSession.insert("selectBoardUpdate", BV);
	}

	public void selectBoardWrite(BoardVO bv) {
		
		sqlSession.insert("selectBoardWrite", bv);
	}
	public void selectBoardDelete(int contentID) {
		sqlSession.insert("selectBoardDelete", contentID);
	}
}
