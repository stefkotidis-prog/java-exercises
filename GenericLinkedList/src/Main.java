public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> numbers = new CustomLinkedList<>(0);
        numbers = numbers.add(1).add(18).add(45);

        for (int i = 0; i < 5; i++) {
            numbers = numbers.add(i * 10);
        }

        System.out.println("Integers: " + numbers);
        System.out.println("Reversed: " + numbers.reverse());
        System.out.println("Size:     " + numbers.size());
        System.out.println("Index 2:  " + numbers.get(2));
        System.out.println("Has 18:   " + numbers.contains(18));
        System.out.println("Has 99:   " + numbers.contains(99));

        CustomLinkedList<String> words = new CustomLinkedList<>("Java")
                .add("Generics")
                .add("Recursion");

        System.out.println("\nStrings:  " + words);
        System.out.println("Reversed: " + words.reverse());
    }
}