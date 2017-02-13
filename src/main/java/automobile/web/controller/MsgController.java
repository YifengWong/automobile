package automobile.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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
import automobile.business.entities.Test;
import automobile.business.services.ClassService;
import automobile.business.services.DiscussService;
import automobile.business.services.MsgService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;

@Controller
public class MsgController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private ClassService classService = ctx.getBean(ClassService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	private DiscussService discussService = ctx.getBean(DiscussService.class);
	private MsgService msgService = ctx.getBean(MsgService.class);
	
	@RequestMapping(value = "/getMsgs", method = RequestMethod.POST)
	public void getMsgs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String usertype = request.getParameter("usertype");

		AbstractUserDetail user = null;
		
		if (usertype.equals("autoMaker")) {
			user = userDetailService.findAutoMakerDetailByUserName(username);
		} else if (usertype.equals("garage")) {
			user = userDetailService.findGarageDetailByUserName(username);
		}
		
		if (user != null) {
			if (user instanceof AutoMakerDetail) {
				List<MsgToAutoMaker> msgs = msgService.findAllMsgsToAutoMaker((AutoMakerDetail) user);
				response.getWriter().write(new ResultObject(ResultObject.SUCC, "msgs", msgs).getJsonString());
				return;
			} else if (user instanceof GarageDetail) {
				List<MsgToGarage> msgs = msgService.findAllMsgsToGarage((GarageDetail) user);
				response.getWriter().write(new ResultObject(ResultObject.SUCC, "msgs", msgs).getJsonString());	
				return;
			}
		}
		
		response.getWriter().write(new ResultObject(ResultObject.FAIL, "no user", null).getJsonString());
	}
}
