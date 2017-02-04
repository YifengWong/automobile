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
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.BigClass;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToGarage;
import automobile.business.entities.SmallClass;
import automobile.business.entities.Test;
import automobile.business.entities.util.JsonManager;
import automobile.business.services.AutoMakerDetailService;
import automobile.business.services.AutosSmallClassesMiddleService;
import automobile.business.services.BigClassService;
import automobile.business.services.GarageDetailService;
import automobile.business.services.MsgToGarageService;
import automobile.business.services.SmallClassService;

@Controller
public class AutomobileController {
	
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();
	private BigClassService bigClassService = ctx.getBean(BigClassService.class);
	private SmallClassService smallClassService = ctx.getBean(SmallClassService.class);
	private AutoMakerDetailService autoMakerDetailService = ctx.getBean(AutoMakerDetailService.class); 
	private AutosSmallClassesMiddleService autosSmallClassesMiddleService = ctx.getBean(AutosSmallClassesMiddleService.class);
	private MsgToGarageService msgToGarageService = ctx.getBean(MsgToGarageService.class);
	private GarageDetailService garageDetailService = ctx.getBean(GarageDetailService.class);
	
	
	@RequestMapping("/testJson")
	public void testJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test t = new Test("1", "Name");
		try {
			response.getWriter().write(JsonManager.getJSONString("test", t));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/writeDB")
	public void writeDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BigClass big1 = new BigClass("danxiang ");
		bigClassService.create(big1);
		
		SmallClass small1 = new SmallClass(big1, "shuixiang");
		SmallClass small2 = new SmallClass(big1, "lihaide");
		smallClassService.create(small1);
		smallClassService.create(small2);
		
		Set<SmallClass> set1 = new HashSet<SmallClass>();
		set1.add(small1);
		set1.add(small2);
	
		AutoMakerDetail auto1 = new AutoMakerDetail("qipei 1");
		autoMakerDetailService.create(auto1);
		
		autosSmallClassesMiddleService.create(new AutosSmallClassesMiddle(small1, auto1));
		autosSmallClassesMiddleService.create(new AutosSmallClassesMiddle(small2, auto1));
		
		List<AutosSmallClassesMiddle> list = autosSmallClassesMiddleService.findBySmallClass(small1);
		
		
		GarageDetail gd1 = new GarageDetail("garage1");
		garageDetailService.create(gd1);
		
		MsgToGarage msg1 = new MsgToGarage(auto1, gd1, "contengmsg");
		msgToGarageService.create(msg1);
		
		
		response.getWriter().write(JsonManager.getJSONString("smallClass", smallClassService.findAll()) + "\n");
		response.getWriter().write(JsonManager.getJSONString("allClasses", bigClassService.findAll()) + "\n");
		response.getWriter().write(JsonManager.getJSONString("allClasses", autoMakerDetailService.findAll()) + "\n");
		response.getWriter().write(JsonManager.getJSONString("detail1", autoMakerDetailService.findById(4)));
	}
}
