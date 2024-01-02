
package com.mycompany.pruebatecnica1.logica;

import com.mycompany.pruebatecnica1.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearEmpleado(Empleado emp){
        controlPersis.crearEmpleado(emp);
    }

    public List<Empleado> traerEmpleados() {
       return controlPersis.traerEmpleados();
    }

    public Empleado buscarEmpleado(int empId) {
        return controlPersis.buscarEmpleado(empId);
    }

    void editarEmpleado(Empleado empEdit) {
        controlPersis.editarEmpleado(empEdit);
    }

    void eliminarEmpleado(int empDel) {
        controlPersis.eliminarEmpleado(empDel);
    }

}
