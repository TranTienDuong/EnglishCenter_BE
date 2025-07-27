package com.example.englishcenter.services;

import com.example.englishcenter.models.PhongHoc;
import com.example.englishcenter.models.ThoiKhoaBieu;
import com.example.englishcenter.repositories.PhongHocRepository;
import com.example.englishcenter.repositories.ThoiKhoaBieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhongHocService {

    @Autowired
    private PhongHocRepository phongHocRepository;
    @Autowired
    private ThoiKhoaBieuRepository thoiKhoaBieuRepository;

    public List<PhongHoc> getAllPhongHocs() {
        return phongHocRepository.findAll();
    }

    public Optional<PhongHoc> getPhongHocById(Integer id) {
        return phongHocRepository.findById(id);
    }

    @Transactional
    public PhongHoc createPhongHoc(PhongHoc phongHoc) {
        // 1. Lưu phòng học mới
        PhongHoc newPhongHoc = new PhongHoc();
        newPhongHoc.setTenphong(phongHoc.getTenphong());
        PhongHoc savedPhongHoc = phongHocRepository.save(newPhongHoc);

        // 2. Tạo thời khóa biểu mặc định cho phòng này
        createDefaultScheduleForNewRoom(savedPhongHoc);

        return savedPhongHoc;
    }
    private void createDefaultScheduleForNewRoom(PhongHoc phongHoc) {
        List<ThoiKhoaBieu> schedules = new ArrayList<>();

        // Tạo thời khóa biểu từ thứ 2 đến thứ 7 (thứ CN không học)
        for (int thu = 2; thu <= 7; thu++) {
            // Ca sáng: 7h-10h
            schedules.add(ThoiKhoaBieu.builder()
                    .thuhoc(thu)
                    .tgbatdau(LocalTime.of(7, 0))
                    .tgketthuc(LocalTime.of(10, 0))
                    .phonghoc(phongHoc)
                    .lophoc(null)
                    .build());

            // Ca chiều: 13h-16h
            schedules.add(ThoiKhoaBieu.builder()
                    .thuhoc(thu)
                    .tgbatdau(LocalTime.of(13, 0))
                    .tgketthuc(LocalTime.of(16, 0))
                    .phonghoc(phongHoc)
                    .lophoc(null)
                    .build());

            // Ca tối: 18h-21h
            schedules.add(ThoiKhoaBieu.builder()
                    .thuhoc(thu)
                    .tgbatdau(LocalTime.of(18, 0))
                    .tgketthuc(LocalTime.of(21, 0))
                    .phonghoc(phongHoc)
                    .lophoc(null)
                    .build());
        }

        // Lưu tất cả vào database
        thoiKhoaBieuRepository.saveAll(schedules);
    }

    public PhongHoc updatePhongHoc(Integer id, PhongHoc phongHoc) {
        Optional<PhongHoc> optional = phongHocRepository.findById(id);
        if (optional.isPresent()) {
            PhongHoc existing = optional.get();
            existing.setTenphong(phongHoc.getTenphong());
            return phongHocRepository.save(existing); // lưu lại đối tượng đã có ID
        }
        return null;
    }

    public void deletePhongHoc(Integer id) {
        phongHocRepository.deleteById(id);
    }
}
