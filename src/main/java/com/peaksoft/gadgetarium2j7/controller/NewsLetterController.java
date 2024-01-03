package com.peaksoft.gadgetarium2j7.controller;

import com.peaksoft.gadgetarium2j7.exseption.PasswordsDoNotMatchException;
import com.peaksoft.gadgetarium2j7.exseption.UserNotFoundException;
import com.peaksoft.gadgetarium2j7.model.dto.NewsletterRequest;
import com.peaksoft.gadgetarium2j7.model.dto.NewsletterResponse;
import com.peaksoft.gadgetarium2j7.service.NewsletterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/newsletter")
@RequiredArgsConstructor
public class NewsLetterController {
    private final NewsletterService newsletterService;

    @PostMapping("/add")
    public String add(@RequestBody NewsletterRequest request) {
        newsletterService.save(request);
        return " Success sent! ";
    }
    @PutMapping("/update/{id}")
    public NewsletterResponse update(@PathVariable("id") Long id, @RequestBody NewsletterRequest request) {
        return newsletterService.update(id, request);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        newsletterService.delete(id);
        return " Application with id: " + id + " successfully deleted";
    }

    @GetMapping("/sendPasswordResetCode")
    public void sendPasswordResetCode(@RequestParam String email) throws UserNotFoundException {
        newsletterService.sendPasswordResetCode(email);
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam int pinCode,
                                @RequestParam String newPassword, @RequestParam String confirmPassword)
            throws UserNotFoundException, PasswordsDoNotMatchException {
        return newsletterService.resetPassword(email, pinCode, newPassword, confirmPassword);
    }


}
