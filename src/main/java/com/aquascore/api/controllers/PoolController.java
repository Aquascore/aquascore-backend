package com.aquascore.api.controllers;

import com.aquascore.api.models.Pool;
import com.aquascore.api.models.Score;
import com.aquascore.api.services.PoolService;
import com.aquascore.api.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/pools/")
public class PoolController {
    @Autowired
    private PoolService poolService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/")
    public List<Pool> getAll(HttpServletRequest req) {
        return poolService.getFromUser(req);
    }

    @GetMapping("/{pool_id}/scores")
    public List<Score> getScores(@PathVariable("pool_id") long poolId, HttpServletRequest req) {
        return scoreService.getAll(poolId);
    }

    @GetMapping("/{pool_id}")
    public Pool getById(@PathVariable("pool_id") long poolId){
        return poolService.findById(poolId);
    }

    @PostMapping("/")
    public Pool create(@RequestBody Pool newPool, HttpServletRequest req) {
        return poolService.create(newPool, req);
    }

    @PatchMapping("/{pool_id}/users/{user_id}")
    public Pool addUser(@PathVariable("pool_id") long poolId,
                        @PathVariable("user_id") long userId,
                        HttpServletRequest req) {
        return poolService.addUser(poolId, userId, req);
    }

    @DeleteMapping("/{pool_id}/users/{user_id}")
    public Pool removeUser(@PathVariable("pool_id") long poolId,
                           @PathVariable("user_id") long userId,
                           HttpServletRequest req) {
        return poolService.removeUser(poolId, userId, req);
    }

    @DeleteMapping("/{pool_id}")
    public void removePool(@PathVariable("pool_id") long poolId,
                           HttpServletRequest req) {
        poolService.remove(poolId, req);
    }
}
