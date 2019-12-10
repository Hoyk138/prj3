package kr.co.jinibooks.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.jinibooks.service.MemberService;
import kr.co.jinibooks.vo.JoinVO;
import kr.co.jinibooks.vo.LoginVO;

@SessionAttributes("user_id")
@Controller
@Component
public class MemberController {

	@Autowired(required = false)
	private MemberService ms;
	
	@RequestMapping(value="member/user_join.do",method=GET)
	public String userJoin(Model model) {
		
		return "member/userJoin";
	}//termsOfUse
	
	@RequestMapping(value="member/id_chk.do",method=POST)
	@ResponseBody
	public String idChk(String inputID) {
		//System.out.println(inputID);
		
		//���񽺸� ����Ͽ� ����ó�� ����� �޴´�
		JSONObject json = ms.searchIDOverlap(inputID);
		//System.out.println(json);
		
		return json.toJSONString();
	}//idChk
	
	@RequestMapping(value="member/email_chk.do",method=POST)
	@ResponseBody
	public String emailChk(String inputEmail) {
		//System.out.println(inputEmail);
		
		//���񽺸� ����Ͽ� ����ó�� ����� �޴´�
		JSONObject json = ms.searchEmailOverlap(inputEmail);
		//System.out.println(json);
		
		return json.toJSONString();
	}//idChk
	
	@RequestMapping(value="member/terms_of_use.do",method=GET)
	public String termsOfUse(Model model) {
		
		return "member/terms_of_use";
	}//termsOfUse

	@RequestMapping(value="member/privacy.do",method=GET)
	public String privacy(Model model) {
		
		return "member/privacy";
	}//privacy
	
	@RequestMapping(value="member/join_process.do",method=POST)
	@ResponseBody
	public String joinProcess(JoinVO jVO,  Model model) {
		
		System.out.println(jVO);
		
		JSONObject json = ms.addJoin(jVO);
		
		return json.toJSONString();
	}//joinProcess

	@RequestMapping(value="member/join_success.do",method=GET)
	public void joinSuccess() {
		
	}//joinSuccess

	@RequestMapping(value="member/login.do",method=GET)
	public String login(Model model) {
		
		return "member/login";
	}//login
	
	@RequestMapping(value="member/login_process.do",method=POST)
	@ResponseBody
	public String loginProcess(LoginVO lVO, Model model) {
		
		//System.out.println(lVO);
		
		JSONObject json = ms.searchIDPW(lVO);
		
		//id�� pw�� ��ȿ�ϸ� session�� id�� �־� �ݴϴ�.
		if((boolean)json.get("result_flag")) {
			model.addAttribute("user_id", lVO.getInputID());
		}//end if
		
		return json.toJSONString();
	}//loginProcess
	
	@RequestMapping(value="member/logout_process.do",method=POST)
	@ResponseBody
	public String loginoutProcess(HttpServletRequest request, SessionStatus ss) {
		
		String header = request.getHeader("REFERER");
		
//		System.out.println(header);
		
		int idx = header.indexOf("team1_user_prj3");
//		System.out.println(idx);
		
		int idx2 = idx +"team1_user_prj3".length();
//		System.out.println(header.substring(idx2));
		
		JSONObject json = new JSONObject();
		boolean flag = false;
		ss.setComplete();
		json.put("flag", !flag);
		json.put("target", header.substring(idx2));
		
		//return "redirect:"+header.substring(idx2);
		return json.toJSONString();
	}//loginoutProcess

}//class
