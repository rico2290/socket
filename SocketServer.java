import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private ServerSocket server;

    public SocketServer(String ip) throws Exception{
        if (ip != null && !ip.isEmpty()) {
            this.server = new ServerSocket(0, 1, InetAddress.getByName(ip));

        }
        else{
            this.server = new ServerSocket(0, 1, InetAddress.getLocalHost());
        }
    }

    //Escutar
    private void escutar() throws Exception{
        String data = null;
        Socket client = this.server.accept();
        String clientAddress = client.getInetAddress();//.getLocalHost();
        System.out.println("\r\n Nova coonexão a partir de" + clientAddress);    }

        BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(client.get)
        );
    
}