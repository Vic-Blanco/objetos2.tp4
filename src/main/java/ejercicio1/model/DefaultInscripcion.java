package ejercicio1.model;

import java.util.List;

public class DefaultInscripcion implements Inscripcion {

    private final InscriptosDataBaseService inscriptosDataBaseService;

    public DefaultInscripcion(InscriptosDataBaseService inscriptosDataBaseService) {
        this.inscriptosDataBaseService = inscriptosDataBaseService;
    }

    @Override
    public void nuevoParticipante(String nombre, String telefono, String region) {//dudas

        Participante participante = new Participante(nombre, telefono, region);
        inscriptosDataBaseService.createParticipante(
                participante.getNombre(),
                participante.getTelefono(),
                participante.getRegion()
        );
    }

    @Override
    public List<Participante> participantes() {
        List<Participante> participantes = inscriptosDataBaseService.participantes();
        return participantes;
    }
}
