package TCP.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(2345);
        Socket s=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        String line=null;
        while ((line=br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                s.getOutputStream()));
        writer.write("success");
        writer.newLine();
        writer.flush();

        bw.close();
        s.close();
        ss.close();
    }
}
