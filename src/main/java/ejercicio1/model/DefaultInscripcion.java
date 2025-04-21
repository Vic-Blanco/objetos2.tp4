package ejercicio1.model;

public class DefaultInscripcion implements Inscripcion{

    private  InscriptosDataBaseService inscriptosDataBaseService;
    public DefaultInscripcion(InscriptosDataBaseService inscriptosDataBaseService) {
        this.inscriptosDataBaseService = inscriptosDataBaseService;
    }

    @Override
    public void nuevoParticipante(Participante participante) {

        inscriptosDataBaseService.nuevoParticipante(
                participante.getNombre(),
                participante.getTelefono(),
                participante.getRegion()
        );
    }
}
