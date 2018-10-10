import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String argv[])
    {
        try{
            System.out.println("Name your client");
            Scanner scan =new Scanner(System.in);
            String clientName=scan.next();
            Socket socketClient= new Socket("localhost",5550);
            System.out.println(clientName+":Connection Established");
            System.out.println("\nSimple Calculation of 2 Numbers");
            System.out.println("Enter 2 Numbers :");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            BufferedWriter writer=
                    new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            int serverMsg;
            writer.write(clientName+"\r\n");
            String firstnumber=scan.next();
            writer.write(firstnumber+"\r\n");
            String secondnumber=scan.next();
            writer.write(secondnumber+"\r\n");
            writer.flush();
            while((serverMsg = reader.read()) != -0){
                System.out.println("Response from Server: " + serverMsg);
            }

        }catch(Exception e){System.out.println("Connection Aborted ");}
    }
}