package automobile.web.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.GarageDetail;
import automobile.business.entities.SmallClass;
import automobile.business.entities.Wanted;
import automobile.business.services.ClassService;
import automobile.business.services.UserDetailService;
import automobile.business.services.WantedService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class WantedController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	
	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private WantedService wantedService = ctx.getBean(WantedService.class);
	
	@RequestMapping(value = "/getAllWanted", method = RequestMethod.GET)
	public void getAllWanted(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.WANTED_ALL, wantedService.findAllWanted())
				.getJsonString());
	}
	
	@RequestMapping(value = "/createWanted", method = RequestMethod.POST)
	public void createWanted(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		String content = request.getParameter("content");
		String[] classIds = request.getParameter("classIds").split(",");// ID
		
		ResultObject userRe = userDetailService.checkGarageDetail(senderName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		GarageDetail garageDetail = (GarageDetail) userRe.getObject();
		Wanted wanted = new Wanted(garageDetail, dateFrom, dateTo, content);
		
		Set<SmallClass> smallClasses = new HashSet<SmallClass>();
		for (String s : classIds) {
			smallClasses.add(classService.findSmallClasById(s));
		}
		
		wantedService.createWanted(wanted, smallClasses);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.WANTED_CREATE_SUCC, null)
				.getJsonString());
		
	}
}
