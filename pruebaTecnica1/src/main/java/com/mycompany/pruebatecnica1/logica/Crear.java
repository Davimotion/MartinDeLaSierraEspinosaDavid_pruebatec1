package com.mycompany.pruebatecnica1.logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Crear {

    public static Empleado crear(Empleado emp, Scanner sc) {
        crearNombre(emp, sc);
        crearApellido(emp, sc);
        crearCargo(emp, sc);
        crearSalario(emp, sc);
        crearFecha(emp, sc);
        return emp;
    }

    private static void crearNombre(Empleado emp, Scanner sc) {
        System.out.println("introduzca el nombre del empleado");
        emp.setNombre(sc.nextLine());
    }

    private static void crearApellido(Empleado emp, Scanner sc) {
        System.out.println("introduzca el apellido del empleado");
        emp.setApellido(sc.nextLine());
    }

    private static void crearCargo(Empleado emp, Scanner sc) {
        System.out.println("introduzca el cargo del empleado");
        emp.setCargo(sc.nextLine());
    }

    private static void crearSalario(Empleado emp, Scanner sc) {
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("introduzca el salario del empleado");
            try {
                emp.setSalario(Double.parseDouble(sc.nextLine()));
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor introduzca un valor numérico.");
            }
        }
    }

    private static void crearFecha(Empleado emp, Scanner sc) {
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("introduzca el año de la contratacion(yyyy-MM-dd)");
            String inputfecha = sc.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                LocalDate fecha = LocalDate.parse(inputfecha, formato);
                emp.setFechaInicio(fecha);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Error al introducir la fecha, asegurese de que está en formato yyyy-MM-dd");

            }
        }

    }
}
