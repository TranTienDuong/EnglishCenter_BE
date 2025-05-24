package com.example.englishcenter.services.iservices;

import com.example.englishcenter.Responses.ThoiKhoaBieuRespone;
import com.example.englishcenter.dtos.ThoiKhoaBieuDTO;
import com.example.englishcenter.models.ThoiKhoaBieu;

import java.util.List;

public interface IThoiKhoaBieuService {
    ThoiKhoaBieuRespone getThoiKhoaById(long MaThoiKhoaBieu);
    List<ThoiKhoaBieuRespone> getAllThoiKhoa();
    ThoiKhoaBieu createThoiKhoaBieu(ThoiKhoaBieuDTO thoiKhoaBieuDTO);
    ThoiKhoaBieu updateThoiKhoaBieu(long MaThoiKhoaBieu, ThoiKhoaBieuDTO thoiKhoaBieuDTO);
    void deleteThoiKhoaBieu(long MaThoiKhoaBieu);
}
