package com.example.englishcenter.services.iservices;

import com.example.englishcenter.Responses.NguoiDungResponse;
import com.example.englishcenter.dtos.NguoiDungDTO;
import com.example.englishcenter.models.NguoiDung;

import java.util.List;

public interface INguoiDungService {
    NguoiDung createNguoiDung(NguoiDungDTO nguoiDungDTO);
    NguoiDung getNguoiDungById(Long MaNguoiDung);
    List<NguoiDungResponse> getAllNguoiDung();
    NguoiDung updateNguoiDung(long MaNguoiDung,NguoiDungDTO nguoiDungDTO);
    void deleteNguoiDung(long MaNguoiDung);

    List<NguoiDung> getALLGiaoVien();
    List<NguoiDung> getAllHocVien();

    void updateAllUsernames();
}
