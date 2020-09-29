package com.rooftophero.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rooftophero.service.WebService;
import com.rooftophero.vo.WebVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private WebService webService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		return "insertWeb";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String insertWeb(WebVo vo, Model model) {
		logger.info("[POST] encryptWEb()");
		try {
			WebVo webVo = null;
			if("encrypt".equals(vo.getTranstype())) {
				webVo = webService.encryptWeb(vo);
			} else {				 
				webVo = webService.decryptWeb(vo);
			}
			model.addAttribute("webVo", webVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "viewWeb";
	}

}
