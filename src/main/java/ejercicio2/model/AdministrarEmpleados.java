package ejercicio2.model;

import java.util.List;

public class AdministrarEmpleados {
    private EnviarSaludo saludo;
    private RegistrarEmpleados registrar;

    public AdministrarEmpleados(EnviarSaludo saludo, RegistrarEmpleados registrarEmpleados) {
        this.saludo = saludo;
        this.registrar = registrarEmpleados;
    }

    public void registrar(Empleado empleado) {
        empleado.registrarse(registrar);

    }

    public void saludarPorCumple() {
        List<Empleado> Empleados = registrar.getEmpleados();
        for (Empleado empleado : Empleados) {
            if (empleado.esMiCumple()) {
                empleado.saludarme(saludo);
            }
        }
    }

    public List<Empleado> getEmpleados() {
        return registrar.getEmpleados();
    }
}
