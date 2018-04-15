package com.chaos.mapper;

import com.chaos.po.Event;

import java.util.List;

public interface IEventMapper {
    List<Event> listAll();

    List<Event> listAllReal();

    int save(Event event);
}
