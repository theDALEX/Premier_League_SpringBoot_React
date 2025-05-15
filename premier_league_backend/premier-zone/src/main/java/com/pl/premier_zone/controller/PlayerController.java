package com.pl.premier_zone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pl.premier_zone.entities.Player;
import com.pl.premier_zone.services.PlayerServices;

@RestController
@RequestMapping(path = "api/v1/players")
public class PlayerController {
    private final PlayerServices playerServices;

    @Autowired
    public PlayerController(PlayerServices playerServices) {
        this.playerServices = playerServices;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {
        if (team != null && position != null) {
            return playerServices.getPlayersByTeamAndPosition(team, position);
        } else if (team != null) {
            return playerServices.getPlayerFromTeam(team);
        } else if (name != null) {
            return playerServices.getPlayersByName(name);
        } else if (position != null) {
            return playerServices.getPlayersByPos(position);
        } else if (nation != null) {
            return playerServices.getPlayersByNation(nation);
        } else {
            return playerServices.getPlayers();
        }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player createdPlayer = playerServices.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player resultPlayer = playerServices.updatePlayer(player);
        if (resultPlayer != null) {
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerServices.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }

}
