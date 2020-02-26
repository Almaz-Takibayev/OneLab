package kz.one.lab.lesson4.rest;

import io.swagger.annotations.ApiOperation;
import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.services.Service1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("onelab")
@Slf4j
public class FightController {
    // Адрес ednpoint'a=onelab+fight = localhost:port/onelab/fight
    @Autowired
    Service1 service;

    @ApiOperation("Add Fighter")
    @PutMapping(value = "fight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Fighter> addFighter(@RequestBody Fighter fighter)
    {
        return service.addFighter(fighter);
    }

    @ApiOperation("Add Arena")
    @PutMapping(value = "arena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> addArena(@RequestBody Arena arena)
    {
        return service.addArena(arena);
    }

    @ApiOperation("Add Fighter to Arena")
    @PostMapping(value = "addfightertoarena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> addFightertoArena(@RequestParam(name = "arenaName") String arenaName, @RequestParam(name = "fighterName") String fighterName)
    {
        return service.addFightertoArena(arenaName, fighterName);
    }

    @ApiOperation("Remove Arena")
    @DeleteMapping(value = "removearena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Arena> removeArena(@RequestParam String name)
    {
        return service.removeArena(name);
    }

    @ApiOperation("Check All Fighters")
    @PostMapping(value = "check", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fighter> check(){
        return service.check();
    }
}
