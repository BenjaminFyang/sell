import org.junit.Test;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 11:08
 * @deprecated :
 */
public class StringFormatTest {

    @Test
    public void test1() {
        //1.0 单个占位符
        String s = String.format("Hello %s，Welcome to my blog!", "jerry");
        //Hello jerry，Welcome to my blog!
        System.out.println(s);


        //1.2多个占位符
        //1.2.1按顺序
        String s2 = String.format("Hello %s%s%s", "jerry-", "li", ",welcome!");
        System.out.println(s2);

        //1.2.2按索引
        String s3 = String.format("Hello %2$s%3$s%1$s", "li-", "heng-", "jie");
        System.out.println(s3);

    }
}
