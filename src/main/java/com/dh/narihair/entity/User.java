package com.dh.narihair.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "com_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Auditing{
    String name;
    String phone;
    String memo;

    @Builder
    public User(String name, String phone, String memo) {
        this.name = name;
        this.phone = phone;
        this.memo = memo;
    }
}
