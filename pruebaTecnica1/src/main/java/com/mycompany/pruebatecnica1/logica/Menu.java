package com.mycompany.pruebatecnica1.logica;

import static com.mycompany.pruebatecnica1.logica.Crear.crear;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public static boolean menu(boolean t, Scanner sc) {
        Controladora control = new Controladora();
        System.out.println("Bienvenido a la base de datos");
        System.out.println("Seleccione una accion intruduciendo un número:");
        System.out.println("1: Crear.    2: Leer.    3: Actualizar.    4: Borrar.    5: Buscar por cargo.     fin: Cerrar la aplicacion ");
        String caso;
        caso = sc.nextLine();
        switch (caso) {
            case "1" -> {
                System.out.println("");
                System.out.println("");
                System.out.println("Se crea una entrada en base de datos EMPLEADOS con datos dados por el usuario.");
                System.out.println("");
                System.out.println("");
                Empleado emp = new Empleado();
                crear(emp, sc);
                System.out.println("Se crea el empleado:");
                System.out.println(emp);
                control.crearEmpleado(emp);
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            }
            case "2" -> {
                System.out.println("");
                System.out.println("");
                System.out.println("Se lee la base de datos EMPLEADOS y se muestra por consola.");
                System.out.println("");
                List<Empleado> listaEmpleados = control.traerEmpleados();
                Leer.imprimirLista(listaEmpleados);
                break;
            }
            case "3" -> {
                System.out.println("");
                System.out.println("");
                System.out.println("Introduzca un cargo para actualizar su entrada en la basede datos EMPLEADOS.");
                Empleado empEdit = Leer.buscarEmpleado(control, sc);
                System.out.println("El empleado a editar es: ");
                System.out.println(empEdit);
                empEdit = Leer.editarEmpleado(empEdit, sc);
                control.editarEmpleado(empEdit);
                break;
            }
            case "4" -> {
                System.out.println("");
                System.out.println("");
                System.out.println("introduzca un Id para eliminar de us base de datos EMPLEADOS.");
                Empleado empDel = Leer.buscarEmpleado(control, sc);
                System.out.println("El empleado a borrar es: ");
                System.out.println(empDel);
                Leer.borrarEmpleado(control, empDel.getId(), sc);
                System.out.println("El empleado ha sido borrado.");
                System.out.println("");
                break;
            }
            case "5" -> {
                System.out.println("");
                System.out.println("");
                List<Empleado> listaEmpleados = control.traerEmpleados();
                System.out.println("Escribe un cargo para desplegar una lista de empleados con ese cargo");
                Leer.buscarCargo(listaEmpleados, sc);
                break;
            }
            case "fin" -> {
                System.out.println("");
                System.out.println("");
                System.out.println("Fin del programa");
                t = true;
                break;
            }
            default -> {
                System.out.println("");
                System.out.println("");
                System.out.println("Introduzca un valor válido");
                System.out.println("");
                System.out.println("");
                break;
            }
        }
        return t;
    }
}
