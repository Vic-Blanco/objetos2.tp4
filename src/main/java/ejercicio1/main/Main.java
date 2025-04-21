package ejercicio1.main;

import ejercicio1.database.JdbcInscriptosDataBaseService;
import ejercicio1.model.DefaultInscripcion;
import ejercicio1.model.Inscripcion;
import ejercicio1.model.InscriptosDataBaseService;
import ejercicio1.ui.AgregarParticipante;


public class Main {

    //Conexion para DB cliente / servidor
    //public static final String CONNSTR = "jdbc:derby://localhost:1527/ventas;create=true";
    //Conexion para DB en memoria
    public static final String CONNSTR = "jdbc:derby:memory:inscripcion;create=true";
    public static final String USERNAME = "app";
    public static final String PWD = "app";

    public static void main(String[] args) {
        inicializarDatabase();
        launchApplication();
    }

    private static void launchApplication() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    InscriptosDataBaseService registroParticipantes =
                            new JdbcInscriptosDataBaseService(CONNSTR, USERNAME, PWD);
                    Inscripcion inscriptos =
                            new DefaultInscripcion(registroParticipantes);
                    new AgregarParticipante(inscriptos).setVisible(true);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private static void inicializarDatabase() {
        var jdbc = new SetUpDataBase(CONNSTR,
                USERNAME,
                PWD);
        jdbc.inicializar();
    }
}