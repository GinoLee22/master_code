package hw1;

import java.io.IOException;

/**
 * Created by ginolee on 12/27/16.
 */
public class Nuke2 {
    public static void main(String[] args) throws IOException{
        String originInput = OpenCommercial.keybdInput();
        System.out.println(originInput.substring(0, 1) + originInput.substring(2, originInput.length()));
    }
}
