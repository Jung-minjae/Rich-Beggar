package Ju.index;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Ju.Coin.CoinDTO;
import Ju.Coin.CoinDao;
import Ju.Coin.CoinSub;
import Ju.JusicMain.Jusic_kp_kd_DAO;
import Ju.JusicMain.Jusic_kp_kd_DTO;
import Ju.KD.DetailKP_DTO;
import Ju.KD.JusicDAO_KP;
import Ju.KD.JusicDTO_KP;
import Ju.KD.JusicKP_Detail;
import Ju.KD.JusicSubDTO_KP;
import Ju.KP.DetailCode_sub;
import Ju.KP.Detail_DTO;
import Ju.KP.JusicDAO;
import Ju.KP.JusicDTO;
import Ju.KP.JusicSubDTO;
import Ju.KP.Jusic_Detail;

@Controller
public class indexCtr {

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest req, ModelMap Model) {

		JusicDAO JD = new JusicDAO();
		JusicDTO jd = JD.getUP();

		// 코스피
		JusicDAO_KP KP = new JusicDAO_KP();
		JusicDTO_KP KP_ = KP.getUP();

		// 코스피 코스닥 주가 정보
		Jusic_kp_kd_DAO KP_KD = new Jusic_kp_kd_DAO();
		Jusic_kp_kd_DTO KP_KD_ = KP_KD.getKD_KP();

		// 코스닥 코드 가져오기
		Jusic_Detail code = new Jusic_Detail();
		Detail_DTO code_ = code.getCode();

		// 코스피 코드 가져오기
		JusicKP_Detail code2 = new JusicKP_Detail();
		DetailKP_DTO code2_ = code2.getCode();

		// 코인정보 가져오기
		CoinDao cd = new CoinDao();
		CoinDTO ct = cd.getcoin();

		// 코스피 코드번호
		List<DetailCode_sub> c_list = new ArrayList<DetailCode_sub>();

		DetailCode_sub DS = null;

		for (int i = 0; i < (code_.getList1()).size(); i++) {
			DS = new DetailCode_sub(code_.getList1().get(i));

//			System.out.println("코드번호:" + DS.getCode());

			c_list.add(DS);
		}

		Model.addAttribute("c_list", c_list);

		for (int i = 0; i < jd.getList1().size(); i++) {

		}
		List<JusicSubDTO> list = new ArrayList<JusicSubDTO>();

		JusicSubDTO js = null;

		for (int i = 0; i < (jd.getList1()).size(); i++) {
			String up = jd.getList1().get(i);
			String name = jd.getList2().get(i);
			String price = jd.getList3().get(i);
			String upPrice = jd.getList4().get(i);
			String per = jd.getList5().get(i);
			String code3 = code_.getList1().get(i);

			js = new JusicSubDTO(up, name, price, upPrice, per, code3);
			list.add(js);
		}

		Model.addAttribute("list", list);

		for (int j = 0; j < KP_.getList1().size(); j++) {

		}

		// 코스피 뿌려주는곳 담기
		List<JusicSubDTO_KP> list_1 = new ArrayList<JusicSubDTO_KP>();

		JusicSubDTO_KP jP = null;

		for (int i = 0; i < (KP_.getList1()).size(); i++) {
			String up = KP_.getList1().get(i);
			String name = KP_.getList2().get(i);
			String price = KP_.getList3().get(i);
			String upPrice = KP_.getList4().get(i);
			String per = KP_.getList5().get(i);
			String code_KP = code2_.getList1().get(i);

			jP = new JusicSubDTO_KP(up, name, price, upPrice, per, code_KP);
			list_1.add(jP);
		}
		Model.addAttribute("list_1", list_1);

		List<String> list_0 = new ArrayList<String>();

		for (int i = 0; i < (KP_KD_.getList1()).size(); i++) {
			String seq = KP_KD_.getList1().get(i);
//			System.out.println("코스피:" + seq);
			list_0.add(seq);
		}
		Model.addAttribute("list_0", list_0);

		// 코인정보

		List<CoinSub> Coin_list = new ArrayList<CoinSub>();

		CoinSub cs = null;
		try {
		for (int i = 0; i < ct.getCoinname().size(); i++) {

			String name = ct.getCoinname().get(i);

			String Percent = ct.getChangePercent().get(i);

			String Last = ct.getLast().get(i);
			String kr_name = ct.getKr_name(i);

			cs = new CoinSub(kr_name, name, Last, Percent);
			Coin_list.add(cs);}

		
		}catch(IndexOutOfBoundsException e) {

			System.out.println(e);


		}
		
		req.setAttribute("Coin_list", Coin_list);

		return "main/index";
	}

}