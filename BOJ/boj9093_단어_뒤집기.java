import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            String[] arr = input.split(" ");
            for (String word : arr) {
                for (int i = word.length() - 1; i >= 0; i--) {
                    bw.write(word.charAt(i));
                }
                bw.write(" ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}