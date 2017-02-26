package automobile.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;
import automobile.business.entities.SmallClass;
import automobile.business.services.ClassService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;
import automobile.util.config.StaticString;

@Controller
public class UserController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();

	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 

	private ClassService classService = ctx.getBean(ClassService.class);
	
	@RequestMapping(value = "/registerAutoMaker", method = RequestMethod.POST)
	public void registerAutoMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String certcode = request.getParameter("certCode");
		
		// certcode TODO use Redis here
		// TODO check certCode
		boolean certCodeFlag = true;
		if (!certCodeFlag) {
			response.getWriter().write(new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_CERTCODE, null)
					.getJsonString());
			return;
		}
		
		// TODO: 查重
		AutoMakerDetail user = new AutoMakerDetail(username, password, "");
		userDetailService.createAutoMakerDetail(user, null);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.USER_REGISTER_SUCC, null)
				.getJsonString());
		
	}
	
	@RequestMapping(value = "/registerGarage", method = RequestMethod.POST)
	public void registerGarage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String certcode = request.getParameter("certCode");
		
		// certcode TODO use Redis here
		// TODO check certCode
		boolean certCodeFlag = true;
		if (!certCodeFlag) {
			response.getWriter().write(new ResultObject(
					StaticString.RESULT_FAIL, StaticString.USER_WRONG_CERTCODE, null)
					.getJsonString());
			return;
		}
		// TODO: 查重
		GarageDetail user = new GarageDetail(username, password, "");
		userDetailService.createGarageDetail(user);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.USER_REGISTER_SUCC, null)
				.getJsonString());
	}
	
	@RequestMapping(value = "/loginAutoMaker", method = RequestMethod.POST)
	public void loginAutoMaker(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		response.getWriter().write(userDetailService.checkAutoMakerDetail(username, password).getJsonString());
	}
	
	@RequestMapping(value = "/loginGarage", method = RequestMethod.POST)
	public void loginGarage(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		response.getWriter().write(userDetailService.checkGarageDetail(username, password).getJsonString());
	}

	
	@RequestMapping(value = "/getAutosBySmallClassId")
	public void getAutosBySmallClassId(@RequestParam(value="smallClassId", required=true) String smallClassId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		
		SmallClass smallClass = classService.findSmallClasById(smallClassId);
		List<AutoMakerDetail> autos = userDetailService.findAllAutoMakerDetailBySmallClass(smallClass);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.CLASS_AUTOMAKERS, autos)
				.getJsonString());
	}
	
	@RequestMapping(value = "/getAutoMakerDetailById")
	public void getAutoMakerDetailById(@RequestParam(value="autoMakerDetailId", required=true) String autoMakerDetailId, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		
		AutoMakerDetail autoMakerDetail = userDetailService.findAutoMakerDetailById(autoMakerDetailId);
		
		response.getWriter().write(new ResultObject(
				StaticString.RESULT_SUCC, StaticString.AUTOMAKER_DETAIL, autoMakerDetail)
				.getJsonString());
		
	}
	
	// TODO update detail
	@RequestMapping(value = "/updateAutoMakerDetail", method = RequestMethod.POST)
	public void updateAutoMakerDetail(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String name = request.getParameter("name");
		String manager = request.getParameter("manager");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
	
		ResultObject userRe = userDetailService.checkAutoMakerDetail(username, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		AutoMakerDetail autoMakerDetail = (AutoMakerDetail) userRe.getObject();
		autoMakerDetail.setName(name);
		autoMakerDetail.setManagerName(manager);
		autoMakerDetail.setPhone(phone);
		autoMakerDetail.setQq(qq);
		autoMakerDetail.setWechat(wechat);
		autoMakerDetail.setProvince(province);
		autoMakerDetail.setCity(city);
		autoMakerDetail.setAddress(address);
		userDetailService.updateAutoMakerDetail(autoMakerDetail);
		response.getWriter().write(userRe.getJsonString());
		
	}
	
	@RequestMapping(value = "/updateGarageDetail", method = RequestMethod.POST)
	public void updateGarageDetail(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String name = request.getParameter("name");
		String manager = request.getParameter("manager");
		String phone = request.getParameter("phone");
		String qq = request.getParameter("qq");
		String wechat = request.getParameter("wechat");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
	
		ResultObject userRe = userDetailService.checkGarageDetail(username, password);
		if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		
		GarageDetail garageDetail = (GarageDetail) userRe.getObject();
		garageDetail.setName(name);
		garageDetail.setManagerName(manager);
		garageDetail.setPhone(phone);
		garageDetail.setQq(qq);
		garageDetail.setWechat(wechat);
		garageDetail.setProvince(province);
		garageDetail.setCity(city);
		garageDetail.setAddress(address);
		userDetailService.updateGarageDetail(garageDetail);
		response.getWriter().write(userRe.getJsonString());
		
	}

	
	
}
