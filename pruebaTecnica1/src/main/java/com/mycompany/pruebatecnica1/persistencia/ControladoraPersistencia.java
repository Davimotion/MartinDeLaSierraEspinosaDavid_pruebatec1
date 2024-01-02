
package com.mycompany.pruebatecnica1.persistencia;

import com.mycompany.pruebatecnica1.logica.Empleado;
import com.mycompany.pruebatecnica1.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    EmpleadoJpaController empleJpa = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado emp){
        empleJpa.create(emp);
    }

    public List<Empleado> traerEmpleados() {
        return empleJpa.findEmpleadoEntities();
    }

    public Empleado buscarEmpleado(int empId) {
        return empleJpa.findEmpleado(empId);
    }

    public void editarEmpleado(Empleado empEdit) {
        try {
            empleJpa.edit(empEdit);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEmpleado(int empDel) {
        try {
            empleJpa.destroy(empDel);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
