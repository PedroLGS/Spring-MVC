package br.com.pedroluiz.SpringMVC.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.pedroluiz.SpringMVC.model.FuncDep;
import br.com.pedroluiz.SpringMVC.persistence.FuncDepDao;

@Controller
public class FuncDepController {
	
	@Autowired
	private FuncDepDao fdDao;

	@RequestMapping(name = "funcdep", value = "/funcdep", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("funcdep");
	}
	@RequestMapping(name = "funcdep", value="/funcdep", method = RequestMethod.POST)
	public ModelAndView init(ModelMap model, @RequestParam Map<String,String>
	allParam) {
		String botaol = allParam.get("botaol");
		String botaoid = allParam.get("botaoid");
		
		double soma_salario = 0;
		List<FuncDep> listafd = new ArrayList<>();
						
		try {
			if(botaol!=null) {
				if (botaol.equals("Listar")) {
					listafd = fdDao.findfuncdep();
				}
			}
			else {
				FuncDep FuncDep = new FuncDep();
				FuncDep.setCodigo(1);
				soma_salario = fdDao.findsoma(Integer.parseInt(botaoid));
			}			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			model.addAttribute("lista", listafd);
			model.addAttribute("soma_salario", soma_salario);
			System.out.println(soma_salario);
		}
		return new ModelAndView("funcdep");
	}
}