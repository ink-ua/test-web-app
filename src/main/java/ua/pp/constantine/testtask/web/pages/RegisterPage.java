package ua.pp.constantine.testtask.web.pages;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.pp.constantine.testtask.persistence.api.UserManager;
import ua.pp.constantine.testtask.persistence.model.User;
import ua.pp.constantine.testtask.web.model.PlainUser;
import ua.pp.constantine.testtask.web.model.validation.PlainUserValidator;

@Controller
public class RegisterPage {

	public static final String VIEW_NAME = "register";
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
				
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
    	model.addAttribute("user", new PlainUser());
        return VIEW_NAME;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegister(@Valid @ModelAttribute("user") PlainUser plainUser, BindingResult result,
    		@RequestParam("password2") String password2, ModelMap model) {

    	// check for existing user name
		if(!result.hasFieldErrors("username") && userManager.findByUsername(plainUser.getUsername()) != null) {
			result.rejectValue("username", "username.exists", new String[] { plainUser.getUsername() }, null);
		}

		// check for password match
		if(plainUser.getPassword() != null && !plainUser.getPassword().equals(password2)) {
			result.rejectValue("password", "password.nomatch");
    	}

		if(result.hasErrors()) {
			return VIEW_NAME;
		}

		// save user if no validation errors		
		String passwordHash = passwordEncoder.encode(plainUser.getPassword());
		User user = new User(plainUser.getUsername(), passwordHash);
		userManager.save(user);
		
		// forward request in order to login user
		return "forward:/login";
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new PlainUserValidator());
    }
}
