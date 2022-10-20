package maluevartem.secure_application.service;

import maluevartem.secure_application.repository.LibraryApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryApplicationService {

    private final LibraryApplicationRepository repository;

    @Autowired
    public LibraryApplicationService(LibraryApplicationRepository repository) {
        this.repository = repository;
    }

    public String hello() {
        return repository.hello();
    }
    public String welcome() {
        return repository.welcome();
    }

    public String read() {
        return repository.read();
    }

    public String write() {
        return repository.write();
    }

    public String delete() {
        return repository.delete();
    }
}
