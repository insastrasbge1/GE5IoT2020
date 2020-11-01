/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.sockets.sansThreads;

import fr.insa.beuvron.cours.multiTache.sockets.ConsoleFdB;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class Server {

    public static void go() {
        Inet4Address ipAdress = (Inet4Address) Inet4Address.getLoopbackAddress();
        try (ServerSocket serv = new ServerSocket(0, 1, ipAdress)) {
            System.out.println("server ip : " + serv.getInetAddress());
            System.out.println("server port : " + serv.getLocalPort());
            Socket sockOut = serv.accept();
            try (Writer out = new OutputStreamWriter(sockOut.getOutputStream(),
                    Charset.forName("UTF8"))) {
                String mess = "PASFIN";
                while (!mess.equals("FIN")) {
                    mess = ConsoleFdB.entreeString("message : ");
                    if (!mess.equals("FIN")) {
                        out.write(mess + "\n");
                        out.flush();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        go();
    }

}
