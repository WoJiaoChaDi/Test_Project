package test.xd;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MyTest {

    public static void main(String[] args) {

        System.out.println(getValue(2));

        Map a = new HashMap();
        Map b = new Hashtable();
        a.put("","");
        a.put(null,null);
        b.put("","");
    }

    public static int getValue (int i){
        int result = 0;
        switch (i){
            case 1:
                result += i;
            case 2:
                result += i*2;
            case 3:
                result += i*3;
        }
        return result;
    }




}
