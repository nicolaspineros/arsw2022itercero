import java.net.MalformedURLException;
import java.net.URL;

public class URLExplorer {

    public static void main(String[] args) {
        try {
            URL myUrl = new URL("https://www.escuelaing.edu.co/search/?search_text=cronograma&search_meta=%7B%22type%22%3A+%22model%22%2C+%22app_label%22%3A+%22pages%22%2C+%22model%22%3A+%22templatedpage%22%2C+%22slug%22%3A+null%7D&order_by=relevance");
            System.out.println("Protocolo: " + myUrl.getProtocol());
            System.out.println("Authority: " + myUrl.getAuthority());
            System.out.println("Host: " + myUrl.getHost());
            System.out.println("Path: " + myUrl.getPath());
            System.out.println("Query: " + myUrl.getQuery());
            System.out.println("File: " + myUrl.getFile());
            System.out.println("Ref: " + myUrl.getRef());
            System.out.println("Port: " + myUrl.getPort());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
