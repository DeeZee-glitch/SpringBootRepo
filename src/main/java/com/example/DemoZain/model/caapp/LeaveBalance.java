package com.example.DemoZain.model.caapp;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="ALEAVE_BALANCE")
public class LeaveBalance {

    @Id
    @Column(name = "LEAVE_ID")
    private Long leaveId;

    @Column(name = "ENAME")
    private String employeeName;

    @Column(name = "LEAVE_TYPE")
    private String leaveType;

    @Column(name = "LEAVE_BALANCE")
    private Integer leaveBalance;

    public LeaveBalance() {
    }

    public LeaveBalance(Long leaveId, String employeeName, String leaveType, Integer leaveBalance) {
        this.leaveId = leaveId;
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.leaveBalance = leaveBalance;
    }

    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Integer getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(Integer leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
