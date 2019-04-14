package br.usjt.previsoestempo.service;

import br.usjt.previsoestempo.model.Previsao;
import br.usjt.previsoestempo.repository.PrevisaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrevisoesService {

    @Autowired
    private PrevisaoRepository previsoesRepository;

    public List<Previsao> listarPrevisoes(){
        return previsoesRepository.findAll();
    }
}
