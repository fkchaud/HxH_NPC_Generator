package com.goldenimper.hxhgenerator.design;

import com.goldenimper.hxhgenerator.entity.*;
import com.goldenimper.hxhgenerator.dto.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class ExpertRandomPJ {
    private Pj pj;
    private int puntosHabilidadTotal;
    private int puntosHabilidadRestante;

    public ExpertRandomPJ() {
        this.setup();
    }
    
    private void setup(){
        Stat fuerza = new Stat("Fuerza");
        Stat destreza = new Stat("Destreza");
        Stat inteligencia = new Stat("Inteligencia");
        Stat percepcion = new Stat("Percepción");
        ArrayList<Stat> stats = new ArrayList<>();
        stats.add(fuerza);
        stats.add(destreza);
        stats.add(inteligencia);
        stats.add(percepcion);
        
        pj = new Pj(stats, new ArrayList<Ability>(), new ArrayList<Ability>());
        pj.addAbility(new Ability("Advertir/Notar", percepcion));
        pj.addAbility(new Ability("Armas a Distancia", destreza));
        pj.addAbility(new Ability("Armas Cuerpo a Cuerpo", fuerza));
        pj.addAbility(new Ability("Atletismo", fuerza));
        pj.addAbility(new Ability("Bailar", destreza));
        pj.addAbility(new Ability("Buscar", percepcion));
        pj.addAbility(new Ability("Callejeo", inteligencia));
        pj.addAbility(new Ability("Comercio", inteligencia));
        pj.addAbility(new Ability("Conducir", destreza));
        pj.addAbility(new Ability("Esquivar", destreza));
        pj.addAbility(new Ability("Historia", inteligencia));
        pj.addAbility(new Ability("Informática", inteligencia));
        pj.addAbility(new Ability("Leyes", inteligencia));
        pj.addAbility(new Ability("Mecánica", inteligencia));
        pj.addAbility(new Ability("Medicina", inteligencia));
        pj.addAbility(new Ability("Música", percepcion));
        pj.addAbility(new Ability("Ocultismo", inteligencia));
        pj.addAbility(new Ability("Reflejos", percepcion));
        pj.addAbility(new Ability("Pilotar", destreza));
        pj.addAbility(new Ability("Sigilo", destreza));
        pj.addAbility(new Ability("Supervivencia", inteligencia));
    }
    
    private int dadoMedio(int caras){
        int a = dado(caras);
        int b = dado(caras);
        int c = dado(caras);
        int mid = Math.max(Math.min(a,b), Math.min(Math.max(a,b),c));
        return mid;
    }
    private int dado(int caras){
        Random r = new Random();
        return r.nextInt(caras)+1;
    }
    
    public DTOMessages indicarPuntos(int puntos) {
        puntosHabilidadTotal = puntos;
        puntosHabilidadRestante = puntos;
        
        DTOMessages dtoMensajes = new DTOMessages(new ArrayList());
        
        dtoMensajes.addMensaje("Piola, "+puntos+" puntos.");
        dtoMensajes.addMensaje("Ahora te enumero las habilidades y vos ponés el numerito que salga a la izquierda de cuál querés maxear. Le das Enter.");
        dtoMensajes.addMensaje("Después ponés los puntos que le querés meter a la gilada y le volvés a dar Enter.");
        dtoMensajes.addMensaje("Si no pinta ninguna ponés 999 a huevo dos veces.");
        for (int i=0; i<pj.getAbilities().size() ;i++) {
            dtoMensajes.addMensaje(i + ". " + pj.getAbilities().get(i).getNombre());
        }
        return dtoMensajes;
    }
    
    public DTORepeticionHabilidades masHabilidades(int habNum, int puntosHab) {
        DTORepeticionHabilidades dtoMensajes = new DTORepeticionHabilidades(new ArrayList());
        if (habNum == 999) {
            String terminando = "Por ahora elegiste: ";
            for (Ability abi : pj.getAbilitiesDone()) {
                    terminando += abi.getNombre() + ", ";
            }
            dtoMensajes.addMensaje(terminando);
            dtoMensajes.addMensaje("Bue, ya ta tonces.");
            dtoMensajes.addMensaje("Quedan "+puntosHabilidadRestante+" puntos, esos los mando random en lo que queda y manejate.");    
            dtoMensajes.setYaTa(true);
            
        } else if (habNum >= pj.getAbilities().size()) {
            String terminando = "Por ahora elegiste: ";
            for (Ability abi : pj.getAbilitiesDone()) {
                    terminando += abi.getNombre() + ", ";
            }
            dtoMensajes.addMensaje(terminando);
            dtoMensajes.addMensaje("¿Qué mierda pusiste? Dale de nuevo.");
            dtoMensajes.setYaTa(false);
            
        } else if (puntosHab > puntosHabilidadRestante) {
            String terminando = "Por ahora elegiste: ";
            for (Ability abi : pj.getAbilitiesDone()) {
                    terminando += abi.getNombre() + ", ";
            }
            dtoMensajes.addMensaje(terminando);
            dtoMensajes.addMensaje("No, pará, no tenés tantos puntos. Dale de nuevo.");
            dtoMensajes.setYaTa(false);
        
        } else {
            puntosHabilidadRestante -= puntosHab;
            Ability ab = pj.getAbilities().get(habNum);
            pj.addAbilityDone(new Ability(ab.getNombre(), puntosHab, ab.getStat()));
            pj.getAbilities().remove(ab);
            String terminando = "Por ahora elegiste: ";
            for (Ability abi : pj.getAbilitiesDone()) {
                    terminando += abi.getNombre() + ", ";
            }
            dtoMensajes.addMensaje(terminando);
            
            if (pj.getAbilities().isEmpty()) {
                dtoMensajes.addMensaje("Y... ya no quedan habilidades, maestro.");
                dtoMensajes.addMensaje("Jugate los otros "+puntosHabilidadRestante+" puntos al truco.");
                dtoMensajes.setYaTa(true);
            } else if (puntosHabilidadRestante == 0) {
                dtoMensajes.addMensaje("Fuaaaaaaaaa, qué precisión.");
                dtoMensajes.addMensaje("¡Ya no hay más puntos! Ya merito.");
                dtoMensajes.setYaTa(true);
            } else {
                dtoMensajes.addMensaje("Te quedan "+puntosHabilidadRestante+" puntos.");
                dtoMensajes.addMensaje("Ahora te enumero las habilidades que quedan y vos hacés todo de nuevo.");
                dtoMensajes.addMensaje("Si no pinta ninguna ponés 999 a huevo.");
                for (int i=0; i<pj.getAbilities().size() ;i++) {
                    dtoMensajes.addMensaje(i + ". " + pj.getAbilities().get(i).getNombre());
                }
                dtoMensajes.setYaTa(false);
            }
        }
        return dtoMensajes;
    }
    
    public DTOMessages solicitarMaximoRandom(){
        DTOMessages dtoMaxRandom = new DTOMessages(new ArrayList());
        dtoMaxRandom.addMensaje("Ahora tenés que poner el máximo para las habilidades random.");
        return dtoMaxRandom;
    }
    public DTOMessages randomeameEsta(int mr){
        DTOMessages dtoRandom = new DTOMessages(new ArrayList());
        
        dtoRandom.addMensaje("Bueno, con los "+puntosHabilidadRestante+" puntos que quedan, te randomeo todo.");
        
        do {
            int puntos = dado(Math.min(mr, puntosHabilidadRestante));
            int indiceHabilidad = dado(pj.getAbilities().size())-1;
            Ability habilidad = pj.getAbilities().get(indiceHabilidad);
            pj.addAbilityDone(new Ability(habilidad.getNombre(), puntos, habilidad.getStat()));
            pj.getAbilities().remove(habilidad);
            puntosHabilidadRestante -= puntos;
        } while (puntosHabilidadRestante > 0 && !pj.getAbilities().isEmpty());

        for (Stat st : pj.getStats()) {
            st.setValor(dadoMedio(10));
        }

        dtoRandom.addMensaje("###############");
        dtoRandom.addMensaje("# Stats       #");
        dtoRandom.addMensaje("###############");
        for (Stat stats : pj.getStats()) {
            dtoRandom.addMensaje(stats.getNombre() + ": " + stats.getValor());
        }
        
        dtoRandom.addMensaje("###############");
        dtoRandom.addMensaje("# Habilidades #");
        dtoRandom.addMensaje("###############");
        for (Ability habilidad : pj.getAbilitiesDone()) {
            dtoRandom.addMensaje(habilidad.getNombre() + ": " + habilidad.getValor());
        }

        return dtoRandom;
    }

    public ArrayList<DTOHabilidad> getHabilidades(){
        ArrayList<DTOHabilidad> habilidades = new ArrayList<>();

        for (Ability ab : pj.getAbilities()) {
            habilidades.add(new DTOHabilidad(ab.getNombre(), ab.getStat().getNombre()));
        }

        return habilidades;
    }
}