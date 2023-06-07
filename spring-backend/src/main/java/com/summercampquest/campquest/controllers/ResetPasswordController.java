package com.summercampquest.campquest.controllers;

import com.summercampquest.campquest.models.ForgotPassword;
import com.summercampquest.campquest.models.ResetPassword;
import com.summercampquest.campquest.models.User;
import com.summercampquest.campquest.models.data.UserRepository;
import com.summercampquest.campquest.service.MailServiceImpl;
import com.summercampquest.campquest.service.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ResetPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserData userData;
    @Autowired
    private MailServiceImpl mailService;


    @PostMapping("/api/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPassword forgotPassword) {
        String email = forgotPassword.getEmail();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.badRequest().body("User with email " + email + " not found");
        }

        String token = UUID.randomUUID().toString();
        user.setToken(token);
        Date tokenExpiryDt = new Date();
        long millis = tokenExpiryDt.getTime();
        millis += 60 * 60 * 1000;
        user.setTokenExpiryDate(new Date(millis));
        userRepository.save(user);

        mailService.sendEmail(email, token);
        return ResponseEntity.ok("Email sent to reset password");
    }

    @PostMapping("/api/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPassword resetPassword) {


        String token = resetPassword.getToken();
        String password = resetPassword.getPassword();
        User user = userRepository.findUserByToken(token);
        System.out.println(user);
        Date tokenValidation = new Date();

        if (tokenValidation.before(user.getTokenExpiryDate())) {
            user.setPassword(userData.getEncodedPassword(password));
            user.setTokenExpiryDate(null);
            user.setToken(null);
            userRepository.save(user);
        } else {
            return ResponseEntity.badRequest().body("Email verification time expired plz try again");
        }

        return ResponseEntity.ok("Password reset Successful");
    }


}
