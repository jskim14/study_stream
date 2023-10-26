package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();

        /* csvLines.get(0)[0] = "김프로"
        0 = {String[3]@2222} ["김프로", " 축구:농구:야구", " 구기종목 좋아요"]
        1 = {String[3]@2223} ["정프로", " 개발:당구:축구", " 개발하는데 뛰긴 싫어"]
        2 = {String[3]@2224} ["앙몬드", " 피아노", " 죠르디가 좋아요 좋아좋아너..."]
*/
        /*
        * 1. 취미를 쭉 나열하고
        * 2. 갯수별로 카운트해서 맵으로 반환한다.
        * */

        //Collectors.toMap(Function.identity(), value -> 1, Integer::sum)

        Map<String, Integer> collect = csvLines.stream()
                .map(strings -> strings[1].replaceAll("\\s", "")) // 공백을 없애줌 //"축구:농구:야구"
                .flatMap(s -> Arrays.stream(s.split(":"))) //평탄화
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum)); //중복 갯수 구하기


        return collect;
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return new HashMap<>();
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        List<String[]> csvLines = readCsvLines();
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
