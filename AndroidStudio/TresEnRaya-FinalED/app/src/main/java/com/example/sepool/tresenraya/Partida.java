package com.example.sepool.tresenraya;

import java.util.Random;

public class Partida {

    public final int dificultad;
    public int jugador;
    private int[] casillasMarcadas;
    private final int[][] combinaciones = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    //Establece dificultad y inicia array con valor 0
    public Partida(int dificultad) {

        this.dificultad = dificultad;
        jugador = 1;
        casillasMarcadas = new int[9];
        for (int i = 0; i < 9; i++) {

            casillasMarcadas[i] = 0;
        }

    }

    //Método que comprueba y devuelve el valor de la casilla
    public boolean comprobarCasilla(int casilla) {

        if (casillasMarcadas[casilla] != 0) {
            return false;
        } else {
            casillasMarcadas[casilla] = jugador;
            return true;
        }

    }

    public int proyectoGanar(int jugadorTurno) {

        int casillaClave = -1;
        int cont = 0;
        for (int i = 0; i < combinaciones.length; i++) {
            for (int pos : combinaciones[i]) {
                if (casillasMarcadas[pos] == jugadorTurno) cont++;
                if (casillasMarcadas[pos] == 0) casillaClave = pos;

            }
            if (cont == 2 && casillaClave != -1) return casillaClave;
            casillaClave = -1;
            cont = 0;
        }
        return -1;

    }


    //Para jugar contra la máquina generamos una posición aleatoria de la casilla
    public int maquina() {

        int casilla;
        casilla = proyectoGanar(2);
        if (casilla != -1) return casilla;
        if (dificultad > 0) {
            casilla = proyectoGanar(1);
            if (casilla != -1) return casilla;
        }
        if (dificultad == 2) {
            if (casillasMarcadas[0] == 0) return 0;
            if (casillasMarcadas[2] == 0) return 2;
            if (casillasMarcadas[6] == 0) return 6;
            if (casillasMarcadas[8] == 0) return 8;
        }

        Random casillaAleatoria = new Random();
        casilla = casillaAleatoria.nextInt(9);
        return casilla;
    }

    //El jugador por defecto es uno, con esto conseguimos que el jugador cambie a dos, si el jugador es mayor de 2 vuelve a ser 1.
    //Si en el array hay algún 0 no puede haber empate
    //Gana J1=1
    //Gana J2=2
    //Empate =1
    //Nada =0
    public int turno() {

        boolean empate = true;
        boolean ultimoMovimiento = true;
        for (int i = 0; i < combinaciones.length; i++) {
            for (int pos : combinaciones[i]) {
                if (casillasMarcadas[pos] != jugador) ultimoMovimiento = false;
                if (casillasMarcadas[pos] == 0) {
                    empate = false;
                }
            }
            if (ultimoMovimiento) return jugador;
            ultimoMovimiento = true;
        }
        if (empate) {
            return 3;
        }

        jugador++;
        if (jugador > 2) {
            jugador = 1;
        }
        return 0;
    }

}
