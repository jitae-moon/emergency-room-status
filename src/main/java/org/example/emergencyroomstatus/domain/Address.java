package org.example.emergencyroomstatus.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Entity
public class Address extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String sido;

    @Column(nullable = false)
    private String sigungu;

    @OneToMany
    @ToString.Exclude
    private Set<EmergencyRoom> emergencyRooms = new LinkedHashSet<>();

    protected Address() { }

    @Builder
    public Address(String sido, String sigungu) {
        this.sido = sido;
        this.sigungu = sigungu;
    }

}
