package com.example.elearning.demo_elearning_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDTO {
    private Long id;
    private String type;
    private Long courseId;
    private String courseTitle;
}
