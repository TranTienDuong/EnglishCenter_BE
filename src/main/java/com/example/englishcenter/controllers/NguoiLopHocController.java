package com.example.englishcenter.controllers;

import com.example.englishcenter.dtos.NguoiLopHocDTO;
import com.example.englishcenter.exceptions.DataNotFoundException;
import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.NguoiLopHoc;
import com.example.englishcenter.models.NguoiLopHocId;
import com.example.englishcenter.repositories.LopHocRepository;
import com.example.englishcenter.repositories.NguoiLopHocRepository;
import com.example.englishcenter.services.NguoiDungService;
import com.example.englishcenter.services.LopHocService;
import com.example.englishcenter.services.NguoiLopHocService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/nguoilophoc")
@RequiredArgsConstructor
public class NguoiLopHocController {
    private final NguoiDungService nguoiDungService;
    private final LopHocService lopHocService;
    private final NguoiLopHocRepository nguoiLopHocRepository;
    private final NguoiLopHocService nguoiLopHocService;

    // Thêm người dùng đã có vào lớp
    @PostMapping("/{maNguoiDung}/{maLop}")
    public ResponseEntity<?> themNguoiVaoLop(@PathVariable Long maNguoiDung,
                                             @PathVariable Long maLop) {
        // Kiểm tra xem người dùng có đang học lớp khác không hoặc đã có trong lớp này chưa
        NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(maNguoiDung);
        LopHoc lopHoc = lopHocService.getLopHocById(maLop);

        if (nguoiDung == null || lopHoc == null) {
            return ResponseEntity.badRequest().body("Người dùng hoặc lớp không tồn tại!");
        }

        // Kiểm tra người dùng có đang học lớp khác không
        List<NguoiLopHoc> nguoiLopHocList = nguoiLopHocRepository.findByNguoiDungAndTrangThai(nguoiDung, "Đang Học");

        // Kiểm tra người dùng đã có trong lớp này chưa
        boolean isExist = nguoiLopHocRepository.existsByNguoiDungAndLopHoc(nguoiDung, lopHoc);
        if (isExist) {
            return ResponseEntity.badRequest().body("Người dùng đã có trong lớp này!");
        }

        if (!nguoiLopHocList.isEmpty()) {
            return ResponseEntity.badRequest().body("Người dùng đã đang học lớp khác.");
        }

        // Nếu không có lỗi, gọi service để thêm người vào lớp
        nguoiLopHocService.addNguoiVaoLop(maNguoiDung, maLop);

        return ResponseEntity.ok("Đã thêm người vào lớp!");
    }

    @PostMapping("/chuyenlop/{maNguoiDung}/{maLopCu}/{maLopMoi}")
    public ResponseEntity<?> chuyenLop(@PathVariable Long maNguoiDung,
                                       @PathVariable Long maLopCu,
                                       @PathVariable Long maLopMoi) {
        try {
            nguoiLopHocService.chuyenLop(maNguoiDung, maLopCu, maLopMoi);
            return ResponseEntity.ok("Chuyển lớp thành công!");
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    // Sửa thông tin và trạng thái của người dùng trong lớp
    @PutMapping("/{maNguoiDung}/{maLop}")
    public ResponseEntity<?> capNhatThongTinNguoiLop(@PathVariable Long maNguoiDung,
                                                     @PathVariable Long maLop,
                                                     @RequestBody NguoiLopHocDTO nguoiLopHocDTO) {
        NguoiLopHocId id = new NguoiLopHocId(maNguoiDung, maLop);
        NguoiLopHoc nguoiLopHoc = nguoiLopHocRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy người trong lớp!"));

        nguoiLopHoc.setTrangThai(nguoiLopHocDTO.getTrangThai());
        nguoiLopHoc.setDiemkiemtra(nguoiLopHocDTO.getDiemKiemTra());
        nguoiLopHoc.setDiemcuoiki(nguoiLopHocDTO.getDiemCuoiki());

        nguoiLopHocRepository.save(nguoiLopHoc);

        return ResponseEntity.ok("Cập nhật thông tin người trong lớp thành công!");
    }

    // Xóa người dùng khỏi lớp
    @DeleteMapping("/{maNguoiDung}/{maLop}")
    public ResponseEntity<String> xoaNguoiKhoiLop(@PathVariable Long maNguoiDung,
                                                  @PathVariable Long maLop) {
        NguoiLopHocId id = new NguoiLopHocId(maNguoiDung, maLop);
        NguoiLopHoc nguoiLopHoc = nguoiLopHocRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Không tìm thấy người trong lớp!"));

        nguoiLopHocRepository.delete(nguoiLopHoc);

        return ResponseEntity.ok("Đã xóa người khỏi lớp!");
    }


    // Lấy danh sách người dùng theo lớp
    @GetMapping("/dshs-lop/{maLop}")
    public ResponseEntity<List<NguoiDung>> getNguoiTheoLop(@PathVariable Long maLop) {
        LopHoc lopHoc = lopHocService.getLopHocById(maLop);
        if (lopHoc == null) {
            throw new DataNotFoundException("Không tìm thấy lớp!");
        }

        List<NguoiDung> nguoiDungList = nguoiLopHocRepository.findNguoiDungByLopHoc(maLop);
        return ResponseEntity.ok(nguoiDungList);
    }


    // Lấy thông tin các lớp người dùng đang học hoặc đã học
    @GetMapping("/dslop-hs/{maNguoiDung}")
    public ResponseEntity<List<NguoiLopHoc>> getLopVaTrangThaiCuaNguoi(@PathVariable Long maNguoiDung) {
        NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(maNguoiDung);
        if (nguoiDung == null) {
            throw new DataNotFoundException("Không tìm thấy người dùng!");
        }

        List<NguoiLopHoc> list = nguoiLopHocRepository.findNguoiDungBy_MaNguoiDung(maNguoiDung);
        return ResponseEntity.ok(list);
    }



}
