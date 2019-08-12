import java.io.*;
import java.net.*;


/**
 * ServidorUDP
 */
class ServidorUDP {
    public static void main(String[] args) throws IOException, SocketException {
        
        int porta = 9000;
        int qtdCon = 1;

        try {
            DatagramSocket udpServer = new DatagramSocket(porta);

            byte[] receberDados = new byte[2048];
            byte[] enviarDados = new byte[2048];

            while (true) {
                //PREPARAR BUFFER PRA PACOTE A RECEBER
                DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);
                System.out.println("Aguardando Datagrama UDP na porta "+ porta);
                udpServer.receive(receberPacote);
                System.out.println("Datagrama UDP ["+qtdCon+"] recebido ");

                String palavra = new String(receberPacote.getData());
                System.out.println(palavra);
                
                InetAddress ip = receberPacote.getAddress();
                int porta1 = receberPacote.getPort();

                String palavraMaiuscula = palavra.toUpperCase();
                enviarDados = palavraMaiuscula.getBytes();
                //PREPARAR BUFFER PRA PACOTE A ENVIAR 
                DatagramPacket enviarPacote = new DatagramPacket(enviarDados, enviarDados.length,ip,porta1);
                System.out.println("Enciando ... " +palavraMaiuscula+ "!agurade ...");
                //ENVIANDO PACOTE
                udpServer.send(enviarPacote);
                System.out.println("Envio com sucesso!!!");
                udpServer.close();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }



        }

    }
        
    

