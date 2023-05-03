package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Model;
import View.View;

public class Controller {

    private List<Student> students; 
    private iGetView view;
    private iGetModel model;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();
    } 

    public void getAllStudent()
    {
        students = model.getAllStudent();
    }

    public boolean testData()
    {
        if(students.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void updateView()
    {
        //MVP
        getAllStudent();
        if(testData())
        {
            view.printAllStudent(students);
        }
        else{
            System.out.println("Список студентов пуст!");
        }
        
        //MVC
        //view.printAllStudent(model.getAllStudent());
    }

    public void run()
    {
        Commands com = Commands.NONE;
        boolean getNewIteration = true;
        while(getNewIteration)
        {
            String command = view.prompt("Введите команду:");
            com = Commands.valueOf(command.toUpperCase());
            switch(com)
            {
                case EXIT:
                    getNewIteration=false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    getAllStudent();
                    updateView();
                    break;
            }

        }
    }

}
// Добавляем команду DELETE в метод run класса контроллера
public class Controller {
    private Model model = new Model();
    private View view = new View();

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