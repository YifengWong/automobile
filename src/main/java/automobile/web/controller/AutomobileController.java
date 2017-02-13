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
import automobile.business.services.ClassService;
import automobile.business.services.DiscussService;
import automobile.business.services.FavorableService;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.business.services.WantedService;
import automobile.util.ResultObject;

@Controller
public class AutomobileController {
	
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	
	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	private FavorableService favorableService = ctx.getBean(FavorableService.class);
	private WantedService wantedService = ctx.getBean(WantedService.class);
	
	

	
	@RequestMapping(value = "/newClass", method = RequestMethod.POST)
	public void newClass(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bigClassName = request.getParameter("bigClassName");
		String smallClassName = request.getParameter("smallClassName");
		// TODO
	}
	

	
}
