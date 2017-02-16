package automobile.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.AbstractUserDetail;
import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.DiscussToAutoMaker;
import automobile.business.entities.DiscussToGarage;
import automobile.business.entities.GarageDetail;
import automobile.business.services.DiscussService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;

public class DiscussController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	
	@RequestMapping(value = "/getDiscusses", method = RequestMethod.POST)
	public void getDiscusses(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String usertype = request.getParameter("usertype");

		AbstractUserDetail user = null;
		
		if (usertype.equals("autoMaker")) {
			user = userDetailService.findAutoMakerDetailByUserName(username);
		} else if (usertype.equals("garage")) {
			user = userDetailService.findGarageDetailByUserName(username);
		}
		
		if (user == null) {
			response.getWriter().write(new ResultObject(ResultObject.FAIL, "no user", null).getJsonString());
			return;
		}

		if (user instanceof AutoMakerDetail) {
			List<DiscussToAutoMaker> discusses = discussService.findAllDiscussToAutoMaker((AutoMakerDetail) user);
			response.getWriter().write(new ResultObject(ResultObject.SUCC, "discusses", discusses).getJsonString());
			return;
		} else if (user instanceof GarageDetail) {
			List<DiscussToGarage> discusses = discussService.findAllDiscussToGarage((GarageDetail) user);
			response.getWriter().write(new ResultObject(ResultObject.SUCC, "discusses", discusses).getJsonString());
			return;
		}
		
	}
	
	@RequestMapping(value = "/sendDiscussToGarage", method = RequestMethod.POST)
	public void sendMsgToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String senderName = request.getParameter("senderName");
		String receiverName = request.getParameter("receiverName");
		String nowTime = new Date().toString();
		Integer stars = Integer.valueOf(request.getParameter("stars"));
		String content = request.getParameter("content");
		
		
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(senderName);
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(receiverName);
		
		DiscussToGarage discuss = new DiscussToGarage(autoMakerDetail, garageDetail, nowTime, stars, content);
		discussService.createDiscussToGarage(discuss);
				
		response.getWriter().write(new ResultObject(ResultObject.SUCC, "OK", null).getJsonString());
		
	}
	
	@RequestMapping(value = "/sendMsgToAutoMaker", method = RequestMethod.POST)
	public void sendMsgToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String senderName = request.getParameter("senderName");
		String receiverName = request.getParameter("receiverName");
		String nowTime = new Date().toString();
		Integer stars = Integer.valueOf(request.getParameter("stars"));
		String content = request.getParameter("content");
		
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(receiverName);
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(senderName);

		DiscussToAutoMaker discuss = new DiscussToAutoMaker(autoMakerDetail, garageDetail, nowTime, stars, content);
		discussService.createDiscussToAutoMaker(discuss);
		
		response.getWriter().write(new ResultObject(ResultObject.SUCC, "OK", null).getJsonString());
	}
}
