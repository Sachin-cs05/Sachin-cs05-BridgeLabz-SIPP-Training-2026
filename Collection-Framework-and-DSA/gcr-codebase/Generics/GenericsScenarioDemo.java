import java.util.ArrayList;
import java.util.List;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class Stack<T> {
    private List<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}

class Repository<T> {
    private List<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public List<T> getAll() {
        return data;
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

class Product {
    private int id;
    private String productName;

    public Product(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", productName='" + productName + "'}";
    }
}

class GenericUtils {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }
}

public class GenericsScenarioDemo {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Sachin", 21);
        System.out.println("Pair: " + pair);

        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("Generics");
        stack.push("OOP");
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack size: " + stack.size());

        Integer[] nums = {12, 45, 7, 89, 34};
        System.out.println("Max Integer: " + GenericUtils.findMax(nums));

        String[] words = {"Apple", "Mango", "Banana", "Peach"};
        System.out.println("Max String: " + GenericUtils.findMax(words));

        Repository<Student> studentRepo = new Repository<>();
        studentRepo.add(new Student(1, "Aman"));
        studentRepo.add(new Student(2, "Riya"));

        Repository<Product> productRepo = new Repository<>();
        productRepo.add(new Product(101, "Laptop"));
        productRepo.add(new Product(102, "Mouse"));

        System.out.println("\nStudents in Repository:");
        GenericUtils.printList(studentRepo.getAll());

        System.out.println("\nProducts in Repository:");
        GenericUtils.printList(productRepo.getAll());

        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(10);
        intList.add(15);

        System.out.println("\nUsing wildcard List<?>:");
        GenericUtils.printList(intList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(12.5);
        doubleList.add(7.5);
        doubleList.add(20.0);

        System.out.println("\nSum using ? extends Number: " + GenericUtils.sumNumbers(doubleList));

        List<Number> numberList = new ArrayList<>();
        GenericUtils.addIntegers(numberList);
        System.out.println("\nList after ? super Integer write operation:");
        GenericUtils.printList(numberList);
    }
}