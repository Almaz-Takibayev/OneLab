package kz.one.lab.lesson4.repository;

import kz.one.lab.lesson4.entity.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Integer> {

    public Arena findArenaByName(String name);
}
