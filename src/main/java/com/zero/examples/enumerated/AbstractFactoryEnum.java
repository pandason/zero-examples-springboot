package com.zero.examples.enumerated;

/**
 * Enum 클래스에서 사용할 Interface
 */
interface AbstractInterface {
    void ifMethod();
}

/**
 * Enum class 는 추상 클래스이며, 선언된 열거형 변수는 실제로는 변수가 아니라 Enum의 타입을 상속 받은 하위 클래스이다. 그래서
 * Enum 클래스에서 열거형 타입에서 사용할 추상 메소드를 구현가능하다.
 */
enum AbstractFactoryEnum implements AbstractInterface {

    /**
     * abstract methods 상속받아 각각의 enum type들에서 구현.
     */
    ABFE01 {
        @Override
        public void abMethod() {
            // TODO Auto-generated method stub
            System.out.println("Enum class 에서 Abstract Methods를 상속받아 구현.");
        }

        @Override
        public void ifMethod() {
            // TODO Auto-generated method stub
            System.out.println("Interface를 Enum class가 상속하여 해당 Interface의 메소드를 상속받아 구현.");
        }
    },
    ABFE02 {
        @Override
        void abMethod() {
            // TODO Auto-generated method stub
            System.out.println("Enum class 에서 Abstract Methods를 상속받아 구현.");
        }

        @Override
        public void ifMethod() {
            // TODO Auto-generated method stub
            System.out.println("Interface를 Enum class가 상속하여 해당 Interface의 메소드를 상속받아 구현.");
        }
    };

    /**
     * Enum type들에 상속할 추상 메소드.
     */
    abstract void abMethod();
}

class AbstractFactoryEnumRunClass {

    public static void main(String[] args) {
        /**
         * Enum class 의 타입을 호출하여 해당 열거형 타입에 구현된 추상 메소드를 호출하여 실행이 가능하다. 추상 메소드가 아니더라도 메소드
         * 구현이 가능하며 해당 방법은 FactoryMethodEnum.java에 구현 정의함.
         */
        AbstractFactoryEnum.ABFE01.abMethod();
        AbstractFactoryEnum.ABFE01.ifMethod();
        AbstractFactoryEnum.ABFE02.abMethod();
        AbstractFactoryEnum.ABFE02.ifMethod();
    }

}