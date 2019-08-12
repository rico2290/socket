import java.io.*;
import java.net.*;

/**
 * ClienteUDP
 */
public class ClienteUDP {
    public static void main(String[] args) throws Exception, SocketException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            DatagramSocket clienteSocket = new DatagramSocket();

            String server = "localhost";
            int porta = 433;

            InetAddress ip = InetAddress.getByName(server);
            System.out.println(ip);

            byte[] receberDados = new byte[2048];
            byte[] enviarDados = new byte[2048];

            System.out.println("Digite o que deseja enviar ao servidor");
            String palavra = bufferedReader.readLine();
            enviarDados = palavra.getBytes();

            //PREPARAR PACOTE PARA ENVIO DOS DADOS
            DatagramPacket enviarPacote = new DatagramPacket(enviarDados, enviarDados.length, ip , porta);
            System.out.println("Enviando pacote UDP para... " +server+ ":" + porta);
            clienteSocket.send(enviarPacote);
            //PREPARAR PARA RECEBER PACOTE VINDO DO SERVIDOR
            DatagramPacket receberPacote = new DatagramPacket(receberDados, receberDados.length);

            clienteSocket.receive(receberPacote);
            System.out.println("Pacote UDP recebido com sucesso!!! ");

            String palavraAltera = new String(receberPacote.getData());

            System.out.println("texto recebido no servidor " + palavraAltera);
            clienteSocket.close();
            System.out.println("Socket Cliente fechado !!!" );
    
        } catch (Exception e) {
            System.out.println(e);
        }
        


    } 
}