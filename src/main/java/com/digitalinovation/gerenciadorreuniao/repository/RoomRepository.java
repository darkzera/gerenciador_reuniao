package com.digitalinovation.gerenciadorreuniao.repository;

import com.digitalinovation.gerenciadorreuniao.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
