package kr.co.jinibooks.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.jinibooks.dao.MypageDAO;
import kr.co.jinibooks.domain.BookDomain;

public class MypageService {

	public List<BookDomain> searchPayBookList_5(String id){
		List<BookDomain> list = null;
		
		MypageDAO mDAO = MypageDAO.getInstance();
		try {
			list = mDAO.selectpayBookList_5(id);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		return list;
	}//searchPayBookList_5
	
	public List<BookDomain> searchPayBookList_All(String id){
		List<BookDomain> list = null;
		
		MypageDAO mDAO = MypageDAO.getInstance();
		try {
			list = mDAO.selectpayBookList_All(id);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		return list;
	}//selectpayBookList_All
	
}
