package com.goldenimper.hxhgenerator.dto;

public class DTOHabilidad {
    private String nombreHabilidad;
    private String atributoHabilidad;
    private int idView;

    public DTOHabilidad(){}

    public DTOHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public DTOHabilidad(String nombreHabilidad, String atributoHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.atributoHabilidad = atributoHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getAtributoHabilidad() {
        return atributoHabilidad;
    }

    public void setAtributoHabilidad(String atributoHabilidad) {
        this.atributoHabilidad = atributoHabilidad;
    }

    public int getIdView() {
        return idView;
    }

    public void setIdView(int idView) {
        this.idView = idView;
    }
}
