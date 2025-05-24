package com.example.englishcenter.services.iservices;

import com.example.englishcenter.dtos.NguoiLopHocDTO;
import com.example.englishcenter.Responses.NguoiDungInLopHocResponse;
import com.example.englishcenter.models.NguoiLopHoc;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.LopHoc;

import java.util.List;

public interface INguoiLopHocService {
    NguoiLopHoc addNguoiVaoLop(Long maNguoiDung, Long maLop);

    // Sửa thông tin người dùng trong lớp (ví dụ: điểm số, trạng thái)
    NguoiLopHoc updateNguoiLopHoc(Long maNguoiDung, Long maLop, NguoiLopHocDTO nguoiLopHocDTO);

    // Xóa người dùng khỏi lớp
    void removeNguoiRaKhoiLop(Long maNguoiDung, Long maLop);

    // Lấy danh sách người dùng trong một lớp
    List<NguoiDung> getNguoiLopHocByLop(Long maLop);

    // Lấy danh sách các lớp mà người dùng đang học hoặc đã học
    List<NguoiLopHoc> getLopHocByNguoi(Long maNguoiDung);
}
