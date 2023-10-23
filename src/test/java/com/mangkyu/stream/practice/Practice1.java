package com.mangkyu.stream.practice;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    @Test
    void practice() {
        Map<String,String> map = Map.of("두산","김현수","키움","이지영","샌디애고","김하성");
        Map<String,String> map2 = Map.of("키움","승리를 위한 함~성","두산","걸어간다 양의지","기아","기아의 김~주찬");
        List<Map<String,String>> mapList = List.of(map,map2);
        List<String> stringList = List.of("Kiwoom","Hanhwa","Doosan", "heroes");

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


        List<Map<String, String>> collect1 = mapList.stream()
                .filter(test -> test.get("두산").equals("김현수"))
                .collect(Collectors.toList());
        System.out.println("collect1 = " + collect1); //collect1 = [{샌디애고=김하성, 키움=이지영, 두산=김현수}]


        System.out.println("End");
    }
}
