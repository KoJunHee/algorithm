package bj_10845;

import java.util.Scanner;

public class Main {


    public  static void main(String [] args){
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(--n != -1){
            String order = sc.next();

            switch (order){
                case "push" :
                    queue.push(sc.nextInt());
                    break;
                case "pop" :
                    System.out.println(queue.pop());
                    break;
                case "size" :
                    System.out.println(queue.showSize());
                    break;
                case "empty" :
                    System.out.println(queue.isEmpty());
                    break;
                case "front" :
                    System.out.println(queue.showHeadData());
                    break;
                case "back" :
                    System.out.println(queue.showTailData());
                    break;
            }

        }

    }

}
