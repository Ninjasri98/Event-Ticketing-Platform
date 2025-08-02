package com.ninjasri98.tickets.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninjasri98.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.ninjasri98.tickets.mappers.EventMapper;
import com.ninjasri98.tickets.services.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/published-events")
@RequiredArgsConstructor
public class PublishedEventController {
    private final EventService eventService;
    private final EventMapper eventMapper;

   @GetMapping
   public ResponseEntity<Page<ListPublishedEventResponseDto>> listPublishedEvents(Pageable pageable){
       return ResponseEntity.ok(eventService.listPublishedEvents(pageable)
           .map(eventMapper::toListPublishedEventResponseDto));
   }
}
