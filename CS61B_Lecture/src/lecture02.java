import java.io.*;
import java.net.*;

/**
 * Created by ginolee on 12/26/16.
 */
public class lecture02 {

    /**
     * operate with System.in & System.out
     */

    public static void main(String[] args) throws IOException {
        // System input from the keyboard
        System.out.println("System out with keyboard input");
        BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(keybd.readLine());

        // System input from the web access
        System.out.println("System out with web access");
        URL url = new URL("http://www.google.com");
        BufferedReader web = new BufferedReader(new InputStreamReader(url.openStream()));
        System.out.println(web.readLine());
    }

}
