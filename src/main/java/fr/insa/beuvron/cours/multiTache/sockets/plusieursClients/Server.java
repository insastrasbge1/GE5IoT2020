/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.beuvron.cours.multiTache.sockets.plusieursClients;

import fr.insa.beuvron.cours.multiTache.sockets.ConsoleFdB;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author francois
 */
public class Server extends Thread {

    public ArrayList<Sender> lesClients = new ArrayList<>();

    @Override
    public void run() {
        Inet4Address ipAdress = (Inet4Address) Inet4Address.getLoopbackAddress();
        try (ServerSocket serv = new ServerSocket(0, 1, ipAdress)) {
            System.out.println("server ip : " + serv.getInetAddress());
            System.out.println("server port : " + serv.getLocalPort());
            while (true) {
                Socket sockOut = serv.accept();
                synchronized (this.lesClients) {
                    Sender s = new Sender(sockOut);
                    this.lesClients.add(s);
                    s.start();
                }

            }
        } catch (IOException ex) {
            throw new Error(ex);
        }
    }

    public void sendToAll(String mess) {
        synchronized (this.lesClients) {
            for (Sender s : this.lesClients) {
                s.addToSend(mess);
            }
        }
    }

//                String mess = "PASFIN";
//                while (!mess.equals("FIN")) {
//                    mess = ConsoleFdB.entreeString("message : ");
//                    if (!mess.equals("FIN")) {
//                        out.write(mess + "\n");
//                        out.flush();
//                    }
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public class Sender extends Thread {

        private Socket sockOut;

        private LinkedList<String> toSend;

        public Sender(Socket sockOut) {
            this.sockOut = sockOut;
            this.toSend = new LinkedList<>();
        }

        public synchronized void addToSend(String mess) {
            this.toSend.add(mess);
            this.notify();
        }

        @Override
        public void run() {
            try (Writer out = new OutputStreamWriter(this.sockOut.getOutputStream(),
                    Charset.forName("UTF8"))) {
                while (true) {
                    synchronized (this) {
                        String unMess;
                        while ((unMess = this.toSend.poll()) != null) {
                            out.append(unMess + "\n");
                            out.flush();
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException ex) {
                            throw new Error("unexpected interrupt ", ex);
                        }
                    }
                }
            } catch (IOException ex) {
                throw new Error(ex);
            }
        }

    }

    public static void main(String[] args) {
        Server serv = new Server();
        serv.start();

        String mess = "PASFIN";
        while (!mess.equals("FIN")) {
            mess = ConsoleFdB.entreeString("message : ");
            if (!mess.equals("FIN")) {
                serv.sendToAll(mess);
            }
        }
    }

}
