package ua.pp.constantine.testtask.web.pages;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldPage {

	public static final String VIEW_NAME = "helloWorld";

	@RequestMapping("/helloWorld")
    public String helloWorldPage(ModelMap model, Principal principal) {
        String username = principal == null ? "" : principal.getName();
        model.put("username", username);
        return VIEW_NAME;
    }
}
