package com.example.englishcenter.services;

import com.example.englishcenter.dtos.TuVanDTO;
import com.example.englishcenter.services.iservices.ITuVanService;
import com.example.englishcenter.models.TuVan;
import com.example.englishcenter.repositories.TuVanRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TuVanService implements ITuVanService {

    private final TuVanRepository tuVanRepository;
    private final ModelMapper mapper;
    @Override
    public TuVan createTuVan(TuVanDTO tuVanDTO) {
        TuVan tuVan = new TuVan();
        mapper.map(tuVanDTO, tuVan);
        tuVan.setNgaygui(LocalDate.now());
        return tuVanRepository.save(tuVan);
    }

    @Override
    public TuVan getTuVanById(Long MaTuVan) {
        return tuVanRepository.findById(MaTuVan)
                .orElseThrow(()->new RuntimeException("Khong tim thay"));
    }

    @Override
    public List<TuVan> getAllTuVan() {
        return tuVanRepository.findAll();
    }

    @Override
    public TuVan updateTuVan(long MaTuVan, TuVanDTO tuVanDTO) {
        TuVan existingTuVan = getTuVanById(MaTuVan);
        existingTuVan.setHoten(tuVanDTO.getHoten());
        existingTuVan.setNgaygui(tuVanDTO.getNgaygui());
        existingTuVan.setSdt(tuVanDTO.getSdt());
        existingTuVan.setNghenghiep(tuVanDTO.getNghenghiep());
        existingTuVan.setCauhoituvan(tuVanDTO.getCauhoituvan());
        existingTuVan.setTrangthai(tuVanDTO.getTrangthai());
        tuVanRepository.save(existingTuVan);


        return tuVanRepository.save(existingTuVan);
    }

    @Override
    public void deleteTuVan(long MaTuVan) {
        TuVan existingTuVan = getTuVanById(MaTuVan);
        tuVanRepository.delete(existingTuVan);
    }
}
