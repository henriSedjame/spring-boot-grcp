package io.github.hsedjame.grcpclient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record GrcpClientController(GrcpClientService service) {

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>(service.ping(), HttpStatus.OK);
    }
}
