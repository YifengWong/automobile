package automobile.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AutomobileController {
	
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	@RequestMapping(value = "/testPost", method = RequestMethod.GET)
	public String testPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "testPost";
	}
	
	@RequestMapping(value = "/postPage", method = RequestMethod.GET)
	public String postPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "postPage";
	}
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "adminPage";
	}
	
	@RequestMapping(value = "/testAdmin", method = RequestMethod.GET)
	public String testAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "testAdmin";
	}
	
}
