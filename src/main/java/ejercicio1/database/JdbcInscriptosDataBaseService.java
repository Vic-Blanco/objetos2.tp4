package ejercicio1.database;

import ejercicio1.model.InscriptosDataBaseService;
import ejercicio1.model.Participante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JdbcInscriptosDataBaseService implements InscriptosDataBaseService {

    private final Conn conn;

    public JdbcInscriptosDataBaseService(String conn, String user, String pwd) {
        this.conn = new Conn(conn, user, pwd);
    }


    @Override
    public void createParticipante(String nombre, String telefono, String region) {
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

    @Override
    public List<Participante> participantes() {
        String sql = "SELECT * FROM participantes";
        try (Connection conn = this.conn.open();
             var stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {
            List<Participante> participantes = new ArrayList<>();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String region = rs.getString("region");
                participantes.add(new Participante(nombre, telefono, region));
            }
            return participantes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
