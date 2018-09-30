package kakao_test01_again;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] ans = solution(record);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static String[] solution(String[] record) {


        //save name change history
        int cnt = 0;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int i = 0; i < record.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(record[i], " ");
            String first, id, name;
            first = stringTokenizer.nextToken();
            id = stringTokenizer.nextToken();

            if (!first.equals("Change")) {
                cnt++;
            }

            if (first.equals("Leave")) {
                continue;
            }

            name = stringTokenizer.nextToken();
            hashMap.put(id, name);
        }

        // make a answer string array
        String[] answer = new String[cnt];
        int idx = 0;
        for (String str : record) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            String first, id, name;
            first = stringTokenizer.nextToken();
            id = stringTokenizer.nextToken();

            if (first.equals("Change")) {
                continue;
            }

            name = hashMap.get(id);
            String res = "";
            if (first.equals("Enter")) {
                res = name + "님이 들어왔습니다.";
            } else {
                res = name + "님이 나갔습니다.";
            }
            answer[idx++] = res;
        }

        return answer;
    }
}