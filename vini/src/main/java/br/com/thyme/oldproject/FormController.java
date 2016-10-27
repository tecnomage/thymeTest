package br.com.thyme.oldproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/form")
public class FormController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView form(PersonForm personForm) {
		ModelAndView pagina = new ModelAndView("form");
		return pagina;
	}

	
	//TODO não carrega se estiver no caminho /form/about no /form ok!
	@RequestMapping("/about")
	public ModelAndView lista(ModelAndView usuarios) {
		ModelAndView sobre = new ModelAndView("about");

		return sobre;
	}

}
