import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            CalcFuntions calcFuntions = new CalcFuntions();
            if (inputLine.contains("fun:")){
                switch (inputLine){
                    case "fun:sin":
                        calcFuntions.tipoFuncion = CalcFuntions.Tipo.SIN;
                        break;
                    case "fun:tan":
                        calcFuntions.tipoFuncion = CalcFuntions.Tipo.TAN;
                        break;
                    case "fun:cos":
                        calcFuntions.tipoFuncion = CalcFuntions.Tipo.COS;
                        break;
                }
                System.out.println("Mensaje:"+inputLine);
                outputLine = "Se cambio la funcion a: " + inputLine;
                out.println(outputLine);
            }else {
                Double calculo = 0.0;
                calculo = calcFuntions.calculate(Double.parseDouble(inputLine));
                System.out.println("Mensaje:"+inputLine);
                outputLine = "Respuesta " + calculo;
                out.println(outputLine);
            }
            if (outputLine.equals("Respuestas: Bye."))
                break;
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}

