package com.zero.examples.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream의 구조는 크게 3가지의 구조로 나뉜다. 스트림생성().중개연산().최종연산() 스트립은 체인구조로 계속 연계해서 사용
 * 가능하다.
 * 
 */
public class Streams {

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("JJ", "재원", "재옹", "이재옹", "파크유", "짜이쪼우", "JAE1");

        // 중개 연산 : stream 요소를 판단하거나, 제어.
        // filter: 조건에 맞는 데이터 기준으로 거른다.
        sampleList.stream().filter(j -> j.contains("J")).forEach(j -> {
            System.out.println("filter : " + j);
        });

        // map: 스트립 요소에 대한 연상, 값을 추가하거나 숫자 값을 계산(연산) 함.
        sampleList.stream().map(j -> j += "짜쪼").forEach(j -> {
            System.out.println("map : " + j);
        });

        // peek

        // sorted : 스트립 요소 정렬
        sampleList.stream().sorted().forEach(j -> {
            System.out.println("sorted : " + j);
        });

        // limit: 지정한 갯수만큼 요소를 제한함.
        sampleList.stream().limit(2).forEach(j -> {
            System.out.println("limit : " + j);
        });

        // skip : 지정한 갯수만큼 요소를 제외한다.
        sampleList.stream().skip(3).forEach(j -> {
            System.out.println("skip : " + j);
        });

        // mapToInt, mapToLong, mapToDouble: 함수를 해당 타입의 스트림으로 변환
        List<String> sampleList2 = Arrays.asList("1", "2", "3", "4", "5", "6");
        sampleList2.stream().mapToDouble(num -> Double.parseDouble(num)).forEach(j -> {
            System.out.println("mapToXXX : " + j);
        });

        // 최종 연산 : 실제로 return에 대한 관여
        // count, min, max, sum, average

    }
}