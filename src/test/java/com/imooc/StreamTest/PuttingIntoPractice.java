package com.imooc.StreamTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author : Fy
 * @date : 2018-04-23 14:42
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1.找出2011年发生的所有交易，并按交易额排序(从低到高)
        List<Transaction> tr2011 = transactions
                .stream()
                .filter(p -> p.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(tr2011);

        //2.交易员都在那些不同的城市工作过
        List<String> cityList = transactions
                .stream()
                .map(p -> p.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cityList);

        //3.查找所有来自剑桥的交易员
        List<Trader> cambridgeList = transactions
                .stream()
                .map(Transaction::getTrader)
                .filter(p -> p.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(cambridgeList);

        //4.返回所有交易员的姓名字符串，按照字母顺序排序
        String collectList = transactions
                .stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(collectList);

        //5.有没有交易员是在米兰工作的
        boolean milan = transactions
                .stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(milan);
        //6.打印生活在剑桥的交易员的所有交易额
        transactions
                .stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        //7.所有交易中，最高的交易额是多少
        Optional<Integer> reduce = transactions
                .stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce.isPresent());

        //8.找到交易额最小的交易
        Optional<Transaction> reduce1 = transactions
                .stream()
                .reduce((t1, t2) -> (t1.getValue() < t2.getValue() ? t1 : t2));
        System.out.println(reduce1);

        Optional<Transaction> min = transactions
                .stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(min);


        IntStream intStream = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(intStream.count());

    }
}
