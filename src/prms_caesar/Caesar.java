package prms_caesar;
public class Caesar {

    String caesar(String s, int n) {
        String result = "";
        char temp;

        for(int i=0; i<s.length(); i++){
            temp = ' ';
            if(Character.isLowerCase(s.charAt(i)))
                temp = (char) (((s.charAt(i)-'a'+n)%26)+'a');
            else if(Character.isUpperCase(s.charAt(i)))
                temp = (char) (((s.charAt(i)-'A'+n)%26)+'A');
            result+=temp;
        }

        return result;
    }

    public static void main(String[] args) {
        Caesar c = new Caesar();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("sLonVtt W CgYaDRAcPIIKhcN bbFFm texQF DSepeJkFS", 28));
    }
}
