package com.dh.narihair.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "reservation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends Auditing{
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    User user;

}
