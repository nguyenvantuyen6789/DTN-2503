package com.data.elearning_api.dto;

import com.data.elearning_api.entity.CertificateType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateDTO {
    int id;
    CertificateType type;
    double score;
    LocalDate issueDate;
    int accountId;
    int courseId;
}
