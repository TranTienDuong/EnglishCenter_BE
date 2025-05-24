package com.example.englishcenter.services.iservices;

import com.example.englishcenter.dtos.TuVanDTO;
import com.example.englishcenter.models.TuVan;

import java.util.List;

public interface ITuVanService {
    TuVan createTuVan(TuVanDTO tuVanDTO);
    TuVan getTuVanById(Long MaTuVan);
    List<TuVan> getAllTuVan();
    TuVan updateTuVan(long MaTuVan,TuVanDTO tuVanDTO);
    void deleteTuVan(long MaTuVan);
}
