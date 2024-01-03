package com.peaksoft.gadgetarium2j7.mapper;

import com.peaksoft.gadgetarium2j7.model.dto.NewsletterRequest;
import com.peaksoft.gadgetarium2j7.model.dto.NewsletterResponse;
import com.peaksoft.gadgetarium2j7.model.entities.NewsLetter;
import org.springframework.stereotype.Component;

@Component
public class NewsletterMapper {
    public NewsLetter mapToEntity(NewsletterRequest request) {
        NewsLetter newsletter = new NewsLetter();
        newsletter.setNameSender(request.getNameSender());
        newsletter.setDescriptionSender(request.getDescriptionSender());
        newsletter.setStartLetter(request.getStartLetter());
        newsletter.setEndLetter(request.getEndLetter());
        return newsletter;
    }

    public NewsletterResponse mapToResponse(NewsLetter newsletter) {
        return NewsletterResponse
                .builder()
                .id(newsletter.getId())
                .nameSender(newsletter.getNameSender())
                .descriptionSender(newsletter.getDescriptionSender())
                .startLetter(newsletter.getStartLetter())
                .endLetter(newsletter.getEndLetter())
                .build();
    }
}
