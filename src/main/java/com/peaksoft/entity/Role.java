package com.peaksoft.entity;

import javax.persistence.*;
import lombok.*;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName;
}
