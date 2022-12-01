import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8089;
        Socket clientSocket = new Socket(host, port);

        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Netology.ru");
            String res = in.readLine();
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Клиентом должна быть другая программа (просто ещё один метод main в другом классе, запускаемый параллельно,
// во время работы сервера) или второй поток. Обратите внимание, что хостом подключения будет localhost - это
// зарезервированный адрес для подключения к текущему компьютеру (то есть это ваш компьютер - там, где запущена программа).
// Также можно использовать 127.0.0.1 - это ip адрес, соответствующий доменному имени localhost