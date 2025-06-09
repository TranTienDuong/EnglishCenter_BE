package com.example.englishcenter.dtos;


import com.example.englishcenter.models.Passage;
import com.example.englishcenter.models.PassageType;
import com.example.englishcenter.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassageDTO {
    private Integer madoan ;
    private String tieude;
    private String noidung;
    private PassageType loaidoan;
    private Integer dokho;
    private String audiofile;
    private Integer thoiluong;
    private List<Question> cauhois;

    public PassageDTO(Passage passage) {
        this.madoan = passage.getMadoan();
        this.tieude = passage.getTieude();
        this.noidung = passage.getNoidung();
        this.loaidoan = passage.getLoaidoan();
        this.dokho = passage.getDokho();
        this.audiofile = passage.getAudiofile();
        this.thoiluong = passage.getThoiluong();
    }
}
