package com.example.DemoZain.repository.zain;

import com.example.DemoZain.model.caapp.LeaveBalance;
import com.example.DemoZain.model.zain.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
