import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        boolean insideTag = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                sb.append(word.reverse());
                word.setLength(0);
                insideTag = true;
                sb.append(c);
            } else if (c == '>') {
                insideTag = false;
                sb.append(c);
            } else if (insideTag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    sb.append(word.reverse());
                    word.setLength(0);
                    sb.append(' ');
                } else {
                    word.append(c);
                }
            }
        }

        sb.append(word.reverse());

        System.out.println(sb);
    }
}
