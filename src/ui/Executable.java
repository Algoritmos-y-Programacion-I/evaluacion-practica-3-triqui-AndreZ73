package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {
        System.out.println("Ingrese la posición de su jugada. Primero la fila: (1,2,3)");
        int fila = reader.nextInt();
        reader.nextLine();

        System.out.println("Ingrese la posición de su jugada. Ahora la columna: (1,2,3)");
        int columna = reader.nextInt();
        reader.nextLine();

        while(!cont.jugadaHumano(fila, columna)) {
            System.out.println("Error, posición ocupada: Ingrese nuevamente la fila: (1,2,3)");
            fila = reader.nextInt();
            reader.nextLine();
            
            System.out.println("Ahora la columna: (1,2,3)");
            columna = reader.nextInt();
            reader.nextLine();
        }

        imprimirTablero();
        
        // Implementación de jugada de humano
    }

    private void validarGanador() {
        if (cont.verificarSiHumanoGana() && cont.verificarSiMaquinaGana()) {
            System.out.println("Han empatado!");

        }else if(cont.verificarSiHumanoGana()) {

        System.out.println("Ha ganado el humano!");

        } else if(cont.verificarSiMaquinaGana()) {
            System.out.println("Ha ganado la máquina!");

        } else {
        System.out.println("Nadie ha ganado!");
        }
    }
}