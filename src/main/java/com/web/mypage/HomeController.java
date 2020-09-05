package com.web.mypage;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.mypage.dao.TodoDAO;
import com.web.mypage.dto.TestDTO;
import com.web.mypage.dto.TodoDTO;


/**
 * Handles requests for the application home page.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"} )
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private TestDTO testDTO;
	@Inject
	private TodoDAO todoDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		List<Integer> list = Arrays.asList(1,2,3);
		model.addAttribute("serverTime", formattedDate );
		try {
			model.addAttribute("testdata", testDTO.getTestData());
			//model.addAttribute("text", testDTO.textChange(list));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return "home";
	}

	@RequestMapping(value = "/getdata", method = RequestMethod.GET)
	@ResponseBody
	public String getData() {
		return "testdata";
	}

	@RequestMapping(value = "/gettodolist", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<TodoDTO> getTodoList() {
		try {
			List<TodoDTO> list = todoDAO.getTodoList();
			if(list == null) {
				return new ArrayList<TodoDTO>();
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@RequestMapping(value = "/data", method = RequestMethod.OPTIONS)
	@ResponseBody
	public String loginOptions(
	  @RequestHeader(value="Access-Control-Request-Method", required=false) String requestMethods,
	  @RequestHeader(value="Access-Control-Request-Headers", required=false) String requestHeaders,
	  HttpServletRequest request,
	  HttpServletResponse response){
	   
	  if(StringUtils.hasLength(requestMethods)){
	    response.setHeader("Access-Control-Allow-Methods", requestMethods);
	  }

	  if (StringUtils.hasLength(requestHeaders)){
		response.setHeader("Access-Control-Allow-Headers", requestHeaders);
	  }
	  response.setHeader("Access-Control-Allow-Origin", "*");
	  return "responseData";
	}
}
