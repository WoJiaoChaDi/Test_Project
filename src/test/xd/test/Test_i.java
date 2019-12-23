package test.xd.test;

public class Test_i {

    public static void main(String[] args) {


        /*
        * 跟栈顶弹出有关
        */
        int i = 0;
        i = i++;
        System.out.println(i);
        //输出为：0

        /*
        * m++   先使用，在+1
        * ++m   先+1，再使用
        * 所以过程是：
        * j = 1;
        * j = 2;
        */
        int j = 0;
        j = ++j;
        j = ++j;
        System.out.println(j);
        //输出为：2

        /*
        * m++   先使用，在+1
        * ++m   先+1，再使用
        * 所以过程是：
        * 0 + ++m + m++   此时m=1
        * 0 + 2 + m++     此时m=2
        * 0 + 2 + 2       此时m=3
        */
        int m = 0;
        System.out.println(m++ + ++m + m++);
        //输出为：4

    }
}
