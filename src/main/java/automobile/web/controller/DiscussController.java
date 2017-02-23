package automobile.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.DiscussToAutoMaker;
import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.GarageDetail;
import automobile.business.services.DiscussService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class DiscussController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	
	@RequestMapping(value = "/getDiscussesToAutoMaker", method = RequestMethod.POST)
	public void getDiscussesToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String autoMakerName = request.getParameter("username");
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(autoMakerName);
		
		if (autoMakerDetail == null) {
			response.getWriter().write(new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_USERNAME, null)
					.getJsonString());
			return;
		}
		List<DiscussToAutoMaker> discusses = discussService.findAllDiscussToAutoMaker(autoMakerDetail);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.DISCUSS_ALL, discusses)
				.getJsonString());
	}
	
	@RequestMapping(value = "/getDiscussesToGarage", method = RequestMethod.POST)
	public void getDiscussesToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String garageName = request.getParameter("username");
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(garageName);
		
		if (garageDetail == null) {
			response.getWriter().write(new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_USERNAME, null)
					.getJsonString());
			return;
		}
		List<DiscussToGarage> discusses = discussService.findAllDiscussToGarage(garageDetail);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.DISCUSS_ALL, discusses)
				.getJsonString());
		return;
	}

	
	@RequestMapping(value = "/sendDiscussToGarage", method = RequestMethod.POST)
	public void sendDiscussToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String autoMakerName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String garageName = request.getParameter("receiverName");
		String nowTime = new Date().toString();
		Integer stars = Integer.valueOf(request.getParameter("stars"));
		String content = request.getParameter("content");
		
		ResultObject userRe = userDetailService.checkAutoMakerDetail(autoMakerName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		AutoMakerDetail autoMakerDetail = (AutoMakerDetail) userRe.getObject();
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(garageName);
		
		DiscussToGarage discuss = new DiscussToGarage(autoMakerDetail, garageDetail, nowTime, stars, content);
		discussService.createDiscussToGarage(discuss);
				
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.DISCUSS_SUCC, null)
				.getJsonString());
		
	}
	
	@RequestMapping(value = "/sendDiscussToAutoMaker", method = RequestMethod.POST)
	public void sendDiscussToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String garageName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String autoMakerName = request.getParameter("receiverName");
		String nowTime = new Date().toString();
		Integer stars = Integer.valueOf(request.getParameter("stars"));
		String content = request.getParameter("content");
		
		ResultObject userRe = userDetailService.checkGarageDetail(garageName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		GarageDetail garageDetail = (GarageDetail) userRe.getObject();
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(autoMakerName);

		DiscussToAutoMaker discuss = new DiscussToAutoMaker(autoMakerDetail, garageDetail, nowTime, stars, content);
		discussService.createDiscussToAutoMaker(discuss);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.DISCUSS_SUCC, null)
				.getJsonString());
	}
}
