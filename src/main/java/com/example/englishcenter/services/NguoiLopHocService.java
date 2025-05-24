package com.example.englishcenter.services;

import com.example.englishcenter.dtos.NguoiLopHocDTO;
import com.example.englishcenter.models.NguoiLopHoc;
import com.example.englishcenter.models.NguoiLopHocId;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.repositories.NguoiLopHocRepository;
import com.example.englishcenter.repositories.NguoiDungRepository;
import com.example.englishcenter.repositories.LopHocRepository;
import com.example.englishcenter.services.iservices.INguoiLopHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NguoiLopHocService implements INguoiLopHocService {

    private final NguoiLopHocRepository nguoiLopHocRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final LopHocRepository lopHocRepository;

    @Override
    public NguoiLopHoc addNguoiVaoLop(Long maNguoiDung, Long maLop) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(maNguoiDung)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        LopHoc lopHoc = lopHocRepository.findById(maLop)
                .orElseThrow(() -> new RuntimeException("Lớp học không tồn tại"));

        NguoiLopHoc nguoiLopHoc = new NguoiLopHoc();
        nguoiLopHoc.setNguoiDung(nguoiDung);
        nguoiLopHoc.setLopHoc(lopHoc);
        nguoiLopHoc.setTrangThai("Đang Học");
        nguoiLopHoc.setDiemkiemtra(null);
        nguoiLopHoc.setDiemcuoiki(null);
        nguoiLopHoc.setUudai(null);

        return nguoiLopHocRepository.save(nguoiLopHoc);
    }



    @Override
    public NguoiLopHoc updateNguoiLopHoc(Long maNguoiDung, Long maLop, NguoiLopHocDTO nguoiLopHocDTO) {
        NguoiLopHoc nguoiLopHoc = nguoiLopHocRepository.findById(new NguoiLopHocId(maNguoiDung, maLop))
                .orElseThrow(() -> new RuntimeException("Người trong lớp không tồn tại"));
        nguoiLopHoc.setDiemkiemtra(nguoiLopHocDTO.getDiemKiemTra());
        nguoiLopHoc.setDiemcuoiki(nguoiLopHocDTO.getDiemCuoiki());
        nguoiLopHoc.setTrangThai(nguoiLopHocDTO.getTrangThai());

        return nguoiLopHocRepository.save(nguoiLopHoc);
    }

    @Override
    public void removeNguoiRaKhoiLop(Long maNguoiDung, Long maLop) {
        NguoiLopHoc nguoiLopHoc = nguoiLopHocRepository.findById(new NguoiLopHocId(maNguoiDung, maLop))
                .orElseThrow(() -> new RuntimeException("Người trong lớp không tồn tại"));

        nguoiLopHocRepository.delete(nguoiLopHoc);
    }

    @Override
    public List<NguoiDung> getNguoiLopHocByLop(Long maLop) {
        return nguoiLopHocRepository.findNguoiDungByLopHoc(maLop);
    }

    @Override
    public List<NguoiLopHoc> getLopHocByNguoi(Long maNguoiDung) {
        return nguoiLopHocRepository.findNguoiDungBy_MaNguoiDung(maNguoiDung);
    }

    public void chuyenLop(Long maNguoiDung, Long maLopCu, Long maLopMoi) {
        NguoiDung nguoiDung = nguoiDungRepository.findById(maNguoiDung)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
        LopHoc lopCu = lopHocRepository.findById(maLopCu)
                .orElseThrow(() -> new RuntimeException("Lớp cũ không tồn tại"));
        LopHoc lopMoi = lopHocRepository.findById(maLopMoi)
                .orElseThrow(() -> new RuntimeException("Lớp mới không tồn tại"));

        NguoiLopHocId idCu = new NguoiLopHocId(maNguoiDung, maLopCu);
        NguoiLopHoc nguoiLopHocCu = nguoiLopHocRepository.findById(idCu)
                .orElseThrow(() -> new RuntimeException("Người học không có trong lớp cũ!"));

        // Cập nhật trạng thái lớp cũ
        nguoiLopHocCu.setTrangThai("Chuyển Lớp");
        nguoiLopHocRepository.save(nguoiLopHocCu);

        // Kiểm tra xem người học đã từng được thêm vào lớp mới chưa
        NguoiLopHocId idMoi = new NguoiLopHocId(maNguoiDung, maLopMoi);
        Optional<NguoiLopHoc> optionalNguoiLopHocMoi = nguoiLopHocRepository.findById(idMoi);

        if (optionalNguoiLopHocMoi.isPresent()) {
            NguoiLopHoc nguoiLopHocMoi = optionalNguoiLopHocMoi.get();
            // Nếu đang ở trạng thái Chuyển Lớp thì cập nhật lại thành Đang Học
            if ("Chuyển Lớp".equalsIgnoreCase(nguoiLopHocMoi.getTrangThai())) {
                nguoiLopHocMoi.setTrangThai("Đang Học");
                nguoiLopHocRepository.save(nguoiLopHocMoi);
            }
        } else {
            // Nếu chưa từng có thì thêm mới
            NguoiLopHoc nguoiLopHocMoi = new NguoiLopHoc();
            nguoiLopHocMoi.setNguoiDung(nguoiDung);
            nguoiLopHocMoi.setLopHoc(lopMoi);
            nguoiLopHocMoi.setTrangThai("Đang Học");
            nguoiLopHocMoi.setDiemkiemtra(null);
            nguoiLopHocMoi.setDiemcuoiki(null);
            nguoiLopHocMoi.setUudai(null);

            nguoiLopHocRepository.save(nguoiLopHocMoi);
        }
    }




}
