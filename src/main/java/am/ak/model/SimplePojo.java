package am.ak.model;

/**
 * Created by karlen on 6/19/17.
 */
public class SimplePojo implements Pojo {

    public void foo() {
        System.out.println("before call bar");
        this.bar();
        System.out.println("after call bar");
    }

    public void bar() {
        System.out.println("bar");
    }
}
