package kr.co.jinibooks.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.jinibooks.vo.JoinVO;
import kr.co.jinibooks.vo.LoginVO;
import kr.co.jinibooks.vo.MemberVO;

@Component
public class MemberDAO {
    
	private static MemberDAO jDAO;
	private static SqlSessionFactory ssf;
	
	private MemberDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();	
	}//CpEmpDAO
	
	public static MemberDAO getInstance() {
		if (jDAO == null) {
			jDAO = new MemberDAO();
		}//end if
		return jDAO;
	}//getInstance
	
	public SqlSessionFactory getSessionFactory() throws IOException {
		if(ssf == null) {
			Reader reader = null;
			try {
				//1. ������ xml�� ��Ʈ������ ����
				reader = Resources.getResourceAsReader("kr/co/jinibooks/dao/mybatis-config.xml");
				//2. SqlSessionFactoryBuilder ����
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3. SqlSessionFactory ���
				ssf = ssfb.build(reader);
			} finally {
				if(reader != null) {reader.close();}//end if
			}//end finally
		}//end if
		return ssf;
	}//getSessionFactory
	
	public boolean selectIDOverlap(String inputID) throws SQLException {
		boolean flag = false;
		
		try {
			//4. MyBatis Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ����ϴ�.
			String id = ss.selectOne("kr.co.jinibooks.dao.member_mapper.selectIDOverlap",inputID);
			if (id != null) {
				flag = true;
			}//end if
			
			ss.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return flag;
	}//selectIDOverlap
	
	public boolean selectEmailOverlap(String inputEmail) throws SQLException {
		boolean flag = false;
		
		try {
			//4. MyBatis Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ����ϴ�.
			String email = ss.selectOne("kr.co.jinibooks.dao.member_mapper.selectEmailOverlap",inputEmail);
			if (email != null) {
				flag = true;
			}//end if
			
			ss.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return flag;
	}//selectEmailOverlap
	
	public int insertJoin(JoinVO mVO) throws SQLException {
		int cnt = 0;
		try {
			//4. MyBatis Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ����ϴ�.
			cnt = ss.insert("kr.co.jinibooks.dao.member_mapper.insertJoin",mVO);
			//transaction ó��
			ss.commit();
			//Handler�� ��� �Ϸ� �ߴٸ� �����մϴ�.
			ss.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return cnt;
	}//insertJoin
	
	public String selectIDPW(LoginVO lVO) throws SQLException {
		String name = null;
		
		try {
			//4. MyBatis Handler ���
			SqlSession ss = getSessionFactory().openSession();
			//5. id�� �־� mapper xml���� �ش� ������ parsing�Ͽ� �����ϰ� ����� ����ϴ�.
			name = ss.selectOne("kr.co.jinibooks.dao.member_mapper.selectIDPW",lVO);
			
			ss.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return name;
	}//selectIDPW
	
}//class
