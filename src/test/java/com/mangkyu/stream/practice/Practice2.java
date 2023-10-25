package com.mangkyu.stream.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {

    List<String> stringList;
    List<String> stringList2;

    @BeforeEach
    void setUp() {
        stringList = List.of("Kiwoom","Hanhwa","Doosan", "heroes");
        stringList2 = List.of("이정후","이정후","김하성","서건창");
    }

    @Test
    void practice1() {
        /*
        * sorted : 정렬
        * */
        List<String> strings = stringList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("strings = " + strings); //[Doosan, Hanhwa, Kiwoom, heroes]

        stringList.stream()
                .sorted(String::compareTo)
                .forEach(System.out::println); // Doosan Hanhwa Kiwoom heroes

        stringList.stream()
                .sorted(String::compareToIgnoreCase) //// Doosan Hanhwa heroes Kiwoom heroes
                .forEach(System.out::println);
    }

    @Test
    void practice2() {
        /*
        * distinct : 중복제거
        * equals와 hashCode를 오버라이드 해야한다
        * */
        List<String> collect = stringList2.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    void practice3() {
        /*
        * count
        * 반환 : long
        * */
        int count = (int) stringList2.stream()
                .distinct()
                .count();

        System.out.println("count = " + count); // 중복제거 전 4, 제거 후 3
    }
}
