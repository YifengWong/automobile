package automobile.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import automobile.business.entities.AbstractUserDetail;
import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.MsgToAutoMaker;
import automobile.business.entities.MsgToGarage;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;
import automobile.util.config.StaticConfig;

@Controller
public class MsgController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	@RequestMapping(value = "/getMsgs", method = RequestMethod.POST)
	public void getMsgs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String usertype = request.getParameter("usertype");

		AbstractUserDetail user = null;
		
		if (usertype.equals("autoMaker")) {
			user = userDetailService.findAutoMakerDetailByUserName(username);
		} else if (usertype.equals("garage")) {
			user = userDetailService.findGarageDetailByUserName(username);
		}
		
		if (user == null) {
			response.getWriter().write(new ResultObject(
					StaticConfig.STR_RESULT_FAIL, StaticConfig.MSG_WRONG_USERNAME, null)
					.getJsonString());
			return;
		}

		if (user instanceof AutoMakerDetail) {
			List<MsgToAutoMaker> msgs = msgService.findAllMsgsToAutoMaker((AutoMakerDetail) user);
			response.getWriter().write(new ResultObject(
					StaticConfig.STR_RESULT_SUCC, StaticConfig.MSG_ALL＿MSGS, msgs)
					.getJsonString());
			return;
		} else if (user instanceof GarageDetail) {
			List<MsgToGarage> msgs = msgService.findAllMsgsToGarage((GarageDetail) user);
			response.getWriter().write(new ResultObject(
					StaticConfig.STR_RESULT_SUCC, StaticConfig.MSG_ALL＿MSGS, msgs)
					.getJsonString());	
			return;
		}
		
	}
	
	@RequestMapping(value = "/sendMsgToGarage", method = RequestMethod.POST)
	public void sendMsgToGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String receiverName = request.getParameter("receiverName");
		String content = request.getParameter("content");
		String nowTime = new Date().toString();
		
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(senderName);
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(receiverName);
		
		MsgToGarage msg = new MsgToGarage(autoMakerDetail, garageDetail, nowTime, content);
		msgService.createMsgToGarage(msg);
		
		response.getWriter().write(new ResultObject(
				StaticConfig.STR_RESULT_SUCC, StaticConfig.MSG_SENDMSG_SUCC, null)
				.getJsonString());
		
	}
	
	@RequestMapping(value = "/sendMsgToAutoMaker", method = RequestMethod.POST)
	public void sendMsgToAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String senderName = request.getParameter("senderName");
		String receiverName = request.getParameter("receiverName");
		String content = request.getParameter("content");
		String nowTime = new Date().toString();
		
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailByUserName(receiverName);
		GarageDetail garageDetail = userDetailService.findGarageDetailByUserName(senderName);

		MsgToAutoMaker msg = new MsgToAutoMaker(autoMakerDetail, garageDetail, nowTime, content);
		msgService.createMsgToAutoMaker(msg);
		
		response.getWriter().write(new ResultObject(
				StaticConfig.STR_RESULT_SUCC, StaticConfig.MSG_SENDMSG_SUCC, null)
				.getJsonString());
	}
	
}
