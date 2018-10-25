package java_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.getName());
    }
}

public class Main {
    public static void main(String[] args) {
        arraySort();
        collectionSort();
        comparableSort();
        comparatorSort();
    }

    public static void arraySort() {
        String[] strings = {"라", "나", "다", "가"};
        Integer[] integers = {4, 3, 2, 1};

        Arrays.sort(strings);
        Arrays.sort(integers);

        for (String string : strings) {
            System.out.print(string + " ");
        }

        System.out.println();

        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public static void collectionSort() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("라");
        arrayList.add("다");
        arrayList.add("나");
        arrayList.add("가");

        Collections.sort(arrayList);

        for (String str : arrayList) {
            System.out.print(str + " ");
        }
    }

    public static void comparableSort() {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList.add(new Person("가가가", 10));
        arrayList.add(new Person("다다다", 30));
        arrayList.add(new Person("나나나", 50));

        Collections.sort(arrayList);

        for (Person person : arrayList) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }

    public static void comparatorSort() {
        ArrayList<Person> arrayList = new ArrayList<Person>();
        arrayList.add(new Person("가가가", 10));
        arrayList.add(new Person("다다다", 30));
        arrayList.add(new Person("나나나", 50));

        Collections.sort(arrayList, new Comparator<Person>() {
            @Override
            public int compare(Person person01, Person person02) {
                if (person01.getAge() > person02.getAge()) {
                    return 1;
                } else if (person01.getAge() < person02.getAge()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });


        for (Person person : arrayList) {
            System.out.println(person.getName() + ", " + person.getAge());
        }
    }
}
