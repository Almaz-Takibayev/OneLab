package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public interface Service1 {
    public ResponseEntity<Fighter> addFighter(Fighter fighter);
    public ResponseEntity<Arena> addArena(Arena arena);
    public ResponseEntity<Arena> removeArena(String name);
    public ResponseEntity<Arena> addFightertoArena(String arenaName, String fighterName);
    public List<Fighter> check();
    public Arena getArena(String name);
    public Fighter getFighter(String name);
}
