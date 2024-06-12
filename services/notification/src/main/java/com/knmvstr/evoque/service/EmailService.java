package com.knmvstr.evoque.service;

import com.knmvstr.evoque.entity.EmailTemplates;
import com.knmvstr.evoque.kafka.ticket.Event;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;
    //From Thymleaf

    @Async
    // To keep process running when email is sent or received
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String userName,
            BigDecimal amount,
            String ticketReference
    ) throws jakarta.mail.MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("jarolen235@wsneon.com");
        //Whatever email address is ok. This is a temporary email address

        final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();
        variables.put("userName", userName);
        variables.put("amount", amount);
        variables.put("ticketReference", ticketReference);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
        }

    }

    @Async
    public void sendTicketConfirmationEmail(
            String destinationEmail,
            String userName,
            BigDecimal amount,
            String ticketReference,
            List<Event> events
    ) throws jakarta.mail.MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, UTF_8.name());
        messageHelper.setFrom("contact@aliboucoding.com");

        final String templateName = EmailTemplates.TICKET_CONFIRMATION.getTemplate();

        Map<String, Object> variables = new HashMap<>();
        variables.put("userName", userName);
        variables.put("totalAmount", amount);
        variables.put("ticketReference", ticketReference);
        variables.put("events", events);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplates.TICKET_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info(String.format("INFO - Email successfully sent to %s with template %s ", destinationEmail, templateName));
        } catch (MessagingException e) {
            log.warn("WARNING - Cannot send Email to {} ", destinationEmail);
        }

    }
}