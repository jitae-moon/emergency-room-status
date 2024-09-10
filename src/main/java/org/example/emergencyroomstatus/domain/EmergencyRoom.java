package org.example.emergencyroomstatus.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Entity
public class EmergencyRoom extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hospitalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private String latitude;

    private String longitude;

    private String category;

    private String mainContact;

    private String directContact;

    protected EmergencyRoom() { }

    @Builder
    public EmergencyRoom(String hospitalId, String name, String address, String latitude, String longitude, String category, String mainContact, String directContact) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.category = category;
        this.mainContact = mainContact;
        this.directContact = directContact;
    }

}
