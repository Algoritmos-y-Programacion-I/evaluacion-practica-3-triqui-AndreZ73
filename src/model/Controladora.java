package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    public boolean jugadaHumano(int fila, int columna) {
        if(tableroTresEnRaya[fila-1][columna-1].equals(" ")){
            do {
            } while (!tableroTresEnRaya[fila-1][columna-1].equals(" "));
            tableroTresEnRaya[fila-1][columna-1] = "O";
            return true;
        }
        return false;
    }

    public boolean verificarSiHumanoGana(){
        if(tableroTresEnRaya[0][0].equals("O") && tableroTresEnRaya[0][1].equals("O") && tableroTresEnRaya[0][2].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[1][0].equals("O") && tableroTresEnRaya[1][1].equals("O") && tableroTresEnRaya[1][2].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[2][0].equals("O") && tableroTresEnRaya[2][1].equals("O") && tableroTresEnRaya[2][2].equals("O")) {
            return true;
        }
        
        if(tableroTresEnRaya[0][0].equals("O") && tableroTresEnRaya[1][0].equals("O") && tableroTresEnRaya[2][0].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[0][1].equals("O") && tableroTresEnRaya[1][1].equals("O") && tableroTresEnRaya[2][1].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[0][2].equals("O") && tableroTresEnRaya[1][2].equals("O") && tableroTresEnRaya[2][2].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[0][0].equals("O") && tableroTresEnRaya[1][1].equals("O") && tableroTresEnRaya[2][2].equals("O")) {
            return true;
        }

        if(tableroTresEnRaya[0][2].equals("O") && tableroTresEnRaya[1][1].equals("O") && tableroTresEnRaya[2][0].equals("O")) {
            return true;
        }
        return false;
    }
    
    public boolean verificarSiMaquinaGana(){
        if(tableroTresEnRaya[0][0].equals("X") && tableroTresEnRaya[0][1].equals("X") && tableroTresEnRaya[0][2].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[1][0].equals("X") && tableroTresEnRaya[1][1].equals("X") && tableroTresEnRaya[1][2].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[2][0].equals("X") && tableroTresEnRaya[2][1].equals("X") && tableroTresEnRaya[2][2].equals("X")) {
            return true;
        }
        
        if(tableroTresEnRaya[0][0].equals("X") && tableroTresEnRaya[1][0].equals("X") && tableroTresEnRaya[2][0].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[0][1].equals("X") && tableroTresEnRaya[1][1].equals("X") && tableroTresEnRaya[2][1].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[0][2].equals("X") && tableroTresEnRaya[1][2].equals("X") && tableroTresEnRaya[2][2].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[0][0].equals("X") && tableroTresEnRaya[1][1].equals("X") && tableroTresEnRaya[2][2].equals("X")) {
            return true;
        }

        if(tableroTresEnRaya[0][2].equals("X") && tableroTresEnRaya[1][1].equals("X") && tableroTresEnRaya[2][0].equals("X")) {
            return true;
        }
        return false;
    }
}