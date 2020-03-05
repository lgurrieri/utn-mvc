package edu.utn.frsr.spring.web;

import edu.utn.frsr.spring.model.Client;
import edu.utn.frsr.spring.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteController {
    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("welcome", "Bienvenido al sitio del curso JAVA de la UTN.");
        return modelAndView;
    }

    @RequestMapping("/clientes")
    public ModelAndView customer(){
        ModelAndView modelAndView = new ModelAndView("customers");

        List<Client> clients = new ArrayList<Client>();

        clients.add(new Client("Cliente 1", "cliente1@mail.com", "26046000"));
        clients.add(new Client("Cliente 2", "cliente2@mail.com", "26047000"));
        clients.add(new Client("Cliente 3", "cliente3@mail.com", "26048000"));

        modelAndView.addObject("customers_msg", "Clientes");
        modelAndView.addObject("customers", clients);
        return modelAndView;
    }

    @RequestMapping(value = "/contacto", method = RequestMethod.GET)
    public String contact(ModelMap modelMap){

        if (!modelMap.containsAttribute("contact")) {
            modelMap.addAttribute("contact", new Contact());
        }

        return "contacto";
    }

    @RequestMapping(value = "/contacto", method = RequestMethod.POST)
    public ModelAndView postContact(@ModelAttribute("bank") Contact contact){
        ModelAndView modelAndView = new ModelAndView("postcontact");

        modelAndView.addObject("email", contact.getEmail());
        modelAndView.addObject("subject", contact.getSubject());

        return modelAndView;
    }

}
