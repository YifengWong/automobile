package automobile.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.AbstractUserDetail;
import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.BigClass;
import automobile.business.entities.DiscussToAutoMaker;
import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.Favorable;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToAutoMaker;
import automobile.business.entities.MsgToGarage;
import automobile.business.entities.SmallClass;
import automobile.business.entities.Test;
import automobile.business.entities.Wanted;
import automobile.business.services.ClassService;
import automobile.business.services.DiscussService;
import automobile.business.services.FavorableService;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.business.services.WantedService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class TestController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	
	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	private FavorableService favorableService = ctx.getBean(FavorableService.class);
	private WantedService wantedService = ctx.getBean(WantedService.class);
	
	@RequestMapping(value = "/testJson", method = RequestMethod.POST)
	public void testJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(content);
	}
	
	@RequestMapping(value = "/writeDB")
	public void writeDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BigClass big1 = new BigClass("单项件", 2);
		classService.createBigClass(big1);
		
		BigClass big2 = new BigClass("欧美车系", 3);
		classService.createBigClass(big2);
		
		SmallClass small1 = new SmallClass(big1, "水箱", 1);
		SmallClass small2 = new SmallClass(big1, "电池", 1);
		classService.createSmallClass(small1);
		classService.createSmallClass(small2);
		
		Set<SmallClass> set1 = new HashSet<SmallClass>();
		set1.add(small1);
		set1.add(small2);

		AutoMakerDetail auto1 = new AutoMakerDetail("12345678910", "awerqwerqwe", "qipei 1");
		userDetailService.createAutoMakerDetail(auto1, set1);

		GarageDetail gd1 = new GarageDetail("12345645610", "IIAHSFDJK", "garage1");
		userDetailService.createGarageDetail(gd1);
		
		msgService.createMsgToGarage(new MsgToGarage(auto1, gd1, new Date().toString(), "内容 "));
		
		msgService.createMsgToAutoMaker(new MsgToAutoMaker(auto1, gd1, new Date().toString(), "内容"));
		
		discussService.createDiscussToAutoMaker(new DiscussToAutoMaker(auto1, gd1, new Date().toString(), 3, "呢绒"));
		discussService.createDiscussToGarage(new DiscussToGarage(auto1, gd1, new Date().toString(), 3, "呢绒"));
		
		
		favorableService.createFavorable(new Favorable(auto1, new Date().toString(), "16年", "握草"), set1);
		
		wantedService.createWanted(new Wanted(gd1, "12年", "16年", "内容"), set1);
	}
	
	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	public void testPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String bigClassPriority = request.getParameter("bigClassPriority");
		
		BigClass big1 = new BigClass(username, 2);
		
		classService.createBigClass(big1);
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().write(big1.getName());
	}
	
	
	@RequestMapping("/testAbs")
	public void testAbs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		AbstractUserDetail user = null;

		user = userDetailService.findAutoMakerDetailByUserName("12345678910");
		
		if (user == null) {
			response.getWriter().write(new ResultObject(
					StaticString.RESULT_FAIL, "username wrong", null).getJsonString());
		} else {

				response.getWriter().write(new ResultObject(
						StaticString.RESULT_SUCC, "OK", user).getJsonString());
		}
	}
	
}
