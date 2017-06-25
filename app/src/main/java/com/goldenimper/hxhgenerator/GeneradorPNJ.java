package com.goldenimper.hxhgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.goldenimper.hxhgenerator.dto.*;
import com.goldenimper.hxhgenerator.design.ExpertRandomPJ;
import java.util.ArrayList;

public class GeneradorPNJ extends Activity {

    ExpertRandomPJ expertRandomPJ = new ExpertRandomPJ();
    ArrayList<DTOHabilidad> habilidades;
    final int basicIDHabilidades = 234567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generador_pnj);

        habilidades = expertRandomPJ.getHabilidades();
        LinearLayout layoutHabilidades = findViewById(R.id.puntosHabilidadLayout);
        LinearLayout.LayoutParams paramsLL = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < habilidades.size(); i++) {

            LinearLayout abLay = new LinearLayout(this);
            abLay.setOrientation(LinearLayout.HORIZONTAL);
            abLay.setLayoutParams(paramsLL);

            //crearle un Label con la inicial del stat
            TextView inicial = new TextView(this);
            inicial.setText(
                    habilidades.get(i).getAtributoHabilidad().charAt(0) + ") "
                );
            abLay.addView(inicial);

            //crearle un Label con la habilidad
            TextView habilidad = new TextView(this);
            habilidad.setText(habilidades.get(i).getNombreHabilidad());
            abLay.addView(habilidad);

            //crearle un EditText vacío pa los puntos
            EditText puntosHabilidad = new EditText(this);
            int id = basicIDHabilidades + i;
            habilidades.get(i).setIdView(id);
            puntosHabilidad.setId(id);
            puntosHabilidad.setLayoutParams(paramsLL);
            abLay.addView(puntosHabilidad);

            layoutHabilidades.addView(abLay);

        }
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