package com.project.ssm.chat.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KafkaConstants {
    private static String name = UUID.randomUUID().toString();
    public static final String KAFKA_TOPIC = "default-topic";
//    public static List<NewTopic> topicList = new ArrayList<>();
    public static final String GROUP_ID = name;
    public static final String KAFKA_BROKER = "15.15.15.100:9092";
    public static List<Integer> partitionList;
}
