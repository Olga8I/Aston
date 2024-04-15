package lesson_5;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {
                "яблоко", "банан", "яблоко",
                "апельсин", "киви", "банан",
                "лимон", "апельсин", "грейпфрут", "киви"};

        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            uniqueWords.add(word);
        }

        System.out.println("Список уникальных слов:");
        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord);
        }

        System.out.println("\nКоличество встреч каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+375 29 111 11 11");
        phoneBook.add("Петров", "+375 29 333 33 33");
        phoneBook.add("Сидоров", "+375 29 555 55 55");

        System.out.println("\nТелефонный справочник:");
        System.out.println("Номер Иванова: " + phoneBook.get("Иванов") +
                "\n" + "Номер Петрова: " + phoneBook.get("Петров") +
                "\n" + "Номер Сидорова: " + phoneBook.get("Сидоров"));
    }
}

