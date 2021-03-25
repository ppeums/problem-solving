import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] power;
    static String[] title;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        title = new String[N];
        power = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(br.readLine());
            String ans = binarySearch(input);
            sb.append(ans+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static String binarySearch(int input) {
        int left = 0, right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (input <= power[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return title[left];
    }
}