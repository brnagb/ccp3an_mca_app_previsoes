package br.usjt.previsoestempo;

import br.usjt.previsoestempo.model.Previsao;
import br.usjt.previsoestempo.model.Semana;
import br.usjt.previsoestempo.model.Usuario;
import br.usjt.previsoestempo.repository.PrevisaoRepository;
import br.usjt.previsoestempo.repository.SemanaRepository;
import br.usjt.previsoestempo.repository.UsuarioRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@SpringBootApplication
public class PrevisaotempoApplication {

    public static void main(String[] args) {
        ExecutarFuncoesBD();

        SpringApplication.run(PrevisaotempoApplication.class, args);
    }

    private static void ExecutarFuncoesBD() {
        Usuario usuario = new Usuario();
        usuario.setLogin("admin");
        usuario.setSenha("admin");

        new UsuarioRepository().insert(usuario);

        Semana[] semanas = inserirSemanas();
        inserirPrevisoes(semanas);
    }

    private static Semana[] inserirSemanas() {
        Semana[] semanas = new Semana[]{
                new Semana("Segunda"),
                new Semana("Terça"),
                new Semana("Quarta"),
                new Semana("Quinta"),
                new Semana("Sexta"),
        };

        for (Semana semana : semanas) {
            new SemanaRepository().insert(semana);
        }

        return semanas;
    }

    private static void inserirPrevisoes(Semana[] semanas) {
        Previsao[] previsoes = new Previsao[]{
                new Previsao(semanas[0], 15.1, 25.7, 0.77, "", "2019-04-08 09:00:00", -23.49, -46.35),
                new Previsao(semanas[1], 14.8, 26.7, 0.77, "", "2019-04-09 09:00:00", -23.49, -46.35),
                new Previsao(semanas[2], 13.2, 29.9, 0.77, "", "2019-04-10 09:00:00", -23.49, -46.35),
                new Previsao(semanas[3], 20.1, 31.6, 0.77, "", "2019-04-11 09:00:00", -23.49, -46.35),
                new Previsao(semanas[4], 20.4, 31.4, 0.77, "", "2019-04-12 09:00:00", -23.49, -46.35),
        };

        for (Previsao previsao : previsoes) {
            new PrevisaoRepository().insert(previsao);
        }
    }
}
