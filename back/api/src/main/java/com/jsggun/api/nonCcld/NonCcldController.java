package com.jsggun.api.nonCcld;

import com.jsggun.api.common.component.Messenger;
import com.jsggun.api.nonCcld.model.NonCcldDto;
import com.jsggun.api.nonCcld.service.NonCcldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nonCclds")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NonCcldController {
    private final NonCcldService nonCcldService;
    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody NonCcldDto nonCcldDto){
        return ResponseEntity.ok(nonCcldService.save(nonCcldDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam long id){
        return ResponseEntity.ok(nonCcldService.deleteById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<NonCcldDto>> findAll(@RequestParam Long id){
        return ResponseEntity.ok(nonCcldService.findByAccount(id));
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<NonCcldDto>> findById(@RequestParam long id){
        return ResponseEntity.ok(nonCcldService.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(nonCcldService.count());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@RequestParam long id){
        return ResponseEntity.ok(nonCcldService.existsById(id));
    }
}