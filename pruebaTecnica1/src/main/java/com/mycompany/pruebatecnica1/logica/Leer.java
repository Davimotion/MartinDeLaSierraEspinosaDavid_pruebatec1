package com.mycompany.pruebatecnica1.logica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Leer {

    public static void imprimirLista(List listaEmpleados) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println(listaEmpleados.get(i));
        }
    }

    public static void buscarCargo(List listaEmpleados, Scanner sc) {
        List<Empleado> empleados = listaEmpleados;
        System.out.println("Cargo a buscar:");
        String cargo = sc.nextLine();
        List<Empleado> empleadosPorCargo = empleados.stream()
                .filter(e -> e.getCargo().equalsIgnoreCase(cargo))
                .collect(Collectors.toList());
        if (empleadosPorCargo.size() == 0) {
            System.out.println("No se encuentran empleados con el cargo: " + cargo);
        }

        empleadosPorCargo.forEach(System.out::println);
    }

    public static Empleado buscarEmpleado(Controladora control, Scanner sc) {
        boolean entradaValida = false;
        Empleado empEdit = new Empleado();
        while (!entradaValida) {
            try {
                int empId = Integer.parseInt(sc.nextLine());
                System.out.println("");
                empEdit = control.buscarEmpleado(empId);
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor introduzca un valor numérico válido.");
            }
        }
        return empEdit;
    }

    public static Empleado editarEmpleado(Empleado empEdit, Scanner sc) {
        System.out.println("introduzca el nombre del empleado");
        empEdit.setNombre(sc.nextLine());
        System.out.println("introduzca el apellido del empleado");
        empEdit.setApellido(sc.nextLine());
        System.out.println("introduzca el cargo del empleado");
        empEdit.setCargo(sc.nextLine());
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.println("introduzca el salario del empleado");
            try {
                empEdit.setSalario(Double.parseDouble(sc.nextLine()));
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Por favor introduzca un valor numérico.");
            }
        }
        boolean entradaValida2 = false;
        while (!entradaValida2) {
            System.out.println("introduzca el año de la contratacion(yyyy-MM-dd)");
            String inputfecha = sc.nextLine();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            try {
                LocalDate fecha = LocalDate.parse(inputfecha, formato);
                empEdit.setFechaInicio(fecha);
                entradaValida2 = true;
            } catch (Exception e) {
                System.out.println("Error al introducir la fecha, asegurese de que está en formato yyyy-MM-dd");
            }
        }
        return empEdit;
    }

    public static void borrarEmpleado(Controladora control, int empDel, Scanner sc) {
        control.eliminarEmpleado(empDel);

    }
}
