package com.jsggun.api.accHistory;

import com.jsggun.api.accHistory.model.AccHistoryDto;
import com.jsggun.api.accHistory.service.AccHistoryService;
import com.jsggun.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accHistories")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AccHistoryController {

    private final AccHistoryService service;

    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody AccHistoryDto accHistoryDto){
        return ResponseEntity.ok(service.save(accHistoryDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam long id){
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccHistoryDto>> findAll(@RequestParam Long id){
        return ResponseEntity.ok(service.findByAccount(id));
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<AccHistoryDto>> findById(@RequestParam long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@RequestParam long id){
        return ResponseEntity.ok(service.existsById(id));
    }

}