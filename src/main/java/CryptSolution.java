import java.util.HashMap;
import java.util.stream.IntStream;

public class CryptSolution {
    static boolean isCryptSolution(String[] crypt, char[][] solution) {
        var cryptChar = new char[crypt.length][];
        var decodeMap = new HashMap<Character, Character>();
        var values = new long[crypt.length];
        for (char[] line : solution) {
            decodeMap.put(line[0], line[1]);
        }
        for (int i = 0; i < crypt.length; i++) {
            String s = crypt[i];
            cryptChar[i] = new char[s.length()];
            for (int j = 0; j < s.length(); j++) {
                cryptChar[i][j] = decodeMap.get(s.charAt(j));
            }
            var sc = new String(cryptChar[i]);
            if (sc.startsWith("0") && !IntStream.range(0, sc.length()).allMatch(c -> c == 0)) return false;
            values[i] = Long.parseLong(sc);
        }
        return values[0] + values[1] - values[2] == 0;
    }

    public static void main(String[] args) {
        System.out.println(CryptSolution.isCryptSolution(new String[]{"SEND", "MORE", "MONEY"}, new char[][]{{'O', '0'}, {'M', '1'}, {'Y', '2'}, {'E', '5'}, {'N', '6'},
                {'D', '7'}, {'R', '8'}, {'S', '9'}}));
        System.out.println(CryptSolution.isCryptSolution(new String[]{"TEN", "TWO", "ONE"}, new char[][]{{'O', '1'}, {'T', '0'}, {'W', '9'}, {'E', '5'}, {'N', '4'}}));
        System.out.println(CryptSolution.isCryptSolution(new String[]{"A", "A", "A"}, new char[][]{{'A', '0'}}));
        System.out.println(CryptSolution.isCryptSolution(new String[]{"AAAAAAAAAAAAAA", "BBBBBBBBBBBBBB", "CCCCCCCCCCCCCC"}, new char[][]{{'A', '1'}, {'B', '2'}, {'C', '3'}}));
    }
}
