
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package industriaemp;

/**
 *
 * @author cdavi
 */

import java.util.Random;
import java.util.Scanner;

public class IndustriaEmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // codigo para ingresar el nombre de las empresas y generar aleatoriamente los montos
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); 
        
        String[] empresas = new String[15];
        int [][] montos = new int[15][5];  
        int [] totalmontos = new int[15];  
        
        // Ingresar nombres de las empresas
        System.out.println("Ingrese los nombres de las 15 empresas a ejemplificar :");
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            System.out.print("Candidato " + (i + 1) + ": ");
            empresas[i] = scanner.nextLine();
        }
        
        // Simulacion de los montos de  en 5 años
        for (int año = 0; año < 5; año++){
            for (int afiliado = 0; afiliado < 50; afiliado++){
                int monto = random.nextInt(10);
                montos[monto][año]++; 
            }
        }
        boolean eleccion=true;
        do{
                    // Mostrar la tabla de votos por cada candidato y ronda
            System.out.println("Tabla de Votos:");
            System.out.printf("%-25s", "Candidato");
            for (int ronda = 1; ronda <= 5; ronda++) {
                System.out.printf("%-10s", "Ronda " + ronda);
            }
            System.out.println();

            for (int candidato = 0; candidato < 10; candidato++) {
                System.out.printf("%-25s", candidatos[candidato]);
                for (int ronda = 0; ronda < 5; ronda++) {
                    System.out.printf("%-10d", votos[candidato][ronda]);
                }
                System.out.println();
            }

            // Calcular el candidato ganador y el que obtuvo menos votos
            for (int candidato = 0; candidato < 10; candidato++) {
                for (int ronda = 0; ronda < 5; ronda++) {
                    totalVotos[candidato] += votos[candidato][ronda];
                }
            }

            // Encontrar el ganador y el que obtuvo menos votos
            int ganador = 0;
            int menosVotos = 0;
            for (int candidato = 1; candidato < 10; candidato++) {
                if (totalVotos[candidato] > totalVotos[ganador]) {
                    ganador = candidato;
                }
                if (totalVotos[candidato] < totalVotos[menosVotos]) {
                    menosVotos = candidato;
                }
            }

            // Mostrar resultados
            System.out.println("\nEl candidato ganador es: " + candidatos[ganador]);
            System.out.println("El candidato con menos votos es: " + candidatos[menosVotos]);  
            System.out.println();
            System.out.println("Se repiten las elecciones?");
            String repetir = scanner.nextLine();
            eleccion= repetir.equalsIgnoreCase("Si") || repetir.equalsIgnoreCase("S") || repetir.equalsIgnoreCase("si");
        } while (eleccion);
        
        System.out.println("La votacion ha finalizado.");
        System.out.println("Creditos: Favio, Wilber, Lety, David.");

        
    }
 }
