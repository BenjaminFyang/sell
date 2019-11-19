import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Fy
 * Date: 2018-02-24
 * Time: 14:27
 */

/**
 * java Lambda
 * <p>
 * lambda表达式本质是匿名方法，下面是一些lambda表达式：
 * (int x,int y) ->x + y
 * <p>
 * () ->42
 * <p>
 * (String s) -> {System.out.println(s)}
 * <p>
 * 第一个lambda表达式接受x和y这两个参数并返回他们的和：
 * 第二个lambda表达式不接受参数，返回整数42
 * 第三个lambda表达式接受一个字符串并把他们打印到控制台，不返回值。
 * lambda表达式的语法由参数列表，箭头符号->和函数体组成。函数体既可以是一个表达式，也可以是一个语句块：
 * 表达式：表达式会被执行然后返回执行结果。
 * 语句块：语句块中的语句会被依次执行，就像方法中的语句一样。
 * return语句会把控制权交给匿名方法的调用者
 * break和continue只能在循环中使用
 * <p>
 * 如果函数体有返回值，那么函数体内部的每一条路径都必须返回值
 */

public class lambdaTest {


    public static void main(String[] args) {


        Random rand = new Random();

        Integer number = rand.nextInt(100) + 1;
        switch(number) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("default");
                break;
        }

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};

        List<String> players = Arrays.asList(atp);

        //以前的循环方式
        for (String player : players) {
            System.out.println(player + ";");
        }

        //使用 lambda表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.println(players + ";"));

        //在 java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);


