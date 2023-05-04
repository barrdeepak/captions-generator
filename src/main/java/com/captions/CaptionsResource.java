package com.captions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/captions")
public class CaptionsResource {


    /**
     * Health API
     * @return
     */
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        return new ResponseEntity<>("Service is healthy !",HttpStatus.OK);
    }
}
