import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MissingWordsSubstring {

    public String missingWords(String s, String t) {
        String[] splitS = s.split(" ");
        String[] splitT = t.split(" ");
        List<String> input = new LinkedList();
        Arrays.stream(splitS).forEach(input::add);
        for (String tWord : splitT) {
            input.remove(tWord);
        }
        return input.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String s = "I like soft cheese and hard cheese yum";
        String t = "like cheese yum";
        MissingWordsSubstring mws = new MissingWordsSubstring();
        System.out.println(mws.missingWords(s, t));
        s = "I like eating cheese do you like cheese";
        t = "like cheese";
        System.out.println(mws.missingWords(s, t));
    }


}
