package server.main;

import java.io.IOException;
import server.datenbank.Database;
/**
 *
 * @author lukas
 */
public class Main {
    public final static String VERSION = "0.1.7";
    public final static String PWD = "Hallo123";
    
    public static boolean WATER = false;
    public static int ID = 0;
    public static String STOP = null;
    
    public static String ERROR = null;
    
    public static void main(String[] args) throws IOException, Exception {
    
        new Thread(new server.server.Server(1111)).start();
        new Thread(new server.udp.UDPServer(5555)).start();
    }
}
