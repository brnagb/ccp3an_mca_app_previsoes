package br.usjt.previsoestempo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Previsao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "semana")
    private Semana semana;

    private Double tempMinima;
    private Double tempMaxima;
    private Double humidadeRelativaAr;
    private String descricao;
    private String dataHora;
    private Double latitude;
    private Double longitude;


    public Previsao() { }

    public Previsao(Semana semana, Double tempMinima, Double tempMaxima, Double humidadeRelativaAr, String descricao, String dataHora, Double latitude, Double longitude) {
        this.semana = semana;
        this.tempMinima = tempMinima;
        this.tempMaxima = tempMaxima;
        this.humidadeRelativaAr = humidadeRelativaAr;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana diaSemana) {
        this.semana = diaSemana;
    }

    public Double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(Double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public Double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(Double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public Double getHumidadeRelativaAr() {
        return humidadeRelativaAr;
    }

    public void setHumidadeRelativaAr(Double humidadeRelativaAr) {
        this.humidadeRelativaAr = humidadeRelativaAr;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "Previsao{" +
                "id=" + id +
                ", semana=" + semana +
                ", tempMinima=" + tempMinima +
                ", tempMaxima=" + tempMaxima +
                ", humidadeRelativaAr=" + humidadeRelativaAr +
                ", descricao='" + descricao + '\'' +
                ", dataHora='" + dataHora + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Previsao previsao = (Previsao) o;
        return Objects.equals(id, previsao.id) &&
                Objects.equals(dataHora, previsao.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataHora);
    }
}