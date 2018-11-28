package com.pacto.web.model;
// Generated 16/11/2018 12:49:47 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pregunta generated by hbm2java
 */
@Entity
@Table(name = "Pregunta")
public class Pregunta implements java.io.Serializable {

    private Integer idPregunta;
    private int idMision;
    private String pregunta;
    private String descripcion;
    private int cantidadRespuestas;

    public Pregunta() {
    }

    public Pregunta(int idMision, String pregunta, String descripcion, int cantidadRespuestas) {
        this.idMision = idMision;
        this.pregunta = pregunta;
        this.descripcion = descripcion;
        this.cantidadRespuestas = cantidadRespuestas;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "Id_pregunta", unique = true, nullable = false)
    public Integer getIdPregunta() {
        return this.idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Column(name = "Id_Mision", nullable = false)
    public int getIdMision() {
        return this.idMision;
    }

    public void setIdMision(int idMision) {
        this.idMision = idMision;
    }

    @Column(name = "Pregunta", nullable = false, length = 500)
    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @Column(name = "Descripcion", nullable = false, length = 500)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "CantidadRespuestas", nullable = false)
    public int getCantidadRespuestas() {
        return this.cantidadRespuestas;
    }

    public void setCantidadRespuestas(int cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

}
