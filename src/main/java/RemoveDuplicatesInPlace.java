import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicatesInPlace {
    public static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{1, 1, 2};
        int k = RemoveDuplicatesInPlace.removeDuplicates(myArr);
        System.out.println(Arrays.stream(myArr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(k);
        myArr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = RemoveDuplicatesInPlace.removeDuplicates(myArr);
        System.out.println(Arrays.stream(myArr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        System.out.println(k);

    }
}
