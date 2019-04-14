package br.usjt.previsoestempo.controller;

import br.usjt.previsoestempo.model.Previsao;
import br.usjt.previsoestempo.service.PrevisoesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PrevisoesController {

    @Autowired
    private PrevisoesService previsoesService;

    @GetMapping("/previsoes")
    public ModelAndView listarPrevisoes(){
        ModelAndView modelAndView = new ModelAndView("lista_previsoes");

        List<Previsao> previsoes = previsoesService.listarPrevisoes();

        modelAndView.addObject("previsoes", previsoes);

        return modelAndView;
    }
}