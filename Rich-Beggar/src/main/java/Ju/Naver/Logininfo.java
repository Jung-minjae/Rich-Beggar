package Ju.Naver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import Ju.Join.JoinSvc;
import Ju.Join.JoinVO;
import Ju.User.UserVO;


public class Logininfo {

	private JoinSvc joinsvc;
	
	// 여기서 날려준 access값을 String으로 받아줌
	
}