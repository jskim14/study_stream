package com.mangkyu.stream.practice;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1_mapFilter {

    Map<String,String> map;
    Map<String,String> map2;
    List<Map<String,String>> mapList;
    List<String> stringList;
    List<Person> personList;

    @BeforeEach
    void setUp() {
        map = Map.of("두산","김현수","키움","이지영","샌디애고","김하성");
        map2 = Map.of("키움","승리를 위한 함~성","두산","걸어간다 양의지","기아","기아의 김~주찬");
        mapList = List.of(map,map2);
        stringList = List.of("Kiwoom","Hanhwa","Doosan", "heroes");
        personList = List.of(new Person("박병호","30"), new Person("최원태","20"), new Person("김상수", "30"));
    }

    @Test
    void practice() {
        // https://mangkyu.tistory.com/114

        /*
         * map : 기존의 stream 요소들을 변환하여 새로운 stream을 생성한다
         * */
        List<String> collect = mapList.stream() // stream을 생성
                .map(test -> test.get("두산"))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect); // collect = [김현수, 걸어간다 양의지]
        /*
         * map : 공통 요소를 그룹핑하는 개념
         * key가 "두산"인 value값 전부
         * */

        List<String> strings = stringList.stream()
                .map(test -> test.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("strings = " + strings); // strings = [KIWOOM, HANHWA, DOOSAN, HEROES]
    }

    @Test
    void practice2() {
        /*
        * filter : 조건에 맞는 데이터로 컬렉션 구성
        * boolean 반환하는 람다식 작성
        * */
        List<Map<String, String>> collect1 = mapList.stream()
                .filter(test -> test.get("두산").equals("김현수"))
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1); //collect1 = [{샌디애고=김하성, 키움=이지영, 두산=김현수}]

        List<String> collect2 = mapList.stream()
                .filter(test -> test.get("두산").equals("김현수"))
                .map(s-> s.get("두산"))
                .collect(Collectors.toList());
        System.out.println("collect2 = " + collect2); //collect2 = [김현수]

        List<String> strings1 = stringList.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());
        System.out.println("strings1 = " + strings1); //strings1 = [Hanhwa, Doosan]

        System.out.println("End");
    }

    @Test
    void practice3() {
        /*
        * 객체
        * */
        personList.stream()
                .map(s -> s.name)
                .collect(Collectors.toList())
                .forEach(s -> System.out.print(s + " ")); // 박병호 최원태 김상수

        personList.stream()
                .filter(s -> s.age.equals("30"))
                .map(s -> s.name)
                .collect(Collectors.toList());

        System.out.println("END");
    }

    @Test
    void practice4() {
        List<String[]> collect = stringList.stream()
                .map(s -> s.split(""))
                .collect(Collectors.toList());

        List<Map.Entry<String, String>> collect1 = mapList.stream()
                .flatMap(s -> s.entrySet().stream())
                .filter(s -> s.getKey().equals("키움"))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect1);
    }

    @Getter
    @Setter
    private static class Person {
        private String name;
        private String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
