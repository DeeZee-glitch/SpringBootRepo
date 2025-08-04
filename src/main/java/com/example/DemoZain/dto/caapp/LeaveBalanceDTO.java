package com.example.DemoZain.dto.caapp;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LeaveBalanceDTO {
    @NotBlank(message = "employeeName cannot be blank")
    @Size(min = 2, message = "employeeName must have at least 2 letters")
    private String employeeName;

    private String leaveType;

    @Min(0)
    private Integer leaveBalance;

    public LeaveBalanceDTO() {
    }
    public LeaveBalanceDTO(String employeeName, String leaveType, Integer leaveBalance) {
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.leaveBalance = leaveBalance;
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

    public String getEmployeeName() {
        return employeeName;
    }

}
