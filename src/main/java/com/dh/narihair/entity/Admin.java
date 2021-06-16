package com.dh.narihair.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "COM_ADMIN")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends Auditing{
    String id;
    String pw;
    String name;
}
