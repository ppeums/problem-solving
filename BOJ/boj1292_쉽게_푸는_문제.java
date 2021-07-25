import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] arr = new int[B];
        int idx = 0, answer = 0;
        for (int i = 1; i <= B; i++) {
            if (idx == B) {
                break;
            }
            for (int j = 0; j < i; j++) {
                if (idx == B) {
                    break;
                }
                arr[idx++] = i;
            }
        }
        for (int i = A - 1; i < B; i++) {
            answer += arr[i];
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
