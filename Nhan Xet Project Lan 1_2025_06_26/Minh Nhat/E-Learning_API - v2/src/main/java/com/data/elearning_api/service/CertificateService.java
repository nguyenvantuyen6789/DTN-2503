package com.data.elearning_api.service;

import com.data.elearning_api.dto.CertificateCreateDTO;
import com.data.elearning_api.entity.Certificate;

import java.util.List;

public interface CertificateService {
    List<Certificate> getAll();
    List<Certificate> getByCourseId(int courseId);
    Certificate create(int courseId, CertificateCreateDTO certificateCreateDTO);
}
