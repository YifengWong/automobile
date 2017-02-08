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
	
		AutoMakerDetail auto1 = new AutoMakerDetail("qipei 1");
		userDetailService.createAutoMakerDetail(auto1, set1);

		
		GarageDetail gd1 = new GarageDetail("garage1");
		userDetailService.createGarageDetail(gd1);
		
		MsgToGarage msg1 = new MsgToGarage(auto1, gd1, "contengmsg");
		msgService.createMsgToGarage(msg1);
		
		
		response.getWriter().write(new JsonObject("classes", classService.findAllBigClasses()).getJsonString() + "\n");
	}
}
