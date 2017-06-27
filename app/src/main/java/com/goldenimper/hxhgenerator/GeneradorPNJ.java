package com.goldenimper.hxhgenerator;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
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
        TableLayout layoutHabilidades = findViewById(R.id.puntosHabilidadLayout);
        TableLayout.LayoutParams paramsTL = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams paramsTR = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT, 1);

        for (int i = 0; i < habilidades.size(); i++) {

            TableRow abLay = new TableRow(this);
            abLay.setLayoutParams(paramsTR);

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
            puntosHabilidad.setInputType(InputType.TYPE_CLASS_NUMBER);
            puntosHabilidad.setLayoutParams(paramsTR);
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