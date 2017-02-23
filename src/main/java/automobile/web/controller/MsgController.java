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
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToAutoMaker;
import automobile.business.entities.MsgToGarage;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class MsgController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	@RequestMapping(value = "/getMsgsToAutoMaker", method = RequestMethod.POST)
	public void getMsgsToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ResultObject userRe = userDetailService.checkAutoMakerDetail(username, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		AutoMakerDetail autoMakerDetail = (AutoMakerDetail) userRe.getObject();
		List<MsgToAutoMaker> msgs = msgService.findAllMsgsToAutoMaker(autoMakerDetail);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.MSG_ALL, msgs)
				.getJsonString());
	}
	
	@RequestMapping(value = "/getMsgsToGarage", method = RequestMethod.POST)
	public void getMsgsToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ResultObject userRe = userDetailService.checkGarageDetail(username, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		GarageDetail garageDetail = (GarageDetail) userRe.getObject();
		List<MsgToGarage> msgs = msgService.findAllMsgsToGarage(garageDetail);
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.MSG_ALL, msgs)
				.getJsonString());

	}

	@RequestMapping(value = "/sendMsgToGarage", method = RequestMethod.POST)
	public void sendMsgToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String receiverName = request.getParameter("receiverName");
		String content = request.getParameter("content");
		String nowTime = new Date().toString();
		
		ResultObject userRe = userDetailService.checkAutoMakerDetail(senderName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		AutoMakerDetail autoMakerDetail = (AutoMakerDetail) userRe.getObject();
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(receiverName);
		
		MsgToGarage msg = new MsgToGarage(autoMakerDetail, garageDetail, nowTime, content);
		msgService.createMsgToGarage(msg);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.MSG_SUCC, null)
				.getJsonString());
		
	}
	
	@RequestMapping(value = "/sendMsgToAutoMaker", method = RequestMethod.POST)
	public void sendMsgToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String password = request.getParameter("password");
		String receiverName = request.getParameter("receiverName");
		String content = request.getParameter("content");
		String nowTime = new Date().toString();
		
		ResultObject userRe = userDetailService.checkGarageDetail(senderName, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		GarageDetail garageDetail = (GarageDetail) userRe.getObject();
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(receiverName);

		MsgToAutoMaker msg = new MsgToAutoMaker(autoMakerDetail, garageDetail, nowTime, content);
		msgService.createMsgToAutoMaker(msg);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.MSG_SUCC, null)
				.getJsonString());
	}
	
}
