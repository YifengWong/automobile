package automobile.web.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.Favorable;
import automobile.business.entities.SmallClass;
import automobile.business.services.ClassService;
import automobile.business.services.FavorableService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class FavorableController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	
	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private FavorableService favorableService = ctx.getBean(FavorableService.class);
	
	@RequestMapping(value = "/getAllFavorable", method = RequestMethod.GET)
	public void getAllFavorable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.FAVORABLE_ALL, favorableService.findAllFavorable())
				.getJsonString());
	}
	
	@RequestMapping(value = "/createFavorable", method = RequestMethod.POST)
	public void createFavorable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		String content = request.getParameter("content");
		String[] classIds = request.getParameter("classIds").split(",");// ID
		
		ResultObject userRe = userDetailService.checkAutoMakerDetail(senderName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		AutoMakerDetail autoMakerDetail = (AutoMakerDetail) userRe.getObject();
		
		Favorable favorable = new Favorable(autoMakerDetail, dateFrom, dateTo, content);
		
		Set<SmallClass> smallClasses = new HashSet<SmallClass>();
		
		for (String s : classIds) {
			smallClasses.add(classService.findSmallClasById(s));
		}
		
		favorableService.createFavorable(favorable, smallClasses);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.FAVORABLE_CREATE_SUCC, null)
				.getJsonString());
		
	}
}
