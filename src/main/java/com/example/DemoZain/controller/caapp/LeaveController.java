package com.example.DemoZain.controller.caapp;

import com.example.DemoZain.dto.caapp.LeaveBalanceDTO;
import com.example.DemoZain.service.caapp.LeaveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;
    private final AtomicLong idGenerator = new AtomicLong(1000); // ID generator

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<LeaveBalanceDTO> getAllLeaves() {
        return leaveService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveBalanceDTO> getLeaveById(@PathVariable Long id) {
        Optional<LeaveBalanceDTO> leave = leaveService.findById(id);
        return leave.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveBalanceDTO> createLeave(@Valid @RequestBody LeaveBalanceDTO dto) {
        Long generatedId = idGenerator.getAndIncrement();
        LeaveBalanceDTO savedLeave = leaveService.save(generatedId, dto);
        return ResponseEntity.ok(savedLeave);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LeaveBalanceDTO> updateLeave(@PathVariable Long id,
                                                       @Valid @RequestBody LeaveBalanceDTO dto) {
        Optional<LeaveBalanceDTO> updated = leaveService.update(id, dto);
        return updated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        if (leaveService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
