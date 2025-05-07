package ejercicio2.main;

import ejercicio2.database.EnDiscoRegistrarEmpleado;
import ejercicio2.database.PorMailEnviarSaludo;
import ejercicio2.model.AdministrarEmpleados;
import ejercicio2.model.Empleado;
import ejercicio2.model.EnviarSaludo;
import ejercicio2.model.RegistrarEmpleados;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Victoria", " Blanco", LocalDate.now(), "victoriablanco718@gmail.com"/*"your.recipient@email.com"*/);
        EnviarSaludo enviarSaludo = new PorMailEnviarSaludo();
        RegistrarEmpleados registrarEmpleados = new EnDiscoRegistrarEmpleado();
        AdministrarEmpleados administrarEmpleados = new AdministrarEmpleados(enviarSaludo, registrarEmpleados);
        administrarEmpleados.registrar(empleado);
        administrarEmpleados.saludarPorCumple();
    }
}
