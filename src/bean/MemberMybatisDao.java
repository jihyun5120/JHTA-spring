package bean;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.AttVo;
import mybatis.Factory;
import mybatis.FileUpload;
import mybatis.MemberFileUpload;
import mybatis.MemberPhoto;
import mybatis.MemberVo;

public class MemberMybatisDao {
	SqlSession sqlSession;
	
	public MemberMybatisDao() {
		sqlSession = Factory.getFactory().openSession();
	}
	
	public Boolean login(MemberVo vo) {
		Boolean loginResult = false;
		try {
			loginResult = sqlSession.selectOne("member.login", vo);
		} catch(Exception e) {
			e.getMessage();
		} finally {
			return loginResult;			
		}
	}
	
	public List<MemberVo> select(Page p){
		List<MemberVo> list = null;
		try {
			int totList = sqlSession.selectOne("member.count", p);
			p.setTotListSize(totList);
			p.pageCompute();
			list = sqlSession.selectList("member.select", p);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}
	}
	
	public String insert(MemberVo vo, MemberPhoto mp) {
		String msg = "회원이 정상적으로 등록되었습니다.";
		
		try {
			int cnt = sqlSession.insert("member.insert", vo);
			if (cnt < 1) {
				throw new Exception("회원 등록 중 오류발생!!!");
			}
				cnt = sqlSession.insert("member.mp_insert", mp);
				if (cnt < 1) {
					throw new Exception("사진 파일 저장 중 오류 발생!!!");
			}
			sqlSession.commit();
		} catch(Exception e) {
			msg = e.getMessage();
			sqlSession.rollback();
			String delFile = mp.getSysFile();
			delFile(delFile);
		} finally {
			return msg;			
		}
	}
	
	public MemberVo view(String mId) {
		MemberVo vo = null;
		try {
			vo = sqlSession.selectOne("member.view", mId);
		} catch(Exception e) {
			e.getMessage();
		} finally {
			return vo; 			
		}
		
	}
	
	public String modify(MemberVo vo, MemberPhoto mp) {
		String msg = "회원정보가 정상적으로 수정되었습니다.";
		String delFile = null;
		try {
			if (mp.getOriFile() != null) { //수정 전 삭제 될 파일조회해오기.
				delFile = sqlSession.selectOne("member.mp_select", mp.getmId());
				System.out.println(delFile);
			}
			//회원정보 수정
			int cnt = sqlSession.update("member.update", vo);
			if (cnt < 1) {
				throw new Exception("회원정보 수정 중 오류발생!!!");
			}
			//이미지 첨부
			if(mp != null) {
				if (delFile == null) { //회원등록 시 이미지가 첨부X.
					cnt = sqlSession.insert("member.mp_insert2", mp);
					if (cnt < 1) {
						throw new Exception("증명사진 등록 중 오류 발생!!!");
					}
				}else { //회원등록 시 이미지첨부O, 새로운 사진으로 수정하는 경우.
					cnt = sqlSession.update("member.mp_update", mp);
					if (cnt < 1) {
						throw new Exception("증명사진 수정 중 오류 발생!!!");
					}
				}
			}
			if(delFile != null) {
				cnt = sqlSession.delete("member.mp_delete", delFile);
				if (cnt < 1) {
					throw new Exception("증명사진 삭제 중 오류 발생!!!");
				}
			}
			delFile(delFile); //photo파일에서 사진 삭제.
			sqlSession.commit();
		} catch(Exception e) {
			delFile(delFile);
			msg = e.getMessage();
			sqlSession.rollback();
		} finally {
			return msg;
		}
	}
	
	public void delFile(String delFile) {
			File f = new File(MemberFileUpload.upload + delFile);
			if (f.exists()) {
				f.delete();
		}
	}
}
