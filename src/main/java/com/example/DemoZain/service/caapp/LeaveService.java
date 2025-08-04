package com.example.DemoZain.service.caapp;

import com.example.DemoZain.dto.caapp.LeaveBalanceDTO;
import com.example.DemoZain.model.caapp.LeaveBalance;
import com.example.DemoZain.repository.caapp.LeaveRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    private final LeaveRecordRepository leaveRepo;

    public LeaveService(LeaveRecordRepository leaveRepo) {
        this.leaveRepo = leaveRepo;
    }

    public List<LeaveBalanceDTO> findAll() {
        return leaveRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<LeaveBalanceDTO> findById(Long id) {
        return leaveRepo.findById(id)
                .map(this::convertToDTO);
    }

    public LeaveBalanceDTO save(Long leaveId, LeaveBalanceDTO dto) {
        LeaveBalance entity = new LeaveBalance(
                leaveId,
                dto.getEmployeeName(),
                dto.getLeaveType(),
                dto.getLeaveBalance()
        );
        return convertToDTO(leaveRepo.save(entity));
    }

    public Optional<LeaveBalanceDTO> update(Long id, LeaveBalanceDTO dto) {
        return leaveRepo.findById(id).map(leave -> {
            leave.setEmployeeName(dto.getEmployeeName());
            leave.setLeaveType(dto.getLeaveType());
            leave.setLeaveBalance(dto.getLeaveBalance());
            return convertToDTO(leaveRepo.save(leave));
        });
    }

    public boolean delete(Long id) {
        if (leaveRepo.existsById(id)) {
            leaveRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private LeaveBalanceDTO convertToDTO(LeaveBalance entity) {
        return new LeaveBalanceDTO(
                entity.getEmployeeName(),
                entity.getLeaveType(),
                entity.getLeaveBalance()
        );
    }
}
