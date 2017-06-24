package com.goldenimper.hxhgenerator.dto;

import java.util.List;

public class DTORepeticionHabilidades {
    private List<String> mensajes;
    private boolean yaTa;

    public DTORepeticionHabilidades() {
    }

    public DTORepeticionHabilidades(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }

    public void addMensaje(String mensaje){
        this.mensajes.add(mensaje);
    }

    public boolean isYaTa() {
        return yaTa;
    }

    public void setYaTa(boolean yaTa) {
        this.yaTa = yaTa;
    }
    
    
}
