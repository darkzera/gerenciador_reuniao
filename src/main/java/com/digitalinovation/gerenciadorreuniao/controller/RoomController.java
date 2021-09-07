package com.digitalinovation.gerenciadorreuniao.controller;

import com.digitalinovation.gerenciadorreuniao.exception.ResourceNotFound;
import com.digitalinovation.gerenciadorreuniao.model.Room;
import com.digitalinovation.gerenciadorreuniao.repository.RoomRepository;
import jakarta.validation.Valid;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/all")
    public List<Room> listAll(){
        return (List<Room>) roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long id) throws ResourceNotFound {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Room not found: " + id));
        return ResponseEntity.ok().body(room);
    }

    @PostMapping("/")
    public Room createRoom(@RequestBody Room room){
        roomRepository.save(room);
        return room;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody Room roomDetails) throws ResourceNotFound {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Room not found "+ id));
        room.setName(roomDetails.getName());
        room.setEndHour(roomDetails.getEndHour());
        room.setStartHour(roomDetails.getStartHour());

        final Room roomUpdated = roomRepository.save(room);
        return ResponseEntity.ok().body(room);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoomById(@PathVariable(value = "id") Long id) throws ResourceNotFound {
        Room roomToDelete = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Not found"));
        return ResponseEntity.ok().body(roomToDelete);
    }


}
