package kr.co.jinibooks.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jinibooks.domain.QuestionListDomain;
import kr.co.jinibooks.service.QuestionListService;
import kr.co.jinibooks.vo.BoardIndexListVO;
import kr.co.jinibooks.vo.QuestionSearchVO;
import kr.co.jinibooks.vo.QuestionVO;

@Controller
public class Question_Controller {
	
	@RequestMapping(value="question.do",method= {GET,POST})
	public String searchList(QuestionSearchVO sVO, 
			@RequestParam(required = false, defaultValue = "1")String current_page, Model model) {
		//indexList���� �����ϴ� url�� current_page�� ��ȸ�� ���Ǵ� sVO�� currentPage�� �ٸ����� 
		//current_page�� parameter�� �ް� sVO�� set�Ͽ� �ݴϴ�.
		sVO.setCurrentPage(Integer.parseInt(current_page));
		sVO.setId("user1");
		//��2������ ��ü�� �ڽ��� ��������
		//�����ӿ�ũ������ ������ ��ũ�� ����� �ش�.
		//�������� VO�� null���� Ȯ���� �ʿ䰡 ����.
		
		QuestionListService bls = new QuestionListService();
		int totalCount = bls.totalCount(sVO);
		
		
		int pageScale = bls.pageScale();
		int totalPage = bls.totalPage(pageScale, totalCount);
		int startNum = bls.startNum(pageScale, sVO.getCurrentPage());
		int endNum = bls.endNum(pageScale, startNum);
		
		
		//���� ������ ��ȸ�� ���� �� �ְ� VO�� �����մϴ�.
		sVO.setStartNum(startNum);
		sVO.setEndNum(endNum);
		
		List<QuestionListDomain> boardList = bls.searchList(sVO);

		BoardIndexListVO ilVO = new BoardIndexListVO(sVO.getCurrentPage(), totalPage, "question.do");
		String indexList = bls.indexList(ilVO,sVO);
		
		model.addAttribute("boardList", boardList);//�Խù� ����Ʈ
		model.addAttribute("indexList", indexList);//�ε��� ����Ʈ
		
		return "board/user_question";
//		return "day1202/list";
	}//searchList
	
	@RequestMapping(value = "add_form.do", method = {GET,POST})
	public String addEmpForm(@RequestParam(required = false,defaultValue = "i_000000")String
			  num,Model model) {
		  QuestionListService bls=new QuestionListService(); 
		  QuestionListDomain  bld=bls.searchNoticeDetail(num);
		  model.addAttribute("question_detail",bld);
		return  "board/user_question_write";
	}//addEmpForm
	
	
	  @RequestMapping(value = "detail2.do",method = GET) public String
	  noticedetail(@RequestParam(required = false,defaultValue = "i_000000")String
	  num,Model model) {
	 
	  QuestionListService bls=new QuestionListService(); 
	  QuestionListDomain  bld=bls.searchNoticeDetail(num);
	  model.addAttribute("question_detail",bld);
	  return "board/user_question_detail"; }//searchEmpData
	  
	  
	  @RequestMapping(value = "write_process.do", method = POST) public String
	  InsertNoticeProcess(QuestionVO ceiVO, Model model) {
	  
	  System.out.println(ceiVO);
	  //����ó�� Ŭ������ ��üȭ 
	QuestionListService ces=new QuestionListService(); 
	//����ó�� 
	boolean flag=ces.insertnotice(ceiVO); //view�� ������ ����.
	  model.addAttribute("insertFlag", flag);
	  
	  return "board/user_question_success"; }//addEmpProcess
	  

}//class
