package lambda;


import helpfulClasses.MyLambda;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

public class LambdaTestClass {
    /*
    //Забавная особенность кеширования Integer
        Comparator<Integer> comparator1 = (o1, o2) -> o1.compareTo(o2);
        comparator1.compare(1, 2);
        Integer a = -129;
        Integer b = -129;
        System.out.println(a == b);
        //TODO Factory -> Supplier; Block -> Consumer; Mapper -> Function!!!!!!!!!!!
    */

    @Test  //Создание из своего интерфейса
    public void testLambdaReturnValue() {
        MyLambda myLambda = x -> ("hello " + x);
        Assert.assertEquals("hello Ruslan", myLambda.sayHello("Ruslan"));
    }

    @Test  //Сравнение объектов
    public void testLambdaComparator() {
        //неправильно сравнивать объектные типы на ==. Здесь нужно сделать по другому
        //Comparator<Integer> comparator = (s1, s2) -> (s1 > s2 ? -1 : (s2 == s1 ? 0 : 1));

        Comparator<Integer> comparator = (s1, s2) -> {
            int a = s1;
            int b = s2;
            return (a > b ? -1 : (a == b ? 0 : 1));
        };
        Assert.assertTrue(0 == comparator.compare(3000, 3000));
    }

    @Test  //Получить из одного объекта, другой
    public void testLambdaFunction() {
        Function<String, Integer> mapper = s -> Integer.valueOf(s);
        Integer apply = mapper.apply("5");
        Assert.assertTrue(apply.getClass().equals(Integer.class));
    }

    @Test  //Сделать блок какого-то кода
    public void testLambdaConsumer() {
        int[] mass = new int[]{1, 2, 3};

        Consumer<int[]> b = (s) -> {
            //block
            s[0] = 11111;
        };
        b.accept(mass);
        //mass.forEach(b);
        Assert.assertTrue(11111 == mass[0]);
    }

    @Test //Предикат (какое то утверждение)
    public void testLambdaPredicate() {
        Predicate<String> mather = s -> s.length() > 5;
        Assert.assertTrue(mather.test("RuSlaN"));
    }

    @Test //получить объект откуда нибудь
    public void testLambdaSupplier() {
        Supplier<String> factory = () -> "hello";
        Assert.assertEquals("hello", factory.get());
    }

}
