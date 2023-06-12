package com.captions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/captions")
public class CaptionsResource {

    /**
     * Health API
     * @return
     */
    @GetMapping("/health")
    public ResponseEntity<?> health() {
        DataManager dataManager = DataManager.getInstance();
        return new ResponseEntity<>("Service is healthy !",HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> search(@RequestParam("input") String input) {
        CaptionSearchAPI searchAPI = new CaptionSearchAPI();
        List<String> captions = searchAPI.search(input);
        System.out.println("captions = " + captions);
        return ResponseEntity.ok(new CaptionOutput(captions.size(), captions));
    }

}
