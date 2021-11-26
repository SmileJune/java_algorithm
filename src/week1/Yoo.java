package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Yoo {

    //설탕배달 문제
    public void problem2839() {

    }

    //동전 0
    public void problem11047(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        int result = 0;

        //동전 단위 setting
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        //큰 동전의 단위부터 거꾸로 조사
        for (int i = coins.length - 1; i >= 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }
        System.out.println(result);
    }

    //동전 0 BufferedReader 이용
    public void problem11047BufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); //한줄에 띄어쓰기(" ")로 입력받은 n과 k를 위해

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        int result = 0;

        //동전 단위 setting
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        //큰 동전의 단위부터 거꾸로 조사
        for (int i = coins.length - 1; i >= 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }
        System.out.println(result);
    }

}
