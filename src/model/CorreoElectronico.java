/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author mati
 */
public class CorreoElectronico implements Serializable {

    private int idCorreo;
    private String DireccionCorreo;
    private Profesor idProfesor;

    private CorreoElectronico() {

    }

    public CorreoElectronico(int idCorreo, String direccionCorreo, Profesor profesor) {
        this.idCorreo = idCorreo;
        this.DireccionCorreo = direccionCorreo;
        this.idProfesor = profesor;
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getDireccionCorreo() {
        return DireccionCorreo;
    }

    public void setDireccionCorreo(String DireccionCorreo) {
        this.DireccionCorreo = DireccionCorreo;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

}
