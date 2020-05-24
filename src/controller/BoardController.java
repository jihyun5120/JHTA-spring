package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bean.BoardMybatisDao;
import bean.Page;
import mybatis.AttVo;
import mybatis.BoardVo;
import mybatis.FileUpload;

@Controller
public class BoardController {
	BoardMybatisDao dao;
	
	public BoardController(BoardMybatisDao dao) {
		this.dao = dao;
	}	
	
	@RequestMapping(value = "/select.brd", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView select(HttpServletRequest req) { //매개변수로 request나 response를 쓰면 스프링 특성상 자동으로 정보들이 주입된.
		ModelAndView mv = new ModelAndView();
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		if (req.getParameter("nowPage") == null) {
			p.setNowPage(1);
		} else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		
		List<BoardVo> list = dao.select(p);
		
		mv.addObject("p", p);
		mv.addObject("list", list); //request영역을 타고 데이터가 들어감.
		mv.setViewName("select"); //select라고하는 페이지로 넘기겠다!
		
		return mv;
	}
	
	@RequestMapping(value = "/insert.brd", method = {RequestMethod.POST})
	public ModelAndView insert() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("insert");
		return mv;
	}
	
	@RequestMapping(value = "/insertR.brd", method = {RequestMethod.POST})
	public ModelAndView insertR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		String msg = "";
		Page p = new Page();
		
		//FileUpload
		FileUpload fu = new FileUpload(req, resp);
		HttpServletRequest newReq = fu.uploading();
		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
		List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
		
		msg = dao.insert(vo, attList);
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/view.brd", method = {RequestMethod.POST})
	public ModelAndView view(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		List<AttVo> attList = null;
		int serial = Integer.parseInt(req.getParameter("serial"));
		
		BoardVo vo = dao.view(serial, 'v');
		attList = dao.getAttList(serial);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		if (req.getParameter("nowPage") == null) {
			p.setNowPage(1);
		}else {
			p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		}
		
		mv.addObject("p", p);
		mv.addObject("attList", attList);
		mv.addObject("vo", vo); //req.setAttribute("vo", vo)와 같음.
		mv.setViewName("view");
		return mv;
	}
	
	@RequestMapping(value = "/modify.brd", method = {RequestMethod.POST})
	public ModelAndView modify(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		int serial = Integer.parseInt(req.getParameter("serial"));
		
		BoardVo vo = dao.view(serial, 'm');
		List<AttVo> attList = dao.getAttList(serial);
		
		Page p = new Page();
		p.setFindStr(req.getParameter("findStr"));
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));			
		
		mv.addObject("vo", vo);
		mv.addObject("attList", attList);
		mv.addObject("p", p);
		mv.setViewName("modify");
		return mv;
	}
	
	@RequestMapping(value = "/modifyR.brd", method = {RequestMethod.POST})
	public ModelAndView modifyR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		FileUpload fu = new FileUpload(req, resp);
		HttpServletRequest newReq = fu.uploading();
		
		BoardVo vo = (BoardVo)newReq.getAttribute("vo");
		List<AttVo> attList = (List<AttVo>)newReq.getAttribute("attList");
		List<AttVo> delList = (List<AttVo>)newReq.getAttribute("delList");
		String msg = dao.modify(vo, attList, delList);
		
		mv.addObject("p", newReq.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/deleteR.brd", method = {RequestMethod.POST})
	public ModelAndView deleteR(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = new BoardVo();
		int serial = Integer.parseInt(req.getParameter("serial"));
		String pwd = req.getParameter("pwd");
		Page p = new Page();
		p.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
		p.setFindStr(req.getParameter("findStr"));
		
		vo.setSerial(serial);
		vo.setPwd(pwd);
		String msg = dao.delete(vo);
		
		
		mv.addObject("p", p);
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(value = "/repl.brd", method = {RequestMethod.POST})
	public ModelAndView repl() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("repl");
		return mv;
	}
	
	@RequestMapping(value = "/replR.brd", method = {RequestMethod.POST})
	public ModelAndView replR(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		FileUpload fu = new FileUpload(req, resp);
		fu.uploading();
		BoardVo vo = (BoardVo)req.getAttribute("vo");
		List<AttVo> attList = (List<AttVo>)req.getAttribute("attList");
		String msg = dao.repl(vo, attList);
		
		mv.addObject("p", req.getAttribute("p"));
		mv.addObject("msg", msg);
		mv.setViewName("result");
		return mv;
	}
	
}
