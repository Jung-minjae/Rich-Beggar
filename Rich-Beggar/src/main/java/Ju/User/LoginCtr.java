package Ju.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import Ju.Join.JoinSvc;
import Ju.Join.JoinVO;

@Controller
public class LoginCtr {
	private static final Integer cookieExpire = 60 * 60 * 24 * 30; // 1 month

	@Autowired
	private UserSvc UserSvc;

	@Autowired
	private JoinSvc joinsvc;

	/**
	 * 로그인화면.
	 * 
	 * @throws UnsupportedEncodingException
	 */

	@RequestMapping(value = "login")
	public String memberLogin(HttpServletRequest request, ModelMap modelMap) throws UnsupportedEncodingException {

		System.out.println("여기1번");
		String clientId = "cJ9djaESYG0JjzZmnDbY";// 애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8080/springTest/callback", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state; // 자신의 클라이언트 아이디랑 콜백주소 State를 합쳐서 api 주소 만들고
		HttpSession session = request.getSession(); // 세션 생성
		session.setAttribute("state", state);
		modelMap.addAttribute("apiURL", apiURL); // api 주소 jsp로 보내기
		return "User/login";
	}

	@RequestMapping(value = "callback")
	public String navercallback(HttpServletRequest request, ModelMap modelMap) throws UnsupportedEncodingException {
		System.out.println("콜백 여까지옴");
		String clientId = "cJ9djaESYG0JjzZmnDbY";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "jFxiBZSj5Y";// 애플리케이션 클라이언트 시크릿값";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = URLEncoder.encode("http://localhost:8080/MVC_2_/callback", "UTF-8");
//ex)) http://3.36.176.60:3306/Myproject2/logininfo
		String apiURL;

		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = ""; // 회원정보 받기 위해서는 access_token값을 받을 필요가 있음
		String refresh_token = "";
		System.out.println("apiURL=" + apiURL);
		int check = 0;

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser(); //
				Object obj = parsing.parse(res.toString()); //
				JSONObject jsonObj = (JSONObject) obj; // 제이슨 오브젝트에서 access_token 꺼내기 위한 작업(어떻게 했었는지 잘 기억이 안남;)

				access_token = (String) jsonObj.get("access_token"); // access_token값을 받는다
				refresh_token = (String) jsonObj.get("refresh_token"); // refresh 이거는 토큰 갱신할때 필수라고 함

				System.out.println("acc_to: " + access_token);

				// 회원정보를 받기위해서 Logininfo 라고 컨트롤러를 하나 생성해서
				info(request, access_token); // 토큰값을 두겟으로 보냄 두겟 생성하면 req, resp 자동으로 받아있는데 거기에 뒤에 access토큰을 추가로 보냄
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:index";

	}

	public void info(HttpServletRequest request, String access_token) {

		JoinVO jv = null;

		String reqURL = "https://openapi.naver.com/v1/nid/me";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();

			String nickname = "";
			String pass = "*****";
			String email = "";
			String id = "";
			String gender = "";
			String mobile = "";

			if (responseCode == 200) {
				System.out.println(res.toString());
				JSONParser parsing = new JSONParser();
				Object obj = parsing.parse(res.toString());

				JSONObject jsonObj = (JSONObject) obj;

				JSONObject response = (JSONObject) obj;
				response = (JSONObject) jsonObj.get("response");

				id = (String) response.get("id");

				nickname = (String) response.get("name");
				email = (String) response.get("email");
				gender = (String) response.get("gender");
				mobile = (String) response.get("mobile");
				System.out.println(response);

				System.out.println("id : " + id);
				System.out.println("이름 : " + nickname);
				System.out.println("메일 : " + email);
				System.out.println("성별 : " + gender);
				System.out.println("휴대전화:" + mobile);
				// 이후 이값들을 DB에 넣든 다른곳에 옮기기!

				int check = joinsvc.idcheck(id);

				System.out.println("11111111");

				if (check == 0) {
					jv = new JoinVO(id, pass, nickname, mobile, gender, email);
					joinsvc.joininsert(jv);
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("userID", id);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 로그인 처리.
	 */

	@RequestMapping(value = "insertlogin")
	public String memberLoginChk(HttpServletRequest request, HttpServletResponse response, UserVO loginInfo,
			ModelMap modelMap) {
		UserVO mdo = UserSvc.insertlogin(loginInfo);

		if (mdo == null) {
			modelMap.addAttribute("login_x","로그인에 실패하였습니다");
			
			return "common/login_x";
		}
		else {

		HttpSession session = request.getSession();

		session.setAttribute("userID", mdo.getUserID());
		session.setAttribute("userPass", mdo.getUserPass());
	
		modelMap.addAttribute("login_o",mdo.getUserName()+"님 로그인에 성공하였습니다");
		
		return "common/login_o";
		}
	}

	/**
	 * 로그아웃.
	 */
	@RequestMapping(value = "logout")
	public String memberLogout(HttpServletRequest request, ModelMap modelMap) {
		HttpSession session = request.getSession();

		session.invalidate();

		return "redirect:/index";
	}

	/**
	 * 사용자가 관리자페이지에 접근하면 오류 출력. //
	 */
//	@RequestMapping(value = "noAuthMessage")
//	public String noAuthMessage(HttpServletRequest request) {
//		return "common/noAuth";
//	}

	/*
	 * -------------------------------------------------------------------------
	 */

}