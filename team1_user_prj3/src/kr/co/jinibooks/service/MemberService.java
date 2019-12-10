package kr.co.jinibooks.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.jinibooks.dao.MemberDAO;
import kr.co.jinibooks.vo.JoinVO;
import kr.co.jinibooks.vo.LoginVO;
import kr.co.sist.util.cipher.DataEncrypt;

@Component
public class MemberService {

	@Autowired(required = false)
	private MemberDAO mDAO;
	
	public JSONObject searchIDOverlap(String inputID) {
		JSONObject json = new JSONObject();
		
		boolean result_flag;
		try {
			result_flag = mDAO.selectIDOverlap(inputID);
			
			// 찾아낸 데이터로 JSONObject 생성
			json.put("result_flag", result_flag);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		return json;
	}//searchIDOverlap
	
	public JSONObject searchEmailOverlap(String inputEmail) {
		JSONObject json = new JSONObject();
		
		boolean result_flag;
		try {
			result_flag = mDAO.selectEmailOverlap(inputEmail);
			
			// 찾아낸 데이터로 JSONObject 생성
			json.put("result_flag", result_flag);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		return json;
	}//searchEmailOverlap
	
	public JSONObject addJoin(JoinVO jVO){
		JSONObject json = new JSONObject();
		boolean flag = false;
		
		try {
			//JoinVO의 비밀번호 암호화
			String key ="1111111111111111";
			DataEncrypt de = new DataEncrypt(key);
			
			String encryptPW = de.encryption(jVO.getInputPW());
			jVO.setInputPW(encryptPW);
		
			// JoinVO의 성별 null 값 처리
			if (jVO.getGender() == null) {
				jVO.setGender("-");
				;
			}//end if
		
		    //DAO를 사용하여 
			//쿼리문을 수행하고 결과를 얻는다.
			int cnt = mDAO.insertJoin(jVO);
			if(cnt == 1) {
				flag = true;
			}//end if
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		} catch (GeneralSecurityException gse) {
			gse.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		json.put("joinFlag", flag);
		
		return json;
	}//addCpEmp
	
	public JSONObject searchIDPW(LoginVO lVO) {
		JSONObject json = new JSONObject();
		
		String result_name;
		try {
			//비밀번호 암호화
			String key ="1111111111111111";
			DataEncrypt de = new DataEncrypt(key);
			
			String encryptPW = de.encryption(lVO.getInputPW());
			lVO.setInputPW(encryptPW);

			System.out.println(lVO);
			result_name = mDAO.selectIDPW(lVO);
			//System.out.println(result_name);
			
			// 찾아낸 데이터로 JSONObject 생성
			json.put("result_flag", result_name != null ? true : false);
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		} catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		} catch (GeneralSecurityException gse) {
			gse.printStackTrace();	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}//end catch
		
		return json;
	}//searchIDPW

}
