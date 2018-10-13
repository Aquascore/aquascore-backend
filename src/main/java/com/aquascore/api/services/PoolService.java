package com.aquascore.api.services;

import com.aquascore.api.models.Pool;
import com.aquascore.api.models.User;
import com.aquascore.api.repositories.PoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class PoolService {
    @Autowired
    private PoolRepository poolRepository;

    @Autowired
    private UserService userService;

    public List<Pool> getFromUser(HttpServletRequest req) {
        User currentUser = userService.getCurrentUser(req);
        return poolRepository.findByUsers(currentUser);
    }

    public Pool create(Pool newPool, HttpServletRequest req) {
        User currentUser = userService.getCurrentUser(req);
        newPool.setOwner(currentUser);
        newPool.addMember(currentUser);

        poolRepository.save(newPool);

        return newPool;
    }

    public void remove(long poolId, HttpServletRequest req) {
        User currentUser = userService.getCurrentUser(req);
        Pool pool = poolRepository.findById(poolId);

        if (!pool.isOwner(currentUser)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is " +
                "not owner of pool");
        }

        poolRepository.delete(pool);
    }

    public Pool addUser(long poolId, long userId, HttpServletRequest req) {
        User currentUser = userService.getCurrentUser(req);
        Pool pool = poolRepository.findById(poolId);
        User newMember = userService.findById(userId);

        if (!pool.isOwner(currentUser)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is " +
                "not owner of pool");
        }

        pool.addMember(newMember);

        poolRepository.save(pool);

        return pool;
    }

    public Pool removeUser(long poolId, long userId, HttpServletRequest req) {
        User currentUser = userService.getCurrentUser(req);
        Pool pool = poolRepository.findById(poolId);
        User memberToRemove = userService.findById(userId);

        if (!pool.isOwner(currentUser)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User is " +
                "not owner of pool");
        }

        pool.removeMember(memberToRemove);

        poolRepository.save(pool);

        return pool;
    }
}
