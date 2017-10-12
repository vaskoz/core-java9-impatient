import java.util.Scanner;

public class Ch1_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                for (int j = str.length(); j > i; j--) {
                    if (!Character.isWhitespace(str.charAt(j-1))) {
                        System.out.println(str.substring(i, j));
                    }
                }
            }
        }
    }
}
