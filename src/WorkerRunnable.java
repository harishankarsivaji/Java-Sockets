import java.io.*;
import java.net.Socket;


public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    public void run() {
        try {
            OutputStream output = clientSocket.getOutputStream();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientName=reader.readLine().trim();
            System.out.println(clientName+" requesting...");
            String data1 = reader.readLine().trim();
            String data2 = reader.readLine().trim();

            int num1 = Integer.parseInt(data1);
            int num2 = Integer.parseInt(data2);

            int add=num1+num2;
            int sub=num1-num2;
            int mul=num1*num2;
            
            String response = "\tAddition of  "+data1+" and " +data2 +" is " + add;
            System.out.println(	"\tserver response:\t"+response);

            String response1 = "\tSubtraction of  "+data1+" and " +data2 +" is " + sub;
            System.out.println(	"\tserver response:\t"+response1);
            
            String response2 = "\tMultiplication of  "+data1+" and " +data2 +" is " + mul;
            System.out.println(	"\tserver response:\t"+response2);

            output.write(add);
            output.write(sub);
            output.write(mul);
            
            output.flush();
            System.out.println("\tRequest processed." );
        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }
}