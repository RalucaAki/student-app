package org.stdapp.service;

import lombok.RequiredArgsConstructor;
import org.stdapp.dto.HouseRecordDto;
import org.stdapp.persistance.HouseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile; //*

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    private final HouseMapper houseMapper;

    public Page<HouseRecordDto> findAll(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return houseRepository.findAll(pageable)
                .map(houseMapper::toDto);
    }

    public void addHouse(HouseRecordDto houseRecordDto) {
        houseRepository.save(houseMapper.toEntity(houseRecordDto));
    }

    //*
    public void uploadCourse(HouseRecordDto houseRecordDto, MultipartFile file) {
        houseRepository.save(houseMapper.toEntity(houseRecordDto));
    }

    //*
    public Page<HouseRecordDto> searchCourses(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return houseRepository.findAll(pageable)
                .map(houseMapper::toDto);
    }

    //*
    public Page<HouseRecordDto> listCoursesByUser(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return houseRepository.findAll(pageable)
                .map(houseMapper::toDto);
    }

}
