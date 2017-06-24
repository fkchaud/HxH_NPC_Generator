package com.goldenimper.hxhgenerator.entity;

public class Ability {
    private String nombre;
    private int valor;
    private Stat stat;

    //constructor
    public Ability(String nombre, int valor, Stat stat) {
        this.nombre = nombre;
        this.valor = valor;
        this.stat = stat;
    }
    public Ability(String nombre) {
        this.nombre = nombre;
    }
    public Ability(String nombre, Stat stat) {
        this.nombre = nombre;
        this.stat = stat;
    }
    public Ability() {
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
    public Stat getStat() {
        return stat;
    }
    public void setStat(Stat stat) {
        this.stat = stat;
    }
}