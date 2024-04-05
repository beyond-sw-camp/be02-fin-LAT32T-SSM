package com.project.batch.job;

import com.project.batch.events.model.EventParticipants;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;

import java.util.List;

// 커스텀 리더
public class EventParticipantsReader implements ItemReader<EventParticipants> {

    private final ListItemReader<EventParticipants> delegate;

    public EventParticipantsReader(List<EventParticipants> data) {
        this.delegate = new ListItemReader<>(data);
    }

    @Override
    public EventParticipants read() throws Exception {
        return delegate.read();
    }
}
