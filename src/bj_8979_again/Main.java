package bj_8979_again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Country {
    int country;
    int gold;
    int silver;
    int bronze;
    int rank;
    int sameCheck;

    public Country(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = 0;
        this.sameCheck = -1;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<Country> countryArrayList = new ArrayList<Country>();

        for (int i = 0; i < n; i++) {
            Country country = new Country(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            countryArrayList.add(country);
        }


        //정렬
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                countryArrayList.get(i).rank = rank;
            }
            else if (countryArrayList.get(i).sameCheck != -1) {

                for (int q = 0; q < n; q++) {
                    if (countryArrayList.get(q).country == countryArrayList.get(i).sameCheck) {
                        countryArrayList.get(i).rank = countryArrayList.get(q).rank;
                        break;
                    }
                }

            }
            else {
                for (int j = i + 1; j < n; j++) {
                    if (countryArrayList.get(i).gold < countryArrayList.get(j).gold) {
                        Collections.swap(countryArrayList, i, j);
                    } else if (countryArrayList.get(i).gold == countryArrayList.get(j).gold && countryArrayList.get(i).silver < countryArrayList.get(j).silver) {
                        Collections.swap(countryArrayList, i, j);
                    } else if (countryArrayList.get(i).gold == countryArrayList.get(j).gold && countryArrayList.get(i).silver == countryArrayList.get(j).silver && countryArrayList.get(i).bronze < countryArrayList.get(j).bronze) {
                        Collections.swap(countryArrayList, i, j);
                    } else if (countryArrayList.get(i).gold == countryArrayList.get(j).gold && countryArrayList.get(i).silver == countryArrayList.get(j).silver && countryArrayList.get(i).bronze == countryArrayList.get(j).bronze) {
                        countryArrayList.get(j).sameCheck = countryArrayList.get(i).country;
                    }
                }
                countryArrayList.get(i).rank = rank++;
            }

        }


        //출력
        for (int i = 0; i < n; i++) {
            if (countryArrayList.get(i).country == k) {
                System.out.println(countryArrayList.get(i).rank);
                break;
            }
        }

    }

}
