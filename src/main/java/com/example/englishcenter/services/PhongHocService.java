package com.example.englishcenter.services;

import com.example.englishcenter.models.PhongHoc;
import com.example.englishcenter.repositories.PhongHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongHocService {

    @Autowired
    private PhongHocRepository phongHocRepository;

    public List<PhongHoc> getAllPhongHocs() {
        return phongHocRepository.findAll();
    }

    public Optional<PhongHoc> getPhongHocById(Integer id) {
        return phongHocRepository.findById(id);
    }

    public PhongHoc createPhongHoc(PhongHoc phongHoc) {
        PhongHoc newPhongHoc = new PhongHoc();
        newPhongHoc.setTenphong(phongHoc.getTenphong());
        return phongHocRepository.save(newPhongHoc);
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
