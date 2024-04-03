package com.project.ssm.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KafkaConstants {
    public static final String GROUP_ID = UUID.randomUUID().toString();
}
