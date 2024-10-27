package org.but.eloryksauthorization.newbackend.service;

import org.but.eloryksauthorization.newbackend.api.PositionDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Position;
import org.but.eloryksauthorization.newbackend.data.repository.PositionRepository;
import org.but.eloryksauthorization.newbackend.mappers.PositionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

public class PositionService {

    @Mock
    private PositionRepository positionRepository;

    @Mock
    private PositionMapper positionMapper;

    @Mock
    private PositionService positionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        PositionDTO dto = new PositionDTO();
        dto.setSpeed(10);
        dto.setLatitude(10.2);
        dto.setLongitude(10.2);
        dto.setTimestamp(LocalDateTime.parse("2023-10-27T13:12:33.204Z"));
        dto.setHeading(10);

        Position entity = new Position();
        entity.setSpeed(dto.getSpeed());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLatitude());

    }
}
