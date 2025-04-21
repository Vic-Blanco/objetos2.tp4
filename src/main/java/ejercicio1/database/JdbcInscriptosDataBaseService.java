package ejercicio1.database;

import ejercicio1.model.InscriptosDataBaseService;

import java.sql.Connection;

public class JdbcInscriptosDataBaseService implements InscriptosDataBaseService {

    private final Conn conn;

    public JdbcInscriptosDataBaseService(String conn, String user, String pwd) {
        this.conn = new Conn(conn, user, pwd);
    }


    @Override
    public void nuevoParticipante(String nombre, String telefono, String region) {
        String sql = "INSERT INTO participantes (nombre, telefono, region) VALUES (?, ?, ?)";
        try (Connection conn = this.conn.open();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, region);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*@Override
    public List<ParticipanteData> participantes() {
        return List.of();
    }*/
}
