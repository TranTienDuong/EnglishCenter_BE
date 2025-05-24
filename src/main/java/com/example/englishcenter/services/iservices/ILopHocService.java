package com.example.englishcenter.services.iservices;

import com.example.englishcenter.Responses.LopHocResponse;
import com.example.englishcenter.dtos.LopHocDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.LopHoc;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILopHocService {
    LopHoc getLopHocById(long MaLop) throws Exception;
    List<LopHocResponse> getAllLopHoc();
    ResponseEntity<String> createLopHoc(LopHocDTO LopHoc) throws DataNotFoundException;;
    ResponseEntity<String> deleteLopHocById(long MaLop);
    LopHoc updateLopHoc(long MaLop, LopHocDTO LopHoc) throws Exception;
    public LopHocResponse getLopHocDetails(Long malop);

    LopHoc getLopHocByTenLop(String tenLop);
}
