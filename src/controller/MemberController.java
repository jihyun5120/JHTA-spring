package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.MemberMybatisDao;
import bean.Page;
import mybatis.MemberFileUpload;
import mybatis.MemberPhoto;
import mybatis.MemberVo;

@Controller
public class MemberController {
	MemberMybatisDao dao;
	
	public MemberController(MemberMybatisDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/login.mm", method = {RequestMethod.POST})
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/loginR.mm", method = {RequestMethod.POST})
	public ModelAndView loginR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String msg = "환영합니다~";
		MemberVo vo = new MemberVo();
		String mId = req.getParameter("mId");
		String pwd = req.getParameter("pwd");
		
		vo.setmId(mId);
		vo.setPwd(pwd);
		boolean loginResult = dao.login(vo);
		if (loginResult) {
			HttpSession session = req.getSession();
			session.setAttribute("session_id", mId);
		} else {
			msg = "아이디 또는 비밀번호를 확인해주세요.";
		}
		
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping(value = "/logout.mm", method = {RequestMethod.POST})
	public ModelAndView logout(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String msg = "다음에 또 봐요~";
		HttpSession session = req.getSession();
		session.removeAttribute("session_id");
		
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping(value = "/FindId.mm", method = {RequestMethod.POST})
	public ModelAndView findId() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("findId");
		return mv;
	}
	
	@RequestMapping(value = "/FindIdR.mm", method = {RequestMethod.POST})
	public ModelAndView findIdR() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/select.mm", method = {RequestMethod.GET, RequestMethod.POST})
	//select.brd가 들어오면 select메소드를 실행시켜라!(get, post타입 모두)
	public ModelAndView select(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		if (req.getParameter("nowPage") == null) {
			p.setNowPage(1);
		} else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		}
		
		List<MemberVo> list = dao.select(p);
		mv.addObject("p", p);
		mv.addObject("list", list);
		mv.setViewName("select");
		return mv;
	}
	
	@RequestMapping(value = "/insert.mm", method = {RequestMethod.POST})
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insert");
		return mv;
	}
	
	@RequestMapping(value = "/insertR.mm", method = {RequestMethod.POST})
	public ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		
		MemberFileUpload mfu = new MemberFileUpload(req, resp);
		HttpServletRequest newReq = mfu.uploading();
		MemberVo vo = (MemberVo)newReq.getAttribute("vo");
		MemberPhoto mp = (MemberPhoto)newReq.getAttribute("mp");
		
		String msg = dao.insert(vo, mp);
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/view.mm", method = {RequestMethod.POST})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String mId = req.getParameter("mId");
		MemberVo vo = dao.view(mId);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		String nowPage = req.getParameter("nowPage");
		if (nowPage == null) {
			p.setNowPage(1);
		} else {
			p.setNowPage(Integer.parseInt(nowPage));
		}
 		
		mv.addObject("vo", vo);
		mv.addObject("p", p);
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(value = "/modify.mm", method = {RequestMethod.POST})
	public ModelAndView modify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String mId = req.getParameter("mId");
		String nowPage = req.getParameter("nowPage");
		
		MemberVo vo = dao.view(mId);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr")); 
		if (nowPage == null) {
			p.setNowPage(1);
		} else {
			p.setNowPage(Integer.parseInt(nowPage));
		}
		
		mv.addObject("vo", vo);
		mv.addObject("p", p);
		mv.setViewName("modify");
		return mv;
	}
	
	@RequestMapping(value = "/modifyR.mm", method = {RequestMethod.POST})
	public ModelAndView modifyR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		MemberFileUpload mfu = new MemberFileUpload(req, resp);
		HttpServletRequest newReq = mfu.uploading();
		
		MemberVo vo = (MemberVo)newReq.getAttribute("vo");
		MemberPhoto mp = (MemberPhoto)newReq.getAttribute("mp");
		String msg = dao.modify(vo, mp);
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/deleteR.mm", method = {RequestMethod.POST})
	public ModelAndView deleteR() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result");
		return mv;
	}
	
}
