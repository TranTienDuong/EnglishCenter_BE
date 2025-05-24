package com.example.englishcenter.services;

import com.example.englishcenter.Responses.ChucVuResponse;
import com.example.englishcenter.dtos.ChucVuDTO;
import com.example.englishcenter.models.ChucVu;
import com.example.englishcenter.models.LoaiChucVu;
import com.example.englishcenter.repositories.ChucVuRepository;
import com.example.englishcenter.repositories.LoaiChucVuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChucVuService {


    private final ChucVuRepository chucVuRepository;
    private final LoaiChucVuRepository loaiChucVuRepository;
    private final ModelMapper modelMapper;

    public List<ChucVuResponse> getAllChucVu() {
        return chucVuRepository.findAll().stream().map(chucVu -> {
            return ChucVuResponse.builder()
                    .machucvu(chucVu.getMachucvu())
                    .tenchucvu(chucVu.getTenchucvu())
                    .luong(chucVu.getLuong())
                    .maloaichucvu(chucVu.getLoaiChucvu().getMaloaichucvu())
                    .build();
        }).collect(Collectors.toList());
    }

    public Optional<ChucVu> getChucVuById(int id) {
        return chucVuRepository.findById(id);
    }

    public ChucVu getChucVuByTenchucvu(String tenchucvu) {
        return chucVuRepository.findByTenchucvu(tenchucvu);
    }

    public ChucVu createChucVu(ChucVuDTO chucVuDTO) {
        LoaiChucVu existingLoaiChucVu = loaiChucVuRepository.findById(chucVuDTO.getMaloaichucvu()).get();

        ChucVu chucVu = ChucVu.builder()
                .tenchucvu(chucVuDTO.getTenchucvu())
                .luong(chucVuDTO.getLuong())
                .loaiChucvu(existingLoaiChucVu)
                .build();
        return chucVuRepository.save(chucVu);
    }

    public ChucVu updateChucVu(int id, ChucVuDTO chucVuDTO) {
        LoaiChucVu existingLoaiChucVu = loaiChucVuRepository.findById(chucVuDTO
                .getMaloaichucvu()).get();
        ChucVu existingChucVu = chucVuRepository.findById(id).get();

        existingChucVu.setTenchucvu(chucVuDTO.getTenchucvu());
        existingChucVu.setLuong(chucVuDTO.getLuong());
        existingChucVu.setLoaiChucvu(existingLoaiChucVu);

        return chucVuRepository.save(existingChucVu);

    }

    public void deleteChucVu(int id) {
        chucVuRepository.deleteById(id);
    }
}
