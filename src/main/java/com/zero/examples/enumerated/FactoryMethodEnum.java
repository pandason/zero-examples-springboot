package com.zero.examples.enumerated;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory Methods 패턴 방식은 객체의 생성을 당담. Enum 타입에 객체 타입에 맞는 방식으로 열거 후 생성처리하되 열거형
 * 타입에서의 객체 생성은 protected로 외부 접근을 막고 내부적으로 create라는 공통된 메소드를 통해서 생성에 대한 기능 제어를
 * 통해 다양한 타입의 객체를 생성할수 있다.
 */

// sample interface
interface JJInterface {

    String getName();

    void setName(String name);
}

// Enum에서 객체 생성을 하기 위한 sample class
class JAEWON implements JJInterface {
    private String name = "쟤1 ";

    @Override
    public void setName(String name) {
        this.name += name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class JJAIJJOU implements JJInterface {

    private String name = "짜이쪼우 ";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name += name;
    }

}

public enum FactoryMethodEnum {

    JJJ01 {
        @Override
        protected JJInterface jae1() {
            return new JAEWON();
        }
    },
    JJJ02 {
        @Override
        protected JJInterface jae1() {
            return new JJAIJJOU();
        }
    };

    // 각각의 객체 생성에 대해 처리할 메소드
    public JJInterface create(String val) {
        JJInterface jj = jae1();
        jj.setName(val);
        return jj;
    }

    // 열거형 타입에서 실제 객체를 생성할 메소드. protected로 접근 권한에 제한을 두어 create가 아니면 생성할수 없도록 제한함.
    abstract protected JJInterface jae1();
}

class FactoryMethodEnumRunClass {

    public static void main(String[] args) {
        List<JJInterface> jj = new ArrayList<>();
        jj.add(FactoryMethodEnum.JJJ01.create("이가 맞니?"));
        jj.add(FactoryMethodEnum.JJJ02.create("니취팔러마~"));

        jj.stream().forEach(j -> {
            System.out.println(j.getName());
        });
    }

}