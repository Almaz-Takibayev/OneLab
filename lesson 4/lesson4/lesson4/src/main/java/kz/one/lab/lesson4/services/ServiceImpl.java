package kz.one.lab.lesson4.services;

import kz.one.lab.lesson4.entity.Arena;
import kz.one.lab.lesson4.entity.Fighter;
import kz.one.lab.lesson4.repository.ArenaRepository;
import kz.one.lab.lesson4.repository.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements Service1 {
    @Autowired
    ArenaRepository arenaRepository;
    @Autowired
    CheckingDopingService dopingService;
    @Autowired
    FighterRepository fighterRepository;

    @Override
    public ResponseEntity<Fighter> addFighter(Fighter fighter)
    {
        fighterRepository.save(fighter);
        return new ResponseEntity(fighter, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Arena> addArena(Arena arena)
    {
        arenaRepository.save(arena);
        return new ResponseEntity(arena, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Arena> removeArena(String name)
    {
        Arena arena = arenaRepository.findArenaByName(name);
        arenaRepository.delete(arena);
        return new ResponseEntity<Arena>(arena, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Arena> addFightertoArena(String arenaName, String fighterName)
    {
        Arena arena = arenaRepository.findArenaByName(arenaName);
        Fighter fighter = fighterRepository.findFighterByName(fighterName);
        List<Fighter> fighterList = arena.getFighters();
        List<Arena> arenas = arenaRepository.findAll();
        arenas.stream().forEach(arena1 -> {
            List<Fighter> fighters = arena1.getFighters();
            fighters.removeIf(fighter1 -> fighter.getName().equals(fighter1.getName()));
            arena1.setFighters(fighters);
            arenaRepository.save(arena1);
        });
        fighterList.add(fighter);
        arena.setFighters(fighterList);
        Arena resArena = arenaRepository.save(arena);
        return new ResponseEntity(resArena, HttpStatus.OK);
    }

    @Override
    public List<Fighter> check(){
        Arena arena = arenaRepository.getOne(1);
        //вывели имена всех бойсов в арене, при этом не меняя нижнюю строку
        //log.info("Our warriors: "+arena);//вот эту
        // выбросить в лузеров из бойцов всех тех, кто не прошел допинг контроль
        List<Fighter> arenaFighter = arena.getFighters();
        Arena losers = arenaRepository.getOne(2);

        arenaFighter.removeIf(fighter -> {
            if(!dopingService.checkFigher(fighter)){
                losers.getFighters().add(fighter);
                return true;
            }
            else{
                return false;
            }
        });

        arena.setFighters(arenaFighter);

        Arena arenasave = arenaRepository.save(arena);
        Arena loserssave = arenaRepository.save(losers);
        return loserssave.getFighters();
    }

    @Override
    public Arena getArena(String name) {
        return arenaRepository.findArenaByName(name);
    }

    @Override
    public Fighter getFighter(String name) {
        return fighterRepository.findFighterByName(name);
    }
}
