package test.xd;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.values();

        final Person a = new Person();
        System.out.println(a.getName());
        a.setName("1234");
        System.out.println(a.getName());

    }

}
