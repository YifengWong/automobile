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

	@RequestMapping(value = "/testPost", method = RequestMethod.GET)
	public String testPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "testPost";
	}
	
	@RequestMapping(value = "/postPage", method = RequestMethod.GET)
	public String postPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "postPage";
	}
	
}
