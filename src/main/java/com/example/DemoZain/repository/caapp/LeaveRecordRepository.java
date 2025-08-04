package com.example.DemoZain.repository.caapp;

import com.example.DemoZain.model.caapp.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRecordRepository extends JpaRepository<LeaveBalance, Long> {
}
