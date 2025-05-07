package ejercicio2;


import ejercicio2.database.EnDiscoRegistrarEmpleado;
import ejercicio2.database.PorMailEnviarSaludo;
import ejercicio2.model.AdministrarEmpleados;
import ejercicio2.model.Empleado;
import ejercicio2.model.EnviarSaludo;
import ejercicio2.model.RegistrarEmpleados;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmpleadoTest {
    @Test
    void testRegistrar() {

        Empleado empleado = new Empleado("Victoria", " Blanco", LocalDate.now(), "victoriablanco718@gmail.com");
        EnviarSaludo enviarSaludo = new PorMailEnviarSaludo();
        RegistrarEmpleados registrarEmpleados = new EnDiscoRegistrarEmpleado();
        AdministrarEmpleados administrarEmpleados = new AdministrarEmpleados(enviarSaludo, registrarEmpleados);
        administrarEmpleados.registrar(empleado);
        //assertTrue(administrarEmpleados.getEmpleados().contains(empleado));

    }


}
