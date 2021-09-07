package com.digitalinovation.gerenciadorreuniao.controller;

import com.digitalinovation.gerenciadorreuniao.model.Room;
import com.digitalinovation.gerenciadorreuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomRepository roomRepository;

    @GetMapping("/all")
    public Room listAll(){
        return roomRepository.findAll();

    }
}
