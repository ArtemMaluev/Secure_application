package maluevartem.secure_application.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryApplicationRepository {

    @Autowired
    public LibraryApplicationRepository() {}

    public String hello() {
        return "Привет пользователь";
    }

    public String welcome() {
        return "Добро пожаловать в библиотеку";
    }

    public String read() {
        return "Доступ к чтению книг открыт";
    }

    public String write() {
        return "Доступ к записи книг открыт";
    }

    public String delete() {
        return "Доступ к удалению книг открыт";
    }
}
