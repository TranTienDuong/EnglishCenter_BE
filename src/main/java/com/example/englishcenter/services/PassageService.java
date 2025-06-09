package com.example.englishcenter.services;

import com.example.englishcenter.dtos.PassageDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.PassageType;
import com.example.englishcenter.models.Question;
import com.example.englishcenter.models.Passage;
import com.example.englishcenter.repositories.QuestionRepository;
import com.example.englishcenter.repositories.PassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassageService {
    @Autowired
    private PassageRepository passageRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Passage> getAll() {
        return passageRepository.findAll();
    }

    public Optional<Passage> getById(Integer id) {
        return passageRepository.findById(id);
    }
    public Passage create(PassageDTO dto) {
        Passage passage = Passage.builder()
                .tieude(dto.getTieude())
                .noidung(dto.getNoidung())
                .loaidoan(dto.getLoaidoan())
                .dokho(dto.getDokho())
                .audiofile(dto.getAudiofile())
                .thoiluong(dto.getThoiluong())
                .build();
        return passageRepository.save(passage);
    }
    public Passage update(Integer id, PassageDTO dto) {
        Passage passage = passageRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Passage not found with id " + id));
        passage.setTieude(dto.getTieude());
        passage.setNoidung(dto.getNoidung());
        passage.setLoaidoan(dto.getLoaidoan());
        passage.setDokho(dto.getDokho());
        passage.setAudiofile(dto.getAudiofile());
        passage.setThoiluong(dto.getThoiluong());
        return passageRepository.save(passage);
    }

    public Passage createOrUpdate(PassageDTO dto) {
        Passage doanThi = Passage.builder()
                .madoan(dto.getMadoan())
                .tieude(dto.getTieude())
                .noidung(dto.getNoidung())
                .loaidoan(dto.getLoaidoan())
                .dokho(dto.getDokho())
                .audiofile(dto.getAudiofile())
                .thoiluong(dto.getThoiluong())
                .build();
        return passageRepository.save(doanThi);
    }

    public Boolean delete(Integer id) {
        try {
            passageRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Passage> getByTypeAndDifficulty(PassageType loaidoan, Integer dokho) {
        List<Passage> doanThis = passageRepository.findByLoaidoanAndDokho(loaidoan, dokho);
        return doanThis.stream().map(doanThi -> {
            List<Question> cauHois = questionRepository.findByMadoan(doanThi);
            doanThi.setCauhois(cauHois);
            return doanThi;
        }).collect(Collectors.toList());
    }
}
