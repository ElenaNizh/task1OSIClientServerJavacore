import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8089;
        //Запускаем сервер на определенном порту и принимаем соединение:
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
//Читаем строку и выводим её на экран вместе с номером порта клиента, с которого пришло соединение:
                System.out.println("New connection accepted");
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}