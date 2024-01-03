package com.peaksoft.gadgetarium2j7.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class NewsletterResponse {
    private Long id;
    private String nameSender;
    private String descriptionSender;
    private String startLetter;
    private String endLetter;
}
