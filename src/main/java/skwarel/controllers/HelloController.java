package skwarel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skwarel.hello.Hello;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mickael on 08/06/16.
 */

@RestController
public class HelloController {

    private final AtomicLong counter = new AtomicLong();
    @RequestMapping("/hello")
    public Hello hello(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hello(counter.incrementAndGet(),String.format("Bien le salut", name));
    }
}
