package kr.co.jinibooks.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jinibooks.domain.BookDomain;
import kr.co.jinibooks.service.MypageService;

@Controller
public class MypageController {

	@RequestMapping(value="member/mypage/main.do",method=GET)
	public String main(Model model) {
		MypageService ms = new MypageService();
		List<BookDomain> list = ms.searchPayBookList_5("user1");
		
		model.addAttribute("payBookList_5", list);
		
		return "member/mypage/main";
	}//main
	
	@RequestMapping(value="member/mypage/pay_book.do",method=GET)
	public String payBook(Model model) {
		MypageService ms = new MypageService();
		List<BookDomain> list = ms.searchPayBookList_All("user1");
		
		model.addAttribute("payBookList_All", list);
		
		
		return "member/mypage/payBook";
	}//payBook

	@RequestMapping(value="member/mypage/recommend.do",method=GET)
	public String recommend(Model model) {
		
		
		return "member/mypage/recommend";
	}//recommend

	@RequestMapping(value="member/mypage/pay_history.do",method=GET)
	public String payHistory(Model model) {
		
		
		return "member/mypage/payHistory";
	}//payHistory

	@RequestMapping(value="member/mypage/charge_cash.do",method=GET)
	public String chargeCash(Model model) {
		
		
		return "member/mypage/charge_cash";
	}//chargeCash

	@RequestMapping(value="member/mypage/info.do",method=GET)
	public String info(Model model) {
		
		
		return "member/mypage/info";
	}//info
	
}
