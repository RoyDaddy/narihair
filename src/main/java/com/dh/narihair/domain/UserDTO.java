package com.dh.narihair.domain;

import com.dh.narihair.entity.Auditing;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDTO implements Serializable {
    String name;
    String phone;
    String memo;
    LocalDateTime createdAt;
    long resCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate endDate;
}
