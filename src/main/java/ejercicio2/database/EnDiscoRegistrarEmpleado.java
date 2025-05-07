package ejercicio2.database;

import ejercicio2.model.Empleado;
import ejercicio2.model.RegistrarEmpleados;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EnDiscoRegistrarEmpleado implements RegistrarEmpleados {

    public EnDiscoRegistrarEmpleado() {
       /* try {
            // Sobrescribe el archivo con contenido vacío (lo deja en blanco)
            Files.write(Paths.get("D:/Documents/registroEmpleados.txt"), new byte[0], StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo limpiar el archivo al iniciar: " + e.getMessage());
        }*/
    }

    @Override
    public void registrar(String registro) {

        try {
            // Escribe el registro en el archivo
            Files.write(Paths.get("D:/Documents/registroEmpleados.txt"), registro.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(" Error al registrar el pedido: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            Files.lines(Paths.get("D:/Documents/registroEmpleados.txt")).forEach(line -> {
                String[] partes = line.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                String fechaCumple = partes[2].trim();
                String email = partes[3];

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate fechaNacimiento = LocalDate.parse(fechaCumple, formatter);

                empleados.add(new Empleado(nombre, apellido, fechaNacimiento, email));
            });
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
        return empleados;
    }
}