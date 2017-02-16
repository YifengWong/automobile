package automobile.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import automobile.business.entities.AbstractUserDetail;
import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.SmallClass;
import automobile.business.services.ClassService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;

@Controller
public class UserController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 

	private ClassService classService = ctx.getBean(ClassService.class);
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String certcode = request.getParameter("certCode");
		String usertype = request.getParameter("userType");
		// use Redis
		// TODO check certCode
		boolean certCodeFlag = true;
		
		
		if (!certCodeFlag) {
			response.getWriter().write(new ResultObject(
					ResultObject.FAIL, "cert code wrong", null).getJsonString());
			return;
		} 
		if (usertype.equals("autoMaker")) {
			AutoMakerDetail user = new AutoMakerDetail(username, password, "");
			userDetailService.createAutoMakerDetail(user, null);
		} else if (usertype.equals("garage")) {
			GarageDetail user = new GarageDetail(username, password, "");
			userDetailService.createGarageDetail(user);
		} else {
			// TODO return failed
		}
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		AbstractUserDetail user = null;
		
		if (usertype.equals("autoMaker")) {
			user = userDetailService.findAutoMakerDetailByUserName(username);
		} else if (usertype.equals("garage")) {
			user = userDetailService.findGarageDetailByUserName(username);
		}
		
		if (user == null) {
			response.getWriter().write(new ResultObject(
					ResultObject.FAIL, "username wrong", null).getJsonString());
		} else {
			if (!user.getPassword().equals(password)) {
				response.getWriter().write(new ResultObject(
						ResultObject.FAIL, "password wrong", null).getJsonString());
			} else {
				response.getWriter().write(new ResultObject(
						ResultObject.SUCC, "OK", user).getJsonString());
			}
		}
		
	}
	
	@RequestMapping(value = "/getAutosBySmallClassId")
	public void getAutosBySmallClassId(@RequestParam(value="smallClassId", required=true) String smallClassId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		SmallClass smallClass = classService.findSmallClasById(Integer.valueOf(smallClassId));
		
		List<AutoMakerDetail> autos = userDetailService.findAllAutoMakerDetailBySmallClass(smallClass);
		
		response.getWriter().write(new ResultObject(ResultObject.SUCC, "autos", autos).getJsonString());
		
	}
}
