package com.zero.examples.enumerated;

/**
 * Enum 클래스 특성상 private 생성자로 인스턴스 생성을 제어한다. 또한 Enum은 런타임시가 아닌 컴파일시에 설정된 모든 값을
 * 알고있어야 한다. 런타임시에 값이 설정되면 안되기 때문이다. 참고:
 * http://blog.naver.com/PostView.nhn?blogId=kbh3983&logNo=220907314096&redirect=Dlog&widgetTypeCall=true&directAccess=false
 * 
 * Singleton Enum 클래스는 Thread-safety, Serialization이 보장되기 때문에 Reflection 을 통한
 * 공격에도 안전하다.
 * 
 * 열거형 타입에 선언된 값들은 상수값으로 지정되어 외부에서도 값을 변경할수가 없다.
 * 
 * 열거형 타입에 값이 선언되어있으면 동시에 Enum class 에 대한 생성자 초기화를 필수로 진행해야 한다. 지정된 열거형 타입 수만큼
 * 생성자 초기화가 실행되는데 해당 이유는 선언된 열거형 타입은 각각 Enum class 를 상속받아 구현이 된다. 이때문에 Enum
 * class에서 선언된 메소드들은 각각의 열거형 타입에서 chain 구조로 참조 및 실행이 가능하며 원할경우 열거형 타입마다 각각의 메소드
 * 구현이 가능하다. # 열거형 타입이 class 이고 enum class 가 abstract class 이며 코딩만 반대로 처리했다고
 * 생각하면 이해가 빠를수도 있음.
 */
public enum SingletonEnum {

    STE01("JJ", 1), STE02("JAE1", 2), STE03("JAEONE", 3), STE04("짜이쪼우", 4);

    // 선언의 순서는 상관이 없다.
    private Integer typeNum;
    private String typeName;

    // 초기화시 생성자 메소드에 Paramter 순서가 열거형 타입의 상수 값의 순서와 동일해야한다.
    private SingletonEnum(String typeName, Integer typeNum) {
        System.out.println("생성자 초기화중... " + typeName + " / " + typeNum);
        this.typeName = typeName;
        this.typeNum = typeNum;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public Integer getTypeNum() {
        return this.typeNum;
    }
}

class SingletonEnumRunClass {

    public static void main(String[] args) {
        // 열거형 타입으로 지정할 경우 타입명이 return string 됨.
        System.out.println("Enum : " + SingletonEnum.STE01);
        // 열거형 타입의 구현된 상수값을 getter method를 구현하여 조회.
        System.out.println("Enum static value : " + SingletonEnum.STE01.getTypeName());
    }

}