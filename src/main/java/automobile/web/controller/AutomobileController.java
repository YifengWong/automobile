package automobile.web.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.BigClass;
import automobile.business.entities.Favorable;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToGarage;
import automobile.business.entities.SmallClass;
import automobile.business.entities.Test;
import automobile.business.entities.util.JsonObject;
import automobile.business.services.ClassService;
import automobile.business.services.DiscussService;
import automobile.business.services.FavorableService;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.business.services.WantedService;

@Controller
public class AutomobileController {
	
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	
	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	private FavorableService favorableService = ctx.getBean(FavorableService.class);
	private WantedService wantedService = ctx.getBean(WantedService.class);
	
	
	@RequestMapping("/testJson")
	public void testJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test t = new Test("1", "Name");

	}
	
	@RequestMapping("/writeDB")
	public void writeDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BigClass big1 = new BigClass("danXiang");
		classService.createBigClass(big1);
		
		SmallClass small1 = new SmallClass(big1, "shuixiang");
		SmallClass small2 = new SmallClass(big1, "lihaide");
		classService.createSmallClass(small1);
		classService.createSmallClass(small2);
		
		Set<SmallClass> set1 = new HashSet<SmallClass>();
		set1.add(small1);
		set1.add(small2);

		AutoMakerDetail auto1 = new AutoMakerDetail("12345678910", "awerqwerqwe", "qipei 1");
		userDetailService.createAutoMakerDetail(auto1, set1);

		
		GarageDetail gd1 = new GarageDetail("12345645610", "IIAHSFDJK", "garage1");
		userDetailService.createGarageDetail(gd1);
		
		MsgToGarage msg1 = new MsgToGarage(auto1, gd1, "contengmsg");
		msgService.createMsgToGarage(msg1);
		
		favorableService.createFavorable(new Favorable(auto1, "12点", "16点", "优惠优惠"), set1);

	}
	
	@RequestMapping("/getClasses")
	public void getClasses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().write(new JsonObject("classes", classService.findAllBigClasses()).getJsonString());
	}
	
	@RequestMapping(value = "/newClass", method = RequestMethod.POST)
	public void newClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bigClassName = request.getParameter("bigClassName");
		String smallClassName = request.getParameter("smallClassName");
		// TODO
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String certCode = request.getParameter("certCode");
		String userType = request.getParameter("userType");
		
		// TODO check certCode
		
		
		
		if (userType.equals("autoMaker")) {
			AutoMakerDetail user = new AutoMakerDetail(id, password, "");
			userDetailService.createAutoMakerDetail(user, null);
		} else if (userType.equals("garage")) {
			GarageDetail user = new GarageDetail(id, password, "");
			userDetailService.createGarageDetail(user);
		} else {
			// TODO return failed
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
	}
	
}
