package week2.Yun;

import java.util.*;

public class Yun_2667 {

    static int n;
    static int numberOfDangee, numberOfHouseInADangee;
    static int[][] array2D = new int[26][26];
    static List<Integer> listOfNumberOfHouseInADangee = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                array2D[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j);
            }
        }

        System.out.println(numberOfDangee);
        Collections.sort(listOfNumberOfHouseInADangee);
        for (int i = 0; i < listOfNumberOfHouseInADangee.size(); i++) {
            System.out.println(listOfNumberOfHouseInADangee.get(i));
        }
    }

    static void bfs(int i, int j) {
        Queue<Node> queue = new LinkedList<>();

        if (array2D[i][j] == 1) {
            numberOfDangee++;
            queue.offer(new Node(i, j));
            array2D[i][j] = 0;

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                numberOfHouseInADangee++;

                for (int k = 0; k < 4; k++) {
                    int nx = node.getX() + dx[k];
                    int ny = node.getY() + dy[k];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    if (array2D[nx][ny] == 0) {
                        continue;
                    }

                    queue.offer(new Node(nx, ny));
                    array2D[nx][ny] = 0;
                }

            }

        }

        if (numberOfHouseInADangee != 0) {
            listOfNumberOfHouseInADangee.add(numberOfHouseInADangee);
            numberOfHouseInADangee = 0;

        }


    }

    static class Node {
        private int x;
        private int y;

        Node() {
            x = 0;
            y = 0;
        }

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}


