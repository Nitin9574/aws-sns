package com.qualigy.sns.controller;


import com.qualigy.sns.service.SNSNotificationService;
import com.qualigy.sns.service.SnsSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sns")
public class SNSController {

    @Value("{aws.sns.topic.arn}")
    private String topicARN;
    @Value("{aws.sns.topic.arn.subscription.endpoint}")
    private String subscriptionEndpoint;
    private final SnsSubscriptionService snsSubscriptionService;
    private final SNSNotificationService snsNotificationService;

    @Autowired
    public SNSController(SnsSubscriptionService snsSubscriptionService, SNSNotificationService snsNotificationService) {
        this.snsSubscriptionService = snsSubscriptionService;
        this.snsNotificationService = snsNotificationService;
    }

    @PostMapping("/addsubscription/{emailAddress}")
    public String subscribeToEmail(@PathVariable String emailAddress) {
        return snsSubscriptionService.subscribeToEmail(emailAddress);
    }

    @GetMapping("/sendNotification")
    public String  sendNotification() {
        snsNotificationService.sendNotification("Network Connectivity Issue",snsNotificationService.buildEmailBody());
        return "Successfully message sent to Subscriber";
    }
}
