package casting;

public class Main {
    public static void main(String[] args) {
        byte a = 1;
        int b = (int) a;
        int c = a;
        System.out.println("explict casting : " + b);
        System.out.println("implicit casting : " + c);
    }
}
