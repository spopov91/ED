package com.example.sepool.tresenraya;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private int jugadores;
    private int[] casillas;
    private Partida partida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicia array casillas que identifica cada casilla y lo almacena
        casillas = new int[9];
        casillas[0] = R.id.a1;
        casillas[1] = R.id.a2;
        casillas[2] = R.id.a3;
        casillas[3] = R.id.b1;
        casillas[4] = R.id.b2;
        casillas[5] = R.id.b3;
        casillas[6] = R.id.c1;
        casillas[7] = R.id.c2;
        casillas[8] = R.id.c3;
    }

    //Dibuja las casillas
    public void jugar(View vista) {

        ImageView imagen;
        //Resetea las casillas
        for (int cadaCasilla : casillas) {
            imagen = (ImageView) findViewById((cadaCasilla));
            imagen.setImageResource(R.drawable.casilla);
        }
        //Variable número de jugadores inicializado a un jugador
        jugadores = 1;
        if (vista.getId() == R.id.dosJugadores) {
            jugadores = 2;

        }
        //Agrupamos los botones de dificultad
        RadioGroup menuDificultad = (RadioGroup) findViewById(R.id.menuDif);
        int id = menuDificultad.getCheckedRadioButtonId();
        int dificultad = 0;
        if (id == R.id.normal) {
            dificultad = 1;
        } else if (id == R.id.imposible) {
            dificultad = 2;

        }
        //Llamamos al constructor y comienza la partida
        partida = new Partida(dificultad);
        //Desactivamos botones después de haber seleccionado una opción
        ((Button) findViewById(R.id.unJugador)).setEnabled(false);
        ((RadioGroup) findViewById(R.id.menuDif)).setAlpha(0);
        ((Button) findViewById(R.id.dosJugadores)).setEnabled(false);


    }

    //Recorremos array hasta la posición de la casilla que se ha presionado(Detectar que casilla se pulsa)
    public void toque(View pulsado) {

        //Si entra en el if no sigue con la partida por que no se ha pulsado ningún botón por lo tanto es null
        if (partida == null) {
            return;
        }
        int casilla = 0;
        for (int i = 0; i < 9; i++) {
            if (casillas[i] == pulsado.getId()) {
                casilla = i;
                break;

            }

        }
        if (partida.comprobarCasilla(casilla) == false) {
            return;
        }
        //llamamos método marca y pasamos la casilla
        marca(casilla);
        int resultado = partida.turno();
        if (resultado > 0) {

            finalizado(resultado);
            return;
        }
        //guardamos en casilla el número aleatorio generado por la máquina, volvemos a llamar el método marca y turnamos al jugador
        if (jugadores == 1) {
            casilla = partida.maquina();
            while (partida.comprobarCasilla(casilla) != true) {
                casilla = partida.maquina();
            }
            marca(casilla);

            resultado = partida.turno();
            if (resultado > 0) {
                finalizado(resultado);
            }
        }

    }

    private void finalizado(int resultado) {

        String mensaje;
        if (resultado == 1) {
            mensaje = "Gana jugador uno";

        } else if (resultado == 2) {
            mensaje = "Gana jugador dos";

        } else mensaje = "Ha habido un empate";

        Toast toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        partida = null;
        ((Button) findViewById(R.id.unJugador)).setEnabled(true);
        ((RadioGroup) findViewById(R.id.menuDif)).setAlpha(1);
        ((Button) findViewById(R.id.dosJugadores)).setEnabled(true);

    }

    //Marca la casilla con un círculo o cruz
    private void marca(int casilla) {

        ImageView imagen;
        //Identifica la casilla pulsada
        imagen = (ImageView) findViewById(casillas[casilla]);
        //Si es jugador uno es círculo, si es jugador 2 es cruz
        if (partida.jugador == 1) {
            imagen.setImageResource(R.drawable.circulo);
        } else {

            imagen.setImageResource(R.drawable.aspa);
        }


    }

}
