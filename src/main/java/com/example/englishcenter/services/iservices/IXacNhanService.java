package com.example.englishcenter.services.iservices;

import com.example.englishcenter.dtos.XacNhanDTO;
import com.example.englishcenter.models.XacNhan;

import java.util.List;

public interface IXacNhanService {
    //    XacNhan createXacNhan(XacNhanDTO xacNhanDTO);
    XacNhan getXacNhanById(Long MaXacNhan);
    List<XacNhan> getAllXacNhan();
    XacNhan updateXacNhan(long MaXacNhan, XacNhanDTO xacNhanDTO);
    void deleteXacNhan(long MaXacNhan);
}
