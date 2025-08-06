package com.example.DemoZain.service.caapp;

import com.example.DemoZain.model.caapp.LeaveBalance; // Your entity
import com.example.DemoZain.dto.caapp.LeaveBalanceDTO;
import com.example.DemoZain.repository.caapp.LeaveRecordRepository;
import com.example.DemoZain.service.caapp.LeaveService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

    public class LeaveServiceTest {

        @Mock
        private LeaveRecordRepository leaveRecordRepository;

        @InjectMocks
        private LeaveService leaveService;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void testFindLeaveRecordByIdExists() {
            LeaveBalance entity = new LeaveBalance(1L, "Zainul", "Sick", 10);

            when(leaveRecordRepository.findById(1L)).thenReturn(Optional.of(entity));

            Optional<LeaveBalanceDTO> result = leaveService.findById(1L);

            assertTrue(result.isPresent());
            assertEquals("Zainul", result.get().getEmployeeName());
            assertEquals("Sick", result.get().getLeaveType());
            assertEquals(10, result.get().getLeaveBalance());
        }

        @Test
        void testFindLeaveRecordByIdNotExists() {
            when(leaveRecordRepository.findById(2L)).thenReturn(Optional.empty());

            Optional<LeaveBalanceDTO> result = leaveService.findById(2L);

            assertTrue(result.isEmpty());
        }
    }