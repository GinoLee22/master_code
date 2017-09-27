package Interview;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ginolee on 3/28/17.
 */
public class ChuBao {
    /**
     * this program is a very informal program only limiting to one input --> "dog"
     * @return
     */
    public List<String> possibleResults () {
        String input = "dog";
        String[] mapping = {"abc", "mns", "xyz"};
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for (int i = 0; i < input.length(); i++) {
            while (result.peek().length() == i) {
                String temp = result.poll();
                char[] tempArray = mapping[i].toCharArray();
                for (int j = 0; j < tempArray.length; j++) {
                    result.add(temp + tempArray[j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ChuBao cb = new ChuBao();
        System.out.println("\n ----- self-testing");
        System.out.println(cb.possibleResults());
    }
}
