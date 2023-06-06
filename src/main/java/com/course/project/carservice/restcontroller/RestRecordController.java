package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.User;
import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.service.RecordService;
import com.course.project.carservice.util.UserRecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rest-record")
public class RestRecordController {
    private final RecordService recordService;

    public RestRecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("{date}")
    public ResponseEntity<List<UserRecord>> findByDate(@PathVariable("date") LocalDate localDate){
        List<UserRecord> allByDate = recordService.findAllByDate(localDate);
        return ResponseEntity.ok(allByDate);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> recordOnService(@RequestBody UserRecord userRecord){
        recordService.save(userRecord);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("{userPhone}")
    public ResponseEntity<List<UserRecord>> findAllByUserPhone(@PathVariable String userPhone){
        List<UserRecord> allByUserPhone = recordService.findAllByUserPhone(userPhone);
        return ResponseEntity.ok(allByUserPhone);
    }

    @GetMapping("{recordId}")
    public ResponseEntity<UserRecord> findCurrentByUser(@PathVariable Long recordId, @AuthenticationPrincipal User user){
        UserRecord byUser = recordService.findByUser(recordId, user.getPhoneNumber());
        return ResponseEntity.ok(byUser);
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @PutMapping("{recordId}")
    public ResponseEntity<UserRecord> updateRecordState(@PathVariable Long recordId, @RequestParam("state") String state){
        UserRecord userRecord = recordService.updateState(recordId, state);
        return ResponseEntity.ok(userRecord);
    }

    @ExceptionHandler
    private ResponseEntity<UserRecordNotFoundException> notFound(UserRecordNotFoundException e){
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
