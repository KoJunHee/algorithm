package bj_1953;

import java.util.*;

class Student {
    public int number;
    public int depth;

    public Student(int number, int depth) {
        this.number = number;
        this.depth = depth;
    }
}

public class Main {

    static int n;
    static ArrayList<Integer>[] students;
    static boolean isVisited[];
    static ArrayList<Integer> whites = new ArrayList<Integer>();
    static ArrayList<Integer> blues = new ArrayList<Integer>();

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        //방문체크 배열
        isVisited = new boolean[n + 1];

        // 어레이리스트 생성 및 연결
        students = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            students[i] = new ArrayList<Integer>();
            int num = scanner.nextInt();
            while (num-- > 0) {
                int dislikeStudent = scanner.nextInt();
                students[i].add(dislikeStudent);
            }
        }

        scanner.close();
    }


    public static void bfs(int i) {
        Queue<Student> studentsQueue = new LinkedList<Student>();

        //큐에 넣을 때 방문 체크
        studentsQueue.add(new Student(i, 0));
        isVisited[i] = true;

        while (!studentsQueue.isEmpty()) {
            Student student = studentsQueue.remove();

            //팀 배분
            if (student.depth % 2 == 0) {
                whites.add(student.number);
            } else {
                blues.add(student.number);
            }

            //연결
            for (int disLikeStudent : students[student.number]) {

                if (!isVisited[disLikeStudent]) {
                    //큐에 넣을 때 방문 체크
                    studentsQueue.add(new Student(disLikeStudent, student.depth + 1));
                    isVisited[disLikeStudent] = true;
                }
            }

        }

    }

    public static void print() {
        System.out.println(blues.size());
        Collections.sort(blues);
        for (int student : blues) {
            System.out.print(student + " ");
        }
        System.out.println();
        System.out.println(whites.size());
        Collections.sort(whites);
        for (int student : whites) {
            System.out.print(student + " ");
        }
    }

    public static void main(String[] args) {

        input();

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                bfs(i);
            }
        }

        print();

    }
}
