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

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.AutosSmallClassesMiddle;
import automobile.business.entities.BigClass;
import automobile.business.entities.SmallClass;
import automobile.business.entities.Test;
import automobile.business.services.AutoMakerDetailService;
import automobile.business.services.AutosSmallClassesMiddleService;
import automobile.business.services.BigClassService;
import automobile.business.services.SmallClassService;
import automobile.util.converter.JsonStringConverter;

@Controller
public class AutomobileController {
	
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();
	private BigClassService bigClassService = ctx.getBean(BigClassService.class);
	private SmallClassService smallClassService = ctx.getBean(SmallClassService.class);
	private AutoMakerDetailService autoMakerDetailService = ctx.getBean(AutoMakerDetailService.class); 
	private AutosSmallClassesMiddleService autosSmallClassesMiddleService = ctx.getBean(AutosSmallClassesMiddleService.class);
	
	@RequestMapping("/testJson")
	public void testJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Test t = new Test("1", "Name");
		try {
			response.getWriter().write(JsonStringConverter.getJSONString("test", t));
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
		
		
		response.getWriter().write(JsonStringConverter.getJSONString("autoMakerDetail", list.get(0).getAutoMakerDetail()));
	}
}
