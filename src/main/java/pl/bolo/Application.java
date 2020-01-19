package pl.bolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bolo.domain.Player;
import pl.bolo.repository.PlayerRepository;

@Controller
@RequestMapping("/")
@SpringBootApplication
public class Application {

    @Autowired
    private PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostMapping(path="/add")
    public @ResponseBody
    Player addPlayer(@RequestParam String name){
        Player player = Player.builder().name(name).build();
        playerRepository.save(player);
        return player;
    }

    @GetMapping
    public @ResponseBody
    Iterable<Player> getAllPlayer(){
        return playerRepository.findAll();
    }

}