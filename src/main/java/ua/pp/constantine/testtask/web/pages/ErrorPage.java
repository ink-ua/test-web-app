package ua.pp.constantine.testtask.web.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPage {

	private static final String ERROR_KEY = "errorMessage";
	private static final String VIEW_NAME = "error";
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/error/{errorCode}")
    public String handleError(@PathVariable("errorCode") String errorCode, ModelMap model) {
		model.put(ERROR_KEY, messageSource.getMessage("error." + errorCode, null, null));
        return VIEW_NAME;
    }
}
