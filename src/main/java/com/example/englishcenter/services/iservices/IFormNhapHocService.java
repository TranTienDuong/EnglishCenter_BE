package com.example.englishcenter.services.iservices;

import com.example.englishcenter.dtos.FormNhapHocDTO;
import com.example.englishcenter.models.FormNhapHoc;

import java.util.List;

public interface IFormNhapHocService {
    FormNhapHoc createFormNhapHoc(FormNhapHocDTO formNhapHocDTO);
    FormNhapHoc getFormNhapHocById(long maForm);
    List<FormNhapHoc> getAllFormNhapHoc();
    FormNhapHoc updateFormNhapHoc(long maForm, FormNhapHocDTO formNhapHocDTO);
    void deleteFormNhapHoc(long maForm);
}
