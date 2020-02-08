package edu.pucese.ereservation.vista.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pucese.ereservation.business.services.ClienteService;
import edu.pucese.ereservation.modelo.Cliente;

@Controller
@RequestMapping("/app")
public class ClienteController {
private final ClienteService clienteService;
@Autowired
public ClienteController(ClienteService clienteService) {
this.clienteService = clienteService;
}
	@GetMapping("/home")
	public ModelAndView home() {
	ModelAndView mav = new ModelAndView();
	mav.addObject("cliente", clienteService.findAll());
	mav.setViewName("home");
	return mav;
	}
	
	@GetMapping("/new_cliente")
	public ModelAndView new_cliente() {
	ModelAndView mav = new ModelAndView();
	Cliente c = new Cliente();
	 mav.addObject("cliente", c);
	mav.setViewName("new_cliente");
	return mav;
	}
	@PostMapping(value = "/save")
	public String save(@ModelAttribute("cliente") Cliente cliente) {
	clienteService.create(cliente);
	
	 return "redirect:/app/home";
	}
	@PostMapping("update/{identificacionCli}")
	public String updateStudent(@PathVariable("identificacionCli")
	String identificacionCli, @Valid Cliente cliente, BindingResult result,
	Model model) {
	if (result.hasErrors()) {
	cliente.setIdentificacionCli(identificacionCli);
	return "update-student";
	}
	clienteService.update(cliente);
	model.addAttribute("cliente", clienteService.findAll());
	return "redirect:/app/home";
	}
	
	
	@GetMapping("/edit/{identificacionCli}")
	public ModelAndView showEdit(@PathVariable(name ="identificacionCli") String identificacionCli) 
	{
	 ModelAndView mav = new ModelAndView("edit_cliente");
	 if (identificacionCli.isEmpty()) {
	 mav.addObject("cliente", new Cliente());
	
	 } 
	 else {
	 Cliente c1 =
	clienteService.findByIdentificacion(identificacionCli);
	
	 mav.addObject("cliente", c1);
	
	 
	 }
	
	 return mav;
	}
	@RequestMapping("/delete/{identificacionCli}")
	public String deleteCliente(Model model,@PathVariable(name =
	"identificacionCli") String identificacionCli) {
	Cliente cliente =
	this.clienteService.findByIdentificacion(identificacionCli);
	this.clienteService.delete(cliente);
	return "redirect:/app/home";
	}
	}