//        List<String> names = new ArrayList<>();
//        names.add("TaoBao");
//        names.add("ZhiFuBao");
//        //toLowerCase就是将字符串全部改为小写
//        List<String> lowercaseNames = names.stream().map(String::toLowerCase).collect(Collectors.toList());
//
//        System.out.println(lowercaseNames);
    }


    /**
     * 使用Lambdas排序集合
     * 在java中,Comparator类被用来牌序集合。在下面的例子中，我们将根据球员的name,surname,name长度以及
     * 最后一个字母。和前面的示例一样，先使用匿名内部类来排序，然后再使用lambda表示式精简我们的代码。
     */
    @Test
    public void test1() {
        //在第一个例子中，我们将根据name来排序list。使用旧的方式，代码如下所示
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        //1.1 使用匿名内部类根据name排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.compareTo(o2));
            }
        });

        //1.2 使用lambda expression 排序players
        Comparator<String> sortByName = (String o1, String o2) -> (o1.compareTo(o2));
        Arrays.sort(players, sortByName);

        //1.3 也可以采用如下形式
        Arrays.sort(players, (String o1, String o2) -> (o1.compareTo(o2)));

    }


    @Test
    public void test2() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};


        // 1.1 使用匿名内部类根据 surname 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });
        System.out.println(Arrays.toString(players));

        // 1.2 使用 lambda expression 排序,根据 surname
        Comparator<String> sortBySurname = (String s1, String s2) ->
                (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players, sortBySurname);

        // 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
        Arrays.sort(players, (String o1, String o2) -> (o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")))));

        // 2.1 使用匿名内部类根据name length 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.length() - o2.length());
            }
        });

        // 2.2 使用 lambda expression 排序，根据 name length
        Comparator<String> sortByNameLength = (String o1, String o2) -> (o1.length() - o2.length());
        Arrays.sort(players, sortByNameLength);

        // 2.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        // 3.1 使用匿名内部类排序 players, 根据最后一个字母
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // 3.2 使用 lambda expression 排序,根据最后一个字母
        Comparator<String> sortByLastLetter =
                (String s1, String s2) ->
                        (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);

        // 3.3 or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));
    }

    /**
     * 使用Lambdas和Stream
     * Stream是对集合的包装，通常和lambda一起使用。使用lambdas可以支持许多操作，如map,filter，limit,
     * sorted,count,min,max,sum,collect等等。同样，Stream使用懒运算，他们并不会真正地读取所有的数据，
     * 遇到像getFirst（）这样的方法会结束链式语法。在接下来的例子中，我们将探索lambdas和stream能做什么。
     * 我们创建了一个Person类并使用这个类来添加嘻嘻额数据到list中，将用于进一步流操作。Person只是一个
     * 简单的POJO类
     */

    @Test
    public void test3() {
        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };


        //现在我们使用forEach方法来迭代输出上述列表：
        System.out.println("所有程序员的姓名：");
        javaProgrammers.forEach(p -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach(person -> System.out.printf("%s %s;", person.getFirstName(), person.getLastName()));

        //我们同样使用forEach方法，增加程序员的工资5%:
        System.out.println("给程序员加薪 5% :");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);

        //另一个有用的方法是过滤器filter()，让我们显示月薪超过1400美元的PHP程序员
        System.out.println("下面是月薪超过$1400的php程序员");
        phpProgrammers.stream()
                .filter(person -> (person.getSalary() > 1400))
                .forEach(person -> System.out.printf("%s %s ;", person.getFirstName(), person.getLastName()));

        //我们也可以定义过滤器，然后重用他们来执行其他操作
        //定义 filers
        Predicate<Person> ageFilter = person -> (person.getAge() > 25);
        Predicate<Person> salaryFilter = person -> (person.getSalary() > 1400);
        Predicate<Person> genderFilter = person -> ("female".equals(person.getGender()));

        System.out.println("下面是年龄大于24岁且月薪在$1400以上的女php程序员");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s ;", person.getFirstName(), person.getLastName()));

        //重用filters
        System.out.println("年龄大于 24岁的女性 Java programmers");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach(person -> System.out.printf("%s %s ;", person.getFirstName(), person.getLastName()));

        //使用limit方法，可以限制结果集的个数
        System.out.println("最前面的3个 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach(person -> System.out.printf("%s %s ;", person.getFirstName(), person.getLastName()));

        System.out.println("最前面的3个女性 Java programmer:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach(person -> System.out.printf("%s,$s ;", person.getFirstName(), person.getLastName()));


        //排序呢？我们在stream中能处理吗？答案是肯定的。在下面的例子中，我们将根据名字和薪水排序java程序员，放到一个list中，然后显示列表
        System.out.println("根据 name 排序，并显示前5个 Java programmers：");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(Collectors.toList());

        sortedJavaProgrammers.forEach(person -> System.out.printf("%s %s;%n ", person.getFirstName(), person.getLastName()));


        //如果我们只对最低和最高的薪水感兴趣，比排序后选择第一个/最后一个更快的是min和max方法
        System.out.println("工资最低的 java programmer:");
        Person pers = javaProgrammers
                .stream()
                .min((o1, o2) -> (o1.getSalary() - o2.getSalary()))
                .get();
        System.out.printf("Name: %s %s; Salary:$%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());


        //上面的例子中我们已经看到collect方法是如何工作的。结合map方法，我们可以使用collect方法来哦将我们的结果集放到一个字符串，一个Set或TreeSet中，
        System.out.println("将 PHP programmers 的 first name拼接成字符串：");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining(" ; "));  //在进一步的操作中可以作为标记(token)
        System.out.println(phpDevelopers);

        System.out.println("将 java programers 的 first name 存放到 Set：");
        Set<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
        System.out.println(javaDevLastName);

        System.out.println("将 java programmers 的first name 存放在 TreeSet:");
        TreeSet<String> javaDevLastName2 = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.toCollection(TreeSet::new));


        //我们可以使用summaryStatistics方法获取stream中元素的各种汇总数据。接下来，我们可以访问这些方法，比如
        //getMax，getMin,getSum,或getAverage:

        //计算 count,min,max,sum,and average for number
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字：" + stats.getMax());
        System.out.println("List中最小的数字：" + stats.getMin());
        System.out.println("所有数字的综合：" + stats.getSum());
        System.out.println("所有数字的平均值：" + stats.getAverage());


        //总结
        //在本文中，我们学会了使用lambda表达式的不同方式，从基本的示例，到使用lambdas和stream的复杂示例。此外
        //我们还学习了如何使用lambdas表达式与Comparator类来对java进行排序
    }




}
