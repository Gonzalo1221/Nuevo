/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Ejecutador;

import Model.Persona;
import View.Personas;
import controller.Controller;

/**
 *
 * @author SENA
 */
public class Ejecutar {

    public static void main(String[] args) {
        Personas ejecutar = new Personas();
        Controller cp = new Controller(ejecutar);
    }
}