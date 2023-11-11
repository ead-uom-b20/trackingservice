package com.lambda.trackingservice.repository;

import com.lambda.trackingservice.domain.TrackDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<TrackDomain, Long> {
}
