package com.example.englishcenter.services;

import com.example.englishcenter.dtos.LoaiChucVuDTO;
import com.example.englishcenter.models.LoaiChucVu;
import com.example.englishcenter.repositories.LoaiChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiChucVuService {

    @Autowired
    private LoaiChucVuRepository loaiChucVuRepository;

    public List<LoaiChucVu> getAllLoaiChucVu() {
        return loaiChucVuRepository.findAll();
    }

    public Optional<LoaiChucVu> getLoaiChucVuById(int id) {
        return loaiChucVuRepository.findById(id);
    }

    public LoaiChucVu createLoaiChucVu(LoaiChucVuDTO loaiChucVuDTO) {
        LoaiChucVu loaiChucVu = LoaiChucVu.builder()
                .tenloaichucvu(loaiChucVuDTO.getTenloaichucvu())
                .build();

        return loaiChucVuRepository.save(loaiChucVu);
    }

    public LoaiChucVu updateLoaiChucVu(int id, LoaiChucVuDTO loaiChucVuDTO) {
        if (loaiChucVuRepository.existsById(id)) {
            LoaiChucVu loaiChucVu = loaiChucVuRepository.findById(id).get();
            loaiChucVu.setTenloaichucvu(loaiChucVuDTO.getTenloaichucvu());
            return loaiChucVuRepository.save(loaiChucVu);
        }
        return null;
    }

    public void deleteLoaiChucVu(int id) {
        loaiChucVuRepository.deleteById(id);
    }
}
