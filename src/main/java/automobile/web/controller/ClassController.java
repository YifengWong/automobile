package automobile.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;
import automobile.business.services.ClassService;
import automobile.util.ResultObject;
import automobile.util.config.StaticConfig;

@Controller
public class ClassController {

	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private ClassService classService = ctx.getBean(ClassService.class);
	
	@RequestMapping("/getClasses")
	public void getClasses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(new ResultObject(
				StaticConfig.STR_RESULT_SUCC, StaticConfig.MSG_ALL_CLASSES, classService.findAllBigClasses())
				.getJsonString());
	}
	
	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public void createClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		
		String bigClassName = request.getParameter("bigClassName");
		String smallClassName = request.getParameter("smallClassName");
		
		// check admin
		
		BigClass bigClass = classService.findBigClassByName(bigClassName);
		if (bigClass == null) {
			bigClass = new BigClass(bigClassName);
			classService.createBigClass(bigClass);
		}
		
		SmallClass smallClass = new SmallClass(bigClass, smallClassName);
		
		classService.createSmallClass(smallClass);
		
		response.getWriter().write(new ResultObject(
				StaticConfig.STR_RESULT_SUCC, "sm", smallClass)
				.getJsonString());
	}
	
}