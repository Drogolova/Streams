import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(-1);
        list.add(-7);
        list.add(-9);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(4);
        list.add(6);

        Stream<Integer> stream = list.stream();
        Comparator order = Comparator.naturalOrder();
        BiConsumer minMaxConsumer = (o, o2) -> System.out.println("min: " + o + ", max: " + o2);
        findMinMax(stream,order, minMaxConsumer);

        System.out.println("Задание 2");
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        countPositiveNumberAmount(stream1);
    }
    public static <T> void findMinMax(Stream<? extends T> stream,
                                    Comparator<? super T> order,
                                        BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> collect = stream.sorted(order)
                .collect(Collectors.toList());
        T min = collect.get(0);
        T max = collect.get(collect.size() - 1);
        minMaxConsumer.accept(min, max);
    }

    public static <T> void countPositiveNumberAmount(Stream<Integer> stream) {
        long count = stream.filter(i -> i % 2 == 0)
                .count();
        System.out.println(count);
    }
    }
