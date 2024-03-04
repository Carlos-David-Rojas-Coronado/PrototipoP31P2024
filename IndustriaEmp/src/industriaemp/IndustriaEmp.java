
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
        int [][] montos = new int[15][4];  
        int [] totalmontos = new int[15];  
        
        // Ingresar nombres de las empresas
        System.out.println("Ingrese los nombres de las 15 empresas a ejemplificar :");
        System.out.println("");
        for (int i = 0; i < 10; i++) {
            System.out.print("Candidato " + (i + 1) + ": ");
            empresas[i] = scanner.nextLine();
        }
        
        // Simulacion de los montos de  en 4 años
        for (int año = 0; año < 4; año++){
            for (int afiliado = 0; afiliado < 50; afiliado++){
                int monto = random.nextInt(10);
                montos[monto][año]++; 
            }
        }
        boolean eleccion=true;
        do{
             // Mostrar la tabla de votos por cada monto y año
            System.out.println("Tabla de montos:");
            System.out.printf("%-25s", "Empresa");
            for (int año = 1; año <= 4; año++) {
                System.out.printf("%-10s", "Año " + año);
            }
            System.out.println();

            for (int empresa = 0; empresa < 10; empresa++) {
                System.out.printf("%-25s", empresas[empresa]);
                for (int año = 0; año < 4; año++) {
                    System.out.printf("%-10d", montos[empresa][año]);
                }
                System.out.println();
            }

            // Calcular la empresa mayor y la menor en montos
            for (int empresa = 0; empresa < 15; empresa++) {
                for (int año = 0; año < 4; año++) {
                    totalmontos[empresa] += montos[empresa][año];
                }
            }

            // Encontrar al mayoror y el menor en montos
            int mayor = 0;
            int menorMontos = 0;
            for (int empresa = 1; empresa < 15; empresa++) {
                if (totalmontos[empresa] > totalmontos[empresa]) {
                    mayor = empresa;
                }
                if (totalmontos[empresa] < totalmontos[menorMontos]) {
                    menorMontos = empresa;
                }
            }

            // Mostrar resultados
            System.out.println("\nLa Empresa con Mayor monto es: " + empresas[mayor]);
            System.out.println("La Epresa con menor montos es: " + empresas[menorMontos]);  
            System.out.println();
            System.out.println("Se repiten las estadisticas?");
            String repetir = scanner.nextLine();
            eleccion= repetir.equalsIgnoreCase("Si") || repetir.equalsIgnoreCase("S") || repetir.equalsIgnoreCase("si");
        } while (eleccion);
        
        System.out.println("La votacion ha finalizado.");
        System.out.println("Creditos: Carlos David Rojas Coronado.");

        
    }
 }
