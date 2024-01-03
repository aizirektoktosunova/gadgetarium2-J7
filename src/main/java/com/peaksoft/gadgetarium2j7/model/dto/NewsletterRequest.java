package com.peaksoft.gadgetarium2j7.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewsletterRequest {
    private String nameSender;
    private String descriptionSender;
    private String startLetter;
    private String endLetter;
}
