package com.example.englishcenter.services;

import com.example.englishcenter.dtos.DiemDanhDTO;
import com.example.englishcenter.dtos.DiemDanhRequestDTO;
import com.example.englishcenter.dtos.HuyLopDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.DiemDanh;
import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.PhongHoc;
import com.example.englishcenter.repositories.DiemDanhRepository;
import com.example.englishcenter.repositories.LopHocRepository;
import com.example.englishcenter.repositories.NguoiDungRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiemDanhService {

    @Autowired
    private DiemDanhRepository diemDanhRepository;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private LopHocRepository lopHocRepository;
    @Autowired
    private ModelMapper modelMapper;

public DiemDanh createDiemDanh(DiemDanhDTO diemDanhDTO) {
    // Chuyển đổi từ DTO sang Entity
    DiemDanh diemDanh = convertToEntity(diemDanhDTO);

    // Lưu vào database
    return diemDanhRepository.save(diemDanh);
}
    private DiemDanh convertToEntity(DiemDanhDTO dto) {
        DiemDanh entity = new DiemDanh();

        // Chuyển đổi các trường cơ bản
        entity.setMaNguoiDung(dto.getNguoiDung() != null ?
                dto.getNguoiDung().getManguoidung().intValue() : null);

        entity.setMaLop(dto.getLopHoc() != null ?
                dto.getLopHoc().getMalop().intValue() : null);
        entity.setTrangThai(dto.getTrangThai());
        entity.setGhiChu(dto.getGhiChu());
        entity.setIsBu(dto.getIsBu() != null ? dto.getIsBu() : false);

        // Chuyển đổi ngày học từ LocalDate sang Date
        if (dto.getNgayHoc() != null) {
            entity.setNgayHoc(Date.valueOf(dto.getNgayHoc()));
        }

        // Chuyển đổi thời gian từ String sang Time
        if (dto.getThoiGianBatDau() != null) {
            entity.setThoiGianBatDau(Time.valueOf(dto.getThoiGianBatDau()));
        }
        if (dto.getThoiGianKetThuc() != null) {
            entity.setThoiGianKetThuc(Time.valueOf(dto.getThoiGianKetThuc()));
        }

        // Chuyển đổi thời gian điểm danh từ LocalDateTime sang Timestamp
        if (dto.getThoiGianDiemDanh() != null) {
            entity.setThoiGianDiemDanh(Timestamp.valueOf(dto.getThoiGianDiemDanh()));
        }

        return entity;
    }

    @Transactional
    public void updateDiemDanh(DiemDanhRequestDTO request) {
        DiemDanh diemDanh = request.getDiemDanh();

        // Kiểm tra chỉ được cập nhật thành "Có mặt" hoặc "Vắng mặt"
        if (!Arrays.asList("Có mặt", "Vắng mặt", "Đi muộn", "Chưa điểm danh","Hủy lớp").contains(request.getTrangThai())) {
            throw new DataNotFoundException("Chỉ được cập nhật trạng thái thành 'Có mặt' hoặc 'Vắng mặt'");
        }

        diemDanh.setThoiGianDiemDanh(Timestamp.valueOf(LocalDateTime.now()));
        diemDanh.setTrangThai(request.getTrangThai());
        diemDanh.setGhiChu(request.getGhiChu());
        diemDanhRepository.save(diemDanh);
    }

    public List<DiemDanhDTO> getDiemDanh(Integer maGiaoVien, Integer maLop, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        List<DiemDanh> diemDanhList;

        if (maGiaoVien != null && maLop != null && ngayBatDau != null && ngayKetThuc != null) {
            diemDanhList = diemDanhRepository.findByMaNguoiDungAndMaLopAndNgayHocBetween(
                    maGiaoVien, maLop,
                    Date.valueOf(ngayBatDau), Date.valueOf(ngayKetThuc));
        } else if (maGiaoVien != null && ngayBatDau != null && ngayKetThuc != null) {
            diemDanhList = diemDanhRepository.findByMaNguoiDungAndNgayHocBetween(
                    maGiaoVien, Date.valueOf(ngayBatDau), Date.valueOf(ngayKetThuc));
        } else if (maLop != null && ngayBatDau != null && ngayKetThuc != null) {
            diemDanhList = diemDanhRepository.findByMaLopAndNgayHocBetween(
                    maLop, Date.valueOf(ngayBatDau), Date.valueOf(ngayKetThuc));
        } else if (ngayBatDau != null && ngayKetThuc != null) {
            diemDanhList = diemDanhRepository.findByNgayHocBetween(
                    Date.valueOf(ngayBatDau), Date.valueOf(ngayKetThuc));
        } else if (maGiaoVien != null) {
            diemDanhList = diemDanhRepository.findByMaNguoiDung(maGiaoVien);
        } else if (maLop != null) {
            diemDanhList = diemDanhRepository.findByMaLop(maLop);
        } else {
            diemDanhList = diemDanhRepository.findAll();
        }

        return diemDanhList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DiemDanhDTO convertToDTO(DiemDanh diemDanh) {
        return DiemDanhDTO.builder()
                .maDiemDanh(diemDanh.getMaDiemDanh())
                .nguoiDung(diemDanh.getNguoiDung())
                .lopHoc(diemDanh.getLopHoc())
                .ngayHoc(diemDanh.getNgayHoc() != null ? diemDanh.getNgayHoc().toLocalDate() : null)
                .thoiGianBatDau(diemDanh.getThoiGianBatDau() != null ? diemDanh.getThoiGianBatDau().toString() : null)
                .thoiGianKetThuc(diemDanh.getThoiGianKetThuc() != null ? diemDanh.getThoiGianKetThuc().toString() : null)
                .trangThai(diemDanh.getTrangThai())
                .thoiGianDiemDanh(diemDanh.getThoiGianDiemDanh() != null ?
                        diemDanh.getThoiGianDiemDanh().toLocalDateTime() : null)
                .ghiChu(diemDanh.getGhiChu())
                .isBu(diemDanh.getIsBu() != null ? diemDanh.getIsBu() : false)
                .build();
    }
}