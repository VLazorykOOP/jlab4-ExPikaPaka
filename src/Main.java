import java.io.*;
import java.util.*;

public class Main {



    public static void task1() {
        // Task1_6

        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = new ArrayList<>();

        // Введення назви вхідного файлу
        System.out.print("Введіть назву вхідного файлу: ");
        String inputFilename = scanner.nextLine();

        // Читання даних з вхідного файлу
        try {
            File inputFile = new File(inputFilename);
            Scanner fileScanner = new Scanner(inputFile);
            while (fileScanner.hasNext()) {
                double number = Double.parseDouble(fileScanner.next());
                numbers.add(number);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Помилка: файл не знайдено.");
            task1();
            return;
        }

        // Обробка даних
        System.out.println("Початковий масив:\n" + numbers);
        numbers.sort(Collections.reverseOrder());
        System.out.println("Відсортований масив:\n" + numbers);


        double sum = 0;
        int count = Math.min(10, numbers.size());
        for (int i = 0; i < count; i++) {
            sum += numbers.get(i);
        }

        // Запис суми та чисел у вихідний файл
        System.out.print("Введіть назву вихідного файлу для запису суми та компонент: ");
        String outputFilename = scanner.nextLine();
        try {
            File outputFile = new File(outputFilename);
            int choice = 0;
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            } else {
                while (choice != 1 && choice != 2) {
                    System.out.println("Файл вже існує.   Перезаписати (1)   Додати (2):");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile, choice != 1 ));
            writer.println("Сума найбільших " + count + " чисел: " + sum);
            writer.println("Числа, з яких було обраховано суму:");
            for (int i = count - 1; i >= 0; i--) {
                writer.println(numbers.get(i));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Помилка запису до файлу.");
            return;
        }

        // Запис чисел у вихідний файл
        System.out.print("Введіть назву вихідного файлу для запису відсортованих чисел: ");
        outputFilename = scanner.nextLine();
        try {
            int choice = 0;
            File outputFile = new File(outputFilename);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            } else {
                while (choice != 1 && choice != 2) {
                    System.out.println("Файл вже існує.   Перезаписати (1)   Додати (2):");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile, choice != 1 ));
            for (Double number : numbers) {
                writer.println(number);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Помилка запису до файлу.");
            return;
        }

        System.out.println("Результати успішно записані до файлів.");
    }
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до вхідного файлу: ");
        String inputFilename = scanner.nextLine();
        System.out.print("Введіть шлях до вихідного файлу: ");
        String outputFilename = scanner.nextLine();

        try {
            File inputFile = new File(inputFilename);
            Scanner fileScanner = new Scanner(inputFile);

            int choice = 0;
            File outputFile = new File(outputFilename);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            } else {
                while (choice != 1 && choice != 2) {
                    System.out.println("Файл вже існує.   Перезаписати (1)   Додати (2):");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile, choice != 1 ));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    // видаляємо зайві пробіли між словами
                    line = line.replaceAll("\\s+", " ");
                    writer.println(line);
                }
            }

            fileScanner.close();
            writer.close();
            System.out.println("Операція завершена успішно!");

        } catch (FileNotFoundException e) {
            System.out.println("Помилка: файл не знайдено.");
        } catch (IOException e) {
            System.out.println("Помилка введення/виведення.");
        }
    }

    public static void main(String[] args) {
        System.out.println(" Lab4 Java ");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Введіть номер завдання (1-2, 3 для завершення): ");
            choice = Integer.parseInt(scanner.next());

            if(choice == 1) {
                task1();
            }
            if(choice == 2) {
                task2();
            }
        }
    }
}
