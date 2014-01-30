package ua.pp.constantine.testtask.web.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.pp.constantine.testtask.web.model.PlainUser;

@Controller
public class LoginPage {

	public static final String VIEW_NAME = "login";
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    	model.addAttribute("user", new PlainUser());
    	return VIEW_NAME;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(
    		@ModelAttribute("user") PlainUser plainUser,
    		BindingResult result, HttpServletRequest request) {
    	
    	// validate parameters
    	ValidationUtils.rejectIfEmptyOrWhitespace(result, "username", "username.empty");
    	ValidationUtils.rejectIfEmptyOrWhitespace(result, "password", "password.empty");
    	if(result.hasErrors()) {
			return VIEW_NAME;
		}
    	
		try {
			authenticateUser(request, plainUser.getUsername(), plainUser.getPassword());
			return "redirect:/helloWorld";
		} catch (BadCredentialsException e) {
			result.rejectValue("username", "credentials.invalid");
			return VIEW_NAME;
		}
    }
    
    public void authenticateUser(HttpServletRequest request, String username, String password) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
    }
    
    @RequestMapping(value = { "/", "/logout" }, method = RequestMethod.GET)
    public String logout() {
    	return "redirect:/" + VIEW_NAME;
    }
}
