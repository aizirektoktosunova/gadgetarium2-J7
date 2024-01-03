package com.peaksoft.gadgetarium2j7.service;

import com.peaksoft.gadgetarium2j7.exseption.MailSendingException;
import com.peaksoft.gadgetarium2j7.exseption.PasswordsDoNotMatchException;
import com.peaksoft.gadgetarium2j7.exseption.UserNotFoundException;
import com.peaksoft.gadgetarium2j7.mapper.NewsletterMapper;
import com.peaksoft.gadgetarium2j7.model.dto.NewsletterRequest;
import com.peaksoft.gadgetarium2j7.model.dto.NewsletterResponse;
import com.peaksoft.gadgetarium2j7.model.entities.NewsLetter;
import com.peaksoft.gadgetarium2j7.model.entities.User;
import com.peaksoft.gadgetarium2j7.repository.NewsletterRepository;
import com.peaksoft.gadgetarium2j7.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class NewsletterService {
    private final NewsletterMapper newsletterMapper;
    private final NewsletterRepository repository;
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;

    public void save(NewsletterRequest request) {
        NewsLetter newsletter = newsletterMapper.mapToEntity(request);
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            if (user.isSubscribe()) {
                sendMassage(newsletter,user.getEmail());
            }
        }
        repository.save(newsletter);
    }

    private void sendMassage(NewsLetter newsletter, String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("temuchi500@gmail.com");
        message.setTo(email);
        message.setSubject(newsletter.getNameSender());
        message.setText(newsletter.getDescriptionSender());
        javaMailSender.send(message);
    }

    public NewsletterResponse update(Long newsId, NewsletterRequest request) {
        NewsLetter oldApp = repository.findById(newsId)
                .orElseThrow(() -> new RuntimeException(" Newsletter not found by id: " + newsId));
        oldApp.setNameSender(request.getNameSender());
        oldApp.setDescriptionSender(request.getDescriptionSender());
        oldApp.setStartLetter(request.getStartLetter());
        oldApp.setEndLetter(request.getEndLetter());
        repository.save(oldApp);
        return newsletterMapper.mapToResponse(oldApp);
    }

    public void delete(Long appId) {
        repository.deleteById(appId);
    }

    public void sendPasswordResetCode(String email) throws UserNotFoundException {
        int pinCode = generatePinCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("ajzirektoktosunova853@gmail.com");
        message.setSubject("Password reset");
        message.setText(String.valueOf(pinCode));
        try {
            javaMailSender.send(message);
            updateUserPinCode(email, pinCode);
        } catch (MailException e) {
            throw new MailSendingException("Не удалось отправить код для сброса пароля", e);
        }
    }

    public String resetPassword(String email, int pinCode, String newPassword, String confirmPassword)
            throws UserNotFoundException, PasswordsDoNotMatchException {
        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordsDoNotMatchException("Пароли не совпадают");
        } else {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
            if (pinCode == user.getPinCode()) {
                user.setPassword(newPassword);
                userRepository.save(user);
                return "Сброс пароля прошел успешно";
            }
        }
        return "Неверный PIN-код";
    }

    private int generatePinCode() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }

private void updateUserPinCode(String email, int pinCode) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    user.setPinCode(pinCode);
    userRepository.save(user);
}

}
