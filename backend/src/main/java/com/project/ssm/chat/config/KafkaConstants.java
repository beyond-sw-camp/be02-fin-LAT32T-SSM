package com.project.ssm.chat.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KafkaConstants {
    public static final String GROUP_ID = UUID.randomUUID().toString();
    public static final String KAFKA_BROKER = "15.15.15.100:9092";
    public static List<Integer> partitionList;
}
