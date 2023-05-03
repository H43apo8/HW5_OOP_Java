package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Model.Controller;

// Класс Model, который реализует интерфейс iGetModel
public class Model implements iGetModel {
    // Хранилище студентов в виде HashMap
    private HashMap<Long, Student> students;

    // Конструктор класса, инициализирующий хранилище
    public Model() {
        students = new HashMap<Long, Student>();
    }

    // Метод добавления студента в хранилище
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    // Метод удаления студента из хранилища по ID
    public void removeStudent(long id) {
        students.remove(id);
    }

    // Метод получения студента из хранилища по ID
    public Student getStudent(long id) {
        return students.get(id);
    }

    // Метод получения списка всех студентов из хранилища
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }
}

// Интерфейс iGetModel, определяющий методы работы с моделью
public interface iGetModel {
    // Метод добавления студента в модель
    public void addStudent(Student student);
    // Метод удаления студента из модели по ID
    public void removeStudent(long id);
    // Метод получения студента из модели по ID
    public Student getStudent(long id);
    // Метод получения списка всех студентов из модели
    public ArrayList<Student> getAllStudents();
}

// Класс контроллера, который использует класс Model для работы с данными
public class Controller {
    // Экземпляр класса Model
    private Model model;

    // Конструктор класса контроллера, инициализирующий экземпляр класса Model
    public Controller() {
        model = new Model();
    }

    // Метод добавления студента в модель через класс Model
    public void addStudent(Student student) {
        model.addStudent(student);
    }

    // Метод удаления студента из модели по ID через класс Model
    public void removeStudent(long id) {
        model.removeStudent(id);
    }

    // Метод получения студента из модели по ID через класс Model
    public Student getStudent(long id) {
        return model.getStudent(id);
    }

    // Метод получения списка всех студентов из модели через класс Model
    public ArrayList<Student> getAllStudents() {
        return model.getAllStudents();
    }
}
