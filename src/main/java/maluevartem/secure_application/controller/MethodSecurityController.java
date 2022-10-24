package maluevartem.secure_application.controller;

import maluevartem.secure_application.service.LibraryApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class MethodSecurityController {

    private final LibraryApplicationService service;

    @Autowired
    public MethodSecurityController(LibraryApplicationService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return service.hello();
    }

    @GetMapping("/welcome")
    @PreAuthorize("#username==authentication.principal.username")
    public String welcome(@RequestParam String username) {
        return service.welcome() + " " + username;
    }

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public String read() {
        return service.read();
    }

    @GetMapping("/write")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String write() {
        return service.write();
    }

    @GetMapping("delete")
    @RolesAllowed("ROLE_DELETE")
    public String delete() {
        return service.delete();
    }

}
