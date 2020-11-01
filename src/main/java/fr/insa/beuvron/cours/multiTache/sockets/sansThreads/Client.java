/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.sockets.sansThreads;

import fr.insa.beuvron.cours.multiTache.sockets.ConsoleFdB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author francois
 */
public class Client {

    public static void go() {
        String ip = ConsoleFdB.entreeString("adresse IP du serveur : ");
        int port = ConsoleFdB.entreeInt("port : ");
        try (Socket sockIn = new Socket(ip, port)) {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(sockIn.getInputStream(),
                            Charset.forName("UTF8")))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("recu " + line);
                }
                System.out.println("fin normale");

            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {
        go();
    }
    
}
