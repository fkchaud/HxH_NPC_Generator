package com.goldenimper.hxhgenerator.dto;

import java.util.List;

public class DTOMessages {
    private List<String> mensajes;

    public DTOMessages() {
    }

    public DTOMessages(List<String> mensajes) {
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
}