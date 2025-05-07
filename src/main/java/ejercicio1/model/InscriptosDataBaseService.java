package ejercicio1.model;

import java.util.List;

public interface InscriptosDataBaseService {

    void createParticipante(String nombre, String telefono, String region);

    List<Participante> participantes();
}
