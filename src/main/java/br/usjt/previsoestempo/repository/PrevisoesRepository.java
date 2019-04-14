package br.usjt.previsoestempo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.previsoestempo.model.Previsao;

public interface PrevisoesRepository extends JpaRepository<Previsao, Long> {
}
