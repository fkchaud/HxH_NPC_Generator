package com.goldenimper.hxhgenerator;

import android.app.Activity;
import android.os.Bundle;

public class GeneradorPNJ extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_pnj);
    }
}


/*
Scanner scanner = new Scanner(System.in);
        ExpertRandomPJ experto = new ExpertRandomPJ();

        DTOMessages inicio = experto.iniciarCreación();
        for (String st : inicio.getMensajes()) {
            System.out.println(st);
        }
        System.out.println("");

        DTOMessages puntos = experto.indicarPuntos(scanner.nextInt());
        for (String st : puntos.getMensajes()) {
            System.out.println(st);
        }
        System.out.println("");

        boolean bastaHabilidades = false;
        do {
            System.out.println("Número de Habilidad: ");
            int numHab = scanner.nextInt();
            System.out.println("Puntos de Habilidad: ");
            int puntosHab = scanner.nextInt();
            DTORepeticionHabilidades masHabilidades = experto.masHabilidades(numHab, puntosHab);
            bastaHabilidades = masHabilidades.isYaTa();
            for (String st : masHabilidades.getMensajes()) {
                System.out.println(st);
            }
            System.out.println("");
        } while (!bastaHabilidades);

        DTOMessages maxRandom = experto.solicitarMaximoRandom();
        for (String st : maxRandom.getMensajes()) {
            System.out.println(st);
        }
        System.out.println("");

        DTOMessages sefini = experto.randomeameEsta(scanner.nextInt());
        for (String st : sefini.getMensajes()) {
            System.out.println(st);
        }
        System.out.println("");
 */