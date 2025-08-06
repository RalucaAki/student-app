package org.opri.persistance;

import org.opri.persistance.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page; //*
import org.springframework.data.domain.Pageable; //*

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    //*
    Page<House> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String titleKeyword,
            String descriptionKeyword,
            Pageable pageable
    );
    //*
    Page<House> findByUploaderId(Long uploaderId, Pageable pageable);
}

