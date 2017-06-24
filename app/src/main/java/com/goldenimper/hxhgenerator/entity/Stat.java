package com.goldenimper.hxhgenerator.entity;

public class Stat {
    private String nombre;
    private int valor;
    private int orden;

    //constructor
    public Stat(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }
    public Stat(String nombre) {
        this.nombre = nombre;
    }
    public Stat() {
    }

    //get set
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
    
}