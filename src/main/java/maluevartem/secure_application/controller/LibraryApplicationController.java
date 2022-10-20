package maluevartem.secure_application.controller;

import maluevartem.secure_application.service.LibraryApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/library")
public class LibraryApplicationController {

    private final LibraryApplicationService service;

    @Autowired
    public LibraryApplicationController(LibraryApplicationService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return service.hello();
    }

    @GetMapping("/welcome")
    public String welcome() {
        return service.welcome();
    }

    @GetMapping("/read")
    public String read() {
        return service.read();
    }

    @GetMapping("/write")
    public String write() {
        return service.write();
    }

    @GetMapping("delete")
    public String delete() {
        return service.delete();
    }

}
