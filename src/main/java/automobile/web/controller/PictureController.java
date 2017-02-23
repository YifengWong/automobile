package automobile.web.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import automobile.business.entities.AutoMakerDetail;
import automobile.business.entities.GarageDetail;
import automobile.business.services.PictureService;
import automobile.business.services.UserDetailService;
import automobile.util.ResultObject;

@Controller
public class PictureController {
	private AnnotationConfigApplicationContext ctx = automobile.util.config.DBCtx.getDBCtx();
	
	private PictureService pictureService = ctx.getBean(PictureService.class);
	private UserDetailService userDetailService = ctx.getBean(UserDetailService.class); 
	
	@RequestMapping(value="/uploadAutoMakerHeadImg", method=RequestMethod.POST)
	public void uploadAutoMakerHeadImg(@RequestParam(value="img")MultipartFile img, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ResultObject uploadRe = pictureService.uploadHead(img);
		ResultObject userRe = userDetailService.checkAutoMakerDetail(username, password);
		if (uploadRe.getObject() == null) {
			response.getWriter().write(uploadRe.getJsonString());
			return;
		} else if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		AutoMakerDetail autoMaker = (AutoMakerDetail) userRe.getObject();
		autoMaker.setHeadImgName(uploadRe.getObject().toString());
		userDetailService.updateAutoMakerDetail(autoMaker);
		response.getWriter().write(uploadRe.getJsonString());
	}
	
	@RequestMapping(value="/uploadGarageHeadImg", method=RequestMethod.POST)
	public void uploadGarageHeadImg(@RequestParam(value="img")MultipartFile img, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/json;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ResultObject uploadRe = pictureService.uploadHead(img);
		ResultObject userRe = userDetailService.checkAutoMakerDetail(username, password);
		if (uploadRe.getObject() == null) {
			response.getWriter().write(uploadRe.getJsonString());
			return;
		} else if (userRe.getObject() == null) {
			response.getWriter().write(userRe.getJsonString());
			return;
		}
		GarageDetail garage = (GarageDetail) userRe.getObject();
		garage.setHeadImgName(uploadRe.getObject().toString());
		userDetailService.updateGarageDetail(garage);
		response.getWriter().write(uploadRe.getJsonString());
	}

	
	@RequestMapping(value = "/getHeadImg")
	public void getHeadImg(@RequestParam(value="headImgName", required=true) String headImgName, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String suffix = headImgName.substring(headImgName.lastIndexOf(".")+1);
		response.setContentType("image/" + suffix);
		
		OutputStream out = response.getOutputStream();
		out.write(pictureService.getHeadImageBytes(headImgName));
		out.flush();
		
	}
}
