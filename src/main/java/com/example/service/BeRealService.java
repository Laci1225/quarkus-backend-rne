package com.example.service;

import com.example.mapper.BeRealMapper;
import com.example.model.BeReal;
import com.example.model.BeRealCreateDto;
import com.example.model.Friendship;
import com.example.repository.BeRealRepository;
import com.example.repository.FriendshipRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class BeRealService {

    @Inject
    BeRealRepository berealRepository;

    @Inject
    BeRealMapper berealMapper;

    @Inject
    FriendshipRepository friendshipRepository;

    @Transactional
    public void saveBeReal(BeRealCreateDto beRealCreateDto) {
        BeReal bereal = berealMapper.fromBeRealCreateDtoToBeReal(beRealCreateDto);
        berealRepository.persist(bereal);
    }

    public List<BeReal> getUserBeReals(Long userId) {
        return berealRepository.find("user.userId", userId).list();
    }

    public List<BeReal> getFriendsBeReals(Long userId) {
        return berealRepository.find("user.userId in ?1",
                friendshipRepository.find("user.userId", userId)
                        .project(Friendship.class)).list();
    }
    public List<BeReal> getTodayBeReals(Long userId) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        return berealRepository.find("user.userId = ?1 and dateCreated >= ?2", userId, startOfDay).list();
    }
}