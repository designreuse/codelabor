package org.codelabor.example.username.web.controller;

import javax.validation.Valid;

import org.codelabor.example.username.dto.RegistrationFormDto;
import org.codelabor.example.username.service.UsernameService;
import org.codelabor.system.security.core.context.SecurityContextHolderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/example/username/registration")
public class UsernameController {

	private final Logger logger = LoggerFactory
			.getLogger(UsernameController.class);

	@Autowired
	private UsernameService usernameService;

	private final static String FORM_VIEW_NAME = "example/username/registrationForm";
	private final static String COMPLETED_VIEW_NAME = "example/username/registrationCompleted";
	private final static String FAILED_VIEW_NAME = "example/username/registrationFailed";

	@RequestMapping(value = "/registrationUser", method = RequestMethod.GET)
	public ModelAndView prepareRegistration(ModelAndView mav) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else if (principal != null) {
			username = principal.toString();
		}
		logger.debug("username: {}", username);

		RegistrationFormDto registrationFormDto = new RegistrationFormDto();
		registrationFormDto.setUsername(username);
		mav.setViewName(FORM_VIEW_NAME);
		mav.addObject("registrationFormDto", registrationFormDto);
		return mav;
	}

	@RequestMapping(value = "/registrationUser", method = RequestMethod.POST)
	public String registration(@Valid RegistrationFormDto registrationFormDto,
			BindingResult result) {
		String username = SecurityContextHolderUtils.getUsername();
		logger.debug("username: {}", username);

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("error: {}", error.getDefaultMessage());
			}
			return FORM_VIEW_NAME;
		} else {
			int affectedRowCount = usernameService
					.registration(registrationFormDto);
			if (affectedRowCount == 1) {
				return COMPLETED_VIEW_NAME;
			} else {
				return FAILED_VIEW_NAME;
			}
		}
	}
}
