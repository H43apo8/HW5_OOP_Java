package View;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.Class;


//Сделать вариант класса ViewEng с текстом на английском языке, подключить к нему интерфейс iGetView. Класс ViewEng подключить к контроллеру.

// Создаем класс ViewEng с текстом на английском языке
public class ViewEng implements iGetView {
    private String text = "Hello, world!";

    // Реализуем метод интерфейса iGetView для получения текста
    @Override
    public String getView() {
        return text;
    }
}

// Интерфейс iGetView для получения текста
public interface iGetView {
    String getView();
}

// Подключаем класс ViewEng к контроллеру
public class Controller {
    private ViewEng view = new ViewEng();

    // Другие методы контроллера
}

// Класс View для отображения информации пользователю
public class View {
    public void showMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Get student list");
        System.out.println("3. Get student information");
        System.out.println("4. Edit student information");
        System.out.println("5. Delete student");
        System.out.println("6. Exit");
    }

    public void showDeleteStudent() {
        System.out.println("Enter student ID to delete:");
    }

    public void showSuccessDelete() {
        System.out.println("Student deleted successfully.");
    }

    public void showErrorDelete() {
        System.out.println("Error deleting student.");
    }

    public void showInvalidInput() {
        System.out.println("Invalid input. Please try again.");
    }
}

// Класс-контроллер для управления программой
public class Controller {
    private Model model = new Model();
    private View view = new View();

    // Метод для запуска программы
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            view.showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Добавление студента
                    break;
                case 2:
                    // Получение списка студентов
                    break;
                case 3:
                    // Получение информации о студенте
                    break;
                case 4:
                    // Редактирование информации о студенте
                    break;
                case 5:
                    // Удаление студента
                    view.showDeleteStudent();
                    long studentId = scanner.nextLong();
                    boolean isDeleted = model.deleteStudent(studentId);
                    if (isDeleted) {
                        view.showSuccessDelete();
                    } else {
                        view.showErrorDelete();
                    }
                    break;
                case 6:
                    // Выход из программы
                    isRunning = false;
                    break;
                default:
                    // Некорректный ввод
                    view.showInvalidInput();
                    break;
            }
        }
    }
}

// Класс Model для работы с данными
public class Model implements iGetModel {
    private HashMap<Long, Student> storage = new HashMap<>();

    // Реализуем метод интерфейса iGetModel для получения хранилища
    @Override
    public HashMap<Long, Student> getModel() {
        return storage;
    }

    public boolean deleteStudent(long studentId) {
        if (storage.containsKey(studentId)) {
            storage.remove(studentId);
            return true;
        } else {
            return false;
        }
    }

    // Другие методы модели
}

// Интерфейс iGetModel для получения модели данных
public interface iGetModel {
    HashMap<Long, Student> getModel();
}

// Класс Student для хранения информации о студенте
public class Student {
    private long id;
    private String name;
    private int age;

    // Конструктор класса
    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}