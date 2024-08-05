package com.example.service;

import com.example.model.BeReal;
import com.example.repository.BeRealRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class BeRealService {

    @Inject
    BeRealRepository berealRepository;

    //@Inject
    //FriendshipRepository friendshipRepository;

    @Transactional
    public void saveBeReal(BeReal bereal) {
        berealRepository.persist(bereal);
    }

    public List<BeReal> getUserBeReals(Long userId) {
        return berealRepository.find("user.id", userId).list();
    }

    public List<BeReal> getFriendsBeReals(Long userId) {
        /*return berealRepository.find("user.id in ?1", friendshipRepository
                .find("user.id", userId)
                .project(Friendship.class, "friend.id")).list();*/
        return null;
    }
}