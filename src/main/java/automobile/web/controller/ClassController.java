package automobile.web.controller;

import java.util.Set;

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
import automobile.util.config.StaticString;

@Controller
public class ClassController {

	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private ClassService classService = ctx.getBean(ClassService.class);
	
	@RequestMapping("/getClasses")
	public void getClasses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.CLASS_ALL, classService.findAllBigClasses())
				.getJsonString());
	}
	
	@RequestMapping(value = "/createClass", method = RequestMethod.POST)
	public void createClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");

		String bigClassName = request.getParameter("bigClassName");
		String smallClassName = request.getParameter("smallClassName");
		Integer bigClassPriority = Integer.valueOf(request.getParameter("bigClassPriority"));
		Integer smallClassPriority = Integer.valueOf(request.getParameter("smallClassPriority"));
		
		// TODO: admin 使用单独一个数据库表，手动插入数据库
		
		BigClass bigClass = classService.findBigClassByName(bigClassName);
		
		if (bigClass == null) {
			bigClass = new BigClass(bigClassName, bigClassPriority);
//			classService.createBigClass(bigClass);
		}
		
		SmallClass smallClass = new SmallClass(bigClass, smallClassName, smallClassPriority);
		classService.createSmallClass(smallClass);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.CLASS_CREATE, smallClass)
				.getJsonString());
	}
	
	@RequestMapping(value = "/deleteBigClass", method = RequestMethod.POST)
	public void deleteBigClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String bigClassId = request.getParameter("bigClassId");
		BigClass bigClass = classService.findBigClassById(bigClassId);
		Set<SmallClass> mcs = bigClass.getSmallClassesSet();
		if (mcs != null) {
			for (SmallClass sc : bigClass.getSmallClassesSet()) {
				classService.deleteSmallClass(sc);
			}
		}
//		bigClass.setSmallClassesSet(null);
		
//		classService.deleteBigClass(bigClass);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.CLASS_REMOVE_SUCC, null)
				.getJsonString());
		
	}
	
	@RequestMapping(value = "/deleteSmallClass", method = RequestMethod.POST)
	public void deleteSmallClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String smallClassId = request.getParameter("smallClassId");
		SmallClass smallClass = classService.findSmallClasById(smallClassId);
		
		classService.deleteSmallClass(smallClass);
//		smallClass.getBigClass().getSmallClassesSet().remove(smallClass);
//
//		classService.createBigClass(smallClass.getBigClass());
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.CLASS_REMOVE_SUCC, null)
				.getJsonString());
	}
	
}
