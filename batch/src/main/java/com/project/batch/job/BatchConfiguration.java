package com.project.batch.job;

import com.project.batch.events.repository.EventCustomRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfiguration {

    @Bean
    public EventParticipantsReader eventParticipantsReader(EventCustomRepository eventRepositoryImpl) {
        return new EventParticipantsReader(eventRepositoryImpl.findMemberByEventTime());
    }
}
