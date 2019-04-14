package br.usjt.previsoestempo.controller;

import br.usjt.previsoestempo.model.Usuario;
import br.usjt.previsoestempo.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("usuario", new Usuario());

        return modelAndView;
    }

    @PostMapping(value = "/efetuarlogin")
    public String efetuarLogin(HttpServletRequest request, Usuario usuario){
        if(loginService.validarUsuario(usuario)){
            request.getSession().setAttribute("usuarioLogado", usuario);

            return "redirect:/previsoes";
        }else {
            return  "login";
        }
    }
}
