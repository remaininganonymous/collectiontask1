import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

interface Filter {
    Object apply(Object o);
}

/* Практическое задание - Collection - фильтрация
   Напишите метод filter, который принимает на вход массив любого типа,
   вторым аргументом метод должен принимать класс,
   реализующий интерфейс Filter, в котором один метод - Object apply(Object o).
   Метод должен быть реализован так чтобы возвращать новый массив,
   к каждому элементу которого была применена функция apply*/

public class Main {
    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Filter filter = new Filter() {
            @Override
            public Object apply(Object o) {
                if (o instanceof Integer) {
                    return (Integer) o * 2;
                }
                return o;
            }
        };
        Arrays.stream(filter(array, filter))
                .forEach(System.out::println);
    }

    public static Object[] filter(Object[] arr, Filter filter) {
        List<Object> filteredArray = Arrays.asList(arr).stream()
                .map(item -> filter.apply(item))
                .collect(Collectors.toList());
        return filteredArray.toArray();
    }
}

