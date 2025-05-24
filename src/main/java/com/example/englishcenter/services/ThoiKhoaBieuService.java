package com.example.englishcenter.services;

import com.example.englishcenter.Responses.ThoiKhoaBieuCaNhanResponse;
import com.example.englishcenter.Responses.ThoiKhoaBieuRespone;
import com.example.englishcenter.dtos.ThoiKhoaBieuDTO;
import com.example.englishcenter.models.LopHoc;
import com.example.englishcenter.models.NguoiDung;
import com.example.englishcenter.models.NguoiLopHoc;
import com.example.englishcenter.repositories.NguoiLopHocRepository;
import com.example.englishcenter.services.iservices.IThoiKhoaBieuService;
import com.example.englishcenter.models.ThoiKhoaBieu;
import com.example.englishcenter.repositories.ThoiKhoaBieuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThoiKhoaBieuService implements IThoiKhoaBieuService {
    private final ThoiKhoaBieuRepository thoiKhoaBieuRepository;
    private final ModelMapper modelMapper;
    private final NguoiLopHocRepository nguoiLopHocRepository;



    public List<ThoiKhoaBieuRespone> getThoiKhoaBieuBylophoc(Long malop) {
        List<ThoiKhoaBieu> thoiKhoaBieus = thoiKhoaBieuRepository.findByLophoc_Malop(malop);

        modelMapper.typeMap(ThoiKhoaBieu.class, ThoiKhoaBieuRespone.class).addMapping(
                src -> src.getPhonghoc().getTenphong(), ThoiKhoaBieuRespone::setTenphonghoc);

        return thoiKhoaBieus.stream()
                .map(thoiKhoaBieu -> modelMapper.map(thoiKhoaBieu, ThoiKhoaBieuRespone.class))
                .collect(Collectors.toList());
    }

    public ThoiKhoaBieuRespone getThoiKhoaById(long MaThoiKhoaBieu) {
        ThoiKhoaBieu tkb = thoiKhoaBieuRepository.findById(MaThoiKhoaBieu)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thời khóa biểu với ID: " + MaThoiKhoaBieu));

        // Tạo ThoiKhoaBieuRespone từ dữ liệu đã tìm thấy
        ThoiKhoaBieuRespone response = new ThoiKhoaBieuRespone(
                tkb.getThuhoc(),
                tkb.getTgbatdau(),
                tkb.getTgketthuc(),
                tkb.getPhonghoc().getTenphong()
        );

        return response;  // Trả về response
    }

    @Override
    public List<ThoiKhoaBieuRespone> getAllThoiKhoa() {
        return thoiKhoaBieuRepository.findAll().stream().map(thoiKhoaBieu -> {
            return new ThoiKhoaBieuRespone().builder()
                    .thuhoc(thoiKhoaBieu.getThuhoc())
                    .tgbatdau(thoiKhoaBieu.getTgbatdau())
                    .tgketthuc(thoiKhoaBieu.getTgketthuc())
                    .tenphonghoc(thoiKhoaBieu.getPhonghoc().getTenphong())
                    .build();
        }).collect(Collectors.toList());
    }


    @Override
    public ThoiKhoaBieu createThoiKhoaBieu(ThoiKhoaBieuDTO thoiKhoaBieuDTO) {
        ThoiKhoaBieu thoiKhoaBieu = ThoiKhoaBieu.builder()
                .thuhoc(thoiKhoaBieuDTO.getThuhoc())
                .tgbatdau(thoiKhoaBieuDTO.getTgbatdau())
                .tgketthuc(thoiKhoaBieuDTO.getTgketthuc())
                .phonghoc(thoiKhoaBieuDTO.getPhonghoc())
                .build();
        return thoiKhoaBieuRepository.save(thoiKhoaBieu);
    }

    @Override
    public ThoiKhoaBieu updateThoiKhoaBieu(long MaThoiKhoaBieu, ThoiKhoaBieuDTO thoiKhoaBieuDTO) {
        return null;
    }

    @Override
    public void deleteThoiKhoaBieu(long MaThoiKhoaBieu) {
        thoiKhoaBieuRepository.deleteById(MaThoiKhoaBieu);
    }

    //lấy danh sách phòng trống theo ca học, thứ học
    public List<String> getAvailableRooms(List<Integer> thuHoc, LocalTime tgbatdau, LocalTime tgketthuc) {
        return thoiKhoaBieuRepository.findPhongHocWithConditions(thuHoc, tgbatdau, tgketthuc);
    }

    //lấy danh sách tkb
    public List<ThoiKhoaBieu> getAvaibleTKB(List<Integer> thuHoc, LocalTime tgbatdau, LocalTime tgketthuc,Long maphonghoc){
        return thoiKhoaBieuRepository.getAvaibleTKB(thuHoc, tgbatdau, tgketthuc, maphonghoc);
    }

//    public List<NguoiDung> timGiaoVienRanh(List<Integer> thuHoc, String caHoc) {
//        LocalTime tgbatdau;
//        LocalTime tgketthuc;
//        // Chuyển đổi ca học thành thời gian bắt đầu và kết thúc
//        switch (caHoc) {
//            case "Sáng":
//                tgbatdau = LocalTime.parse("07:00");
//                tgketthuc = LocalTime.parse("10:00");
//                break;
//            case "Chiều":
//                tgbatdau = LocalTime.parse("13:00");
//                tgketthuc = LocalTime.parse("16:00");
//                break;
//            case "Tối":
//                tgbatdau = LocalTime.parse("18:00");
//                tgketthuc = LocalTime.parse("21:00");
//                break;
//            default:
//                throw new IllegalArgumentException("Ca học không hợp lệ!");
//        }
//
//        // Truy vấn tìm giáo viên rảnh
//        return thoiKhoaBieuRepository.findGiaoVienRanh(thuHoc, tgbatdau, tgketthuc);
//    }
public List<NguoiDung> timGiaoVienRanhTrongDanhSach(List<NguoiDung> dsGiaoVien, List<Integer> thuHoc, String caHoc) {
    LocalTime tgbatdau;
    LocalTime tgketthuc;
    switch (caHoc) {
        case "Sáng":
            tgbatdau = LocalTime.of(7, 0);
            tgketthuc = LocalTime.of(10, 0);
            break;
        case "Chiều":
            tgbatdau = LocalTime.of(13, 0);
            tgketthuc = LocalTime.of(16, 0);
            break;
        case "Tối":
            tgbatdau = LocalTime.of(18, 0);
            tgketthuc = LocalTime.of(21, 0);
            break;
        default:
            throw new IllegalArgumentException("Ca học không hợp lệ!");
    }

    // Lọc trong danh sách giáo viên có trình độ phù hợp
    List<NguoiDung> giaoVienRanh = new ArrayList<>();
    for (NguoiDung gv : dsGiaoVien) {
        boolean coLichTrung = thoiKhoaBieuRepository.coLichTrung(gv.getManguoidung(), thuHoc, tgbatdau, tgketthuc);
        if (!coLichTrung) {
            giaoVienRanh.add(gv);
        }
    }
    return giaoVienRanh;
}

    public boolean giaoVienConBan(NguoiDung gv, List<Integer> thuHocMoi, String caHocMoi, LocalDate ngayKhaiGiangMoi) {
    List<NguoiLopHoc> dsDangDay = nguoiLopHocRepository.findAllGiaoVienDangDay(gv.getManguoidung());

    for (NguoiLopHoc nlh : dsDangDay) {
        LopHoc lop = nlh.getLopHoc();
        LocalDate ngayKetThuc = tinhNgayKetThuc(lop.getNgaykhaigiang().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), lop.getThoigianhoc(), lop.getThuhoc());

        List<ThoiKhoaBieu> tkbs = thoiKhoaBieuRepository.findByLophoc_Malop(lop.getMalop());

        for (ThoiKhoaBieu tkb : tkbs) {
            String caCu = chuyenTGThanhCaHoc(tkb.getTgbatdau());
            if (thuHocMoi.contains(tkb.getThuhoc()) && caCu.equalsIgnoreCase(caHocMoi)) {
                if (!ngayKetThuc.isBefore(ngayKhaiGiangMoi)) {
                    return false; // Không còn rảnh, trùng lịch và chưa kết thúc
                }
            }
        }
    }
    return true; // Có thể dạy lớp mới
}

    private int tinhSoBuoiMoiTuan(String thuHoc) {
        if (thuHoc == null || thuHoc.trim().isEmpty()) {
            return 0;
        }
        return thuHoc.split(",").length;
    }

    private LocalDate tinhNgayKetThuc(LocalDate ngayKhaiGiang, String thoigianHoc, String thuHoc) {
        int soBuoi;
        try {
            soBuoi = Integer.parseInt(thoigianHoc.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Thời gian học không hợp lệ: " + thoigianHoc);
        }
        int buoiMoiTuan = tinhSoBuoiMoiTuan(thuHoc);
        if (buoiMoiTuan == 0) {
            throw new IllegalArgumentException("Lịch học không hợp lệ.");
        }
        int soTuan = (int) Math.ceil((double) (soBuoi / buoiMoiTuan))-1;
        return ngayKhaiGiang.plusDays(soTuan * 7L+2);
    }


    private String chuyenTGThanhCaHoc(LocalTime batdau) {
        if (batdau.equals(LocalTime.of(7, 0))) return "Sáng";
        if (batdau.equals(LocalTime.of(13, 0))) return "Chiều";
        if (batdau.equals(LocalTime.of(18, 0))) return "Tối";
        return "Không xác định";
    }

    public List<ThoiKhoaBieuCaNhanResponse> getScheduleForUser(Long maNguoiDung) {
        return thoiKhoaBieuRepository.findScheduleByUserId(maNguoiDung).stream().map(thoiKhoaBieu -> {
            return ThoiKhoaBieuCaNhanResponse.builder()
                    .thuhoc(thoiKhoaBieu.getThuhoc())
                    .tgbatdau(thoiKhoaBieu.getTgbatdau())
                    .tgketthuc(thoiKhoaBieu.getTgketthuc())
                    .tenphonghoc(thoiKhoaBieu.getPhonghoc().getTenphong())
                    .ngaykhaigiang(thoiKhoaBieu.getLophoc().getNgaykhaigiang())
                    .tenlop(thoiKhoaBieu.getLophoc().getTenlophoc())
                    .thoigianhoc(thoiKhoaBieu.getLophoc().getThoigianhoc())
                    .build();
        }).collect(Collectors.toList());
    }
    public void removeLopFromTKB(Long malop) {
        thoiKhoaBieuRepository.updateMalopToNull(malop);
    }


}
