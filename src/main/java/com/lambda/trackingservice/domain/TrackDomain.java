package com.lambda.trackingservice.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "track")
public class TrackDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="orderid")
    private Long orderID;

    @Column(name="status")
    private String status;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;


    @PrePersist
    private void setDefaultDateTime() {
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
    }
}

