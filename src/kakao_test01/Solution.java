package kakao_test01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Person {
    String id;
    String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

//[Enter uid1234 Muzi, Enter uid4567 Prodo,Leave uid1234,Enter uid1234 Prodo,Change uid4567 Ryan]
// [Prodo님이 들어왔습니다., Ryan님이 들어왔습니다., Prodo님이 나갔습니다., Prodo님이 들어왔습니다.]
class Solution {
    static ArrayList<Person> arrayList = new ArrayList<Person>();

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        String[] res = solution02(record);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static String[] solution02(String[] record) {

        HashMap<String, String> map = new HashMap();
        int resCnt = 0;


        //이름과 아이디 매칭
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            String first = st.nextToken();

            if (first.equals("Enter") || first.equals("Change")) {
                String id = st.nextToken();
                String name = st.nextToken();
                map.put(id, name);
            }

            if (first.equals("Enter") || first.equals("Leave")) {
                resCnt++;
            }
        }

        String[] ans = new String[resCnt];
        int cnt = 0;

        //출력
        for (int i = 0; i < record.length; i++) {
            StringTokenizer st = new StringTokenizer(record[i], " ");
            String first = st.nextToken();

            String temp = "";
            if (first.equals("Enter")) {
                String id = st.nextToken();
                temp += map.get(id);
                temp += "님이 들어왔습니다.";
            } else if (first.equals("Leave")) {
                String id = st.nextToken();
                temp += map.get(id);
                temp += "님이 나갔습니다.";
            }else{
                continue;
            }

            ans[cnt++] = temp;
        }

        return ans;
    }


//    public static String[] solution(String[] record) {
//
//
//        int cntt = 0;
//        for (int i = 0; i < record.length; i++) {
//
//            StringTokenizer st = new StringTokenizer(record[i], " ");
//            String first = st.nextToken();
//
//            if (first.equals("Enter") || first.equals("Leave")) {
//                cntt++;
//            }
//
//            if (!first.equals("Leave")) {
//
//                String id = st.nextToken();
//                String name = st.nextToken();
//
//                //리스트에 들어있는지 체크하고, 있으면 이름 바꾸기
//                boolean flag = true;
//                if (arrayList.size() > 0) {
//                    for (Person person : arrayList) {
//                        if (person.id.equals(id)) {
//                            person.name = name;
//                            flag = false;
//                            break;
//                        }
//                    }
//                }
//
//                //리스트에 안들어가 있으면, 생성
//                if (flag) {
//                    arrayList.add(new Person(id, name));
//                }
//            }
//        }
//
//        String[] answer = new String[cntt];
//        int cnt = 0;
//
//        for (int i = 0; i < record.length; i++) {
//            StringTokenizer st = new StringTokenizer(record[i], " ");
//
//            String first = st.nextToken();
//
//            if (!first.equals("Change")) {
//                String id = st.nextToken();
//
//                String res = "";
//
//                //이름 찾기
//                for (Person person : arrayList) {
//                    if (person.id.equals(id)) {
//                        res += person.name;
//                        res += "님이 ";
//                    }
//                }
//
//                if (first.equals("Enter")) {
//                    res += "들어왔습니다.";
//                    answer[cnt++] = res;
//                } else if (first.equals("Leave")) {
//                    res += "나갔습니다.";
//                    answer[cnt++] = res;
//                }
//            }
//        }
//
//
//        return answer;
//    }
}
