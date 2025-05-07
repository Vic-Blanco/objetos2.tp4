package ejercicio2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String mail;

    public Empleado(String nombre, String apellido, LocalDate fechaNacimiento, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.mail = mail;
    }

    public void registrarse(RegistrarEmpleados registrarEmpleados) {
        if (registrarEmpleados.getEmpleados().stream().anyMatch(empleado -> empleado.mail.equals(this.mail))) {
            throw new RuntimeException("El empleado ya se encuentra registrado");
        }
        StringBuilder string = empleadoToString();
        registrarEmpleados.registrar(string.toString());
    }

    private StringBuilder empleadoToString() {
        StringBuilder string = new StringBuilder();
        String fechaFormateada = fechaNacimiento.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        string.append(nombre).append(",").append(apellido).append(", ").append(fechaFormateada).append(",").append(mail).append("\n");
        return string;
    }

    public boolean esMiCumple() {
        if (LocalDate.now().getDayOfMonth() == fechaNacimiento.getDayOfMonth() && LocalDate.now().getMonthValue() == fechaNacimiento.getMonthValue()) {
            return true;
        }
        return false;
    }

    public void saludarme(EnviarSaludo saludo) {
        saludo.enviar(this.mail, "Feliz Cumpleaños", "Feliz Cumpleaños " + this.nombre);
    }

}
