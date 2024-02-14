package com.qualigy.sns.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SNSNotificationService {

    @Autowired
    private AmazonSNS amazonSNS;

    @Value("${aws.sns.topic.arn}")
    private String topicARN;
    public void sendNotification(String subject, String message) {
        PublishRequest publishRequest = new PublishRequest()
                .withTopicArn(topicARN)
                .withSubject(subject)
                .withMessage(message);

        PublishResult publishResult = amazonSNS.publish(publishRequest);
    }


    public String buildEmailBody(){
        return "Dear User ,\n" +
                "\n" +
                "\n" +
                "Connection is down Bangalore location."+"\n"+
                "All the servers in Mumbai Data center are not accessible. We are working on it ! \n" +
                "Notification will be sent out as soon as the issue is resolved. For any questions regarding this message please feel free to contact IT Service Support team";
    }
}
