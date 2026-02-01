package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멀쩡한_사각형 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();

        StringTokenizer st = new StringTokenizer(read);
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        멀쩡한_사각형 T = new 멀쩡한_사각형();
        T.solution(W, H);
    }

    public long solution(int w, int h) {
        // w -> x
        // h -> y

        int gcd = gcd(w, h);
        long w_divided = w / gcd;
        long h_divided = h / gcd;

        long block = w / w_divided;

        return (long) w * h - (block * ( w_divided + h_divided - 1 ));
    }

    int gcd(int a, int b) {

        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
