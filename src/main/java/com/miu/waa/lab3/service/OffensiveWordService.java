package com.miu.waa.lab3.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.miu.waa.lab3.entity.OffensiveWord;
import com.miu.waa.lab3.entity.User;
import com.miu.waa.lab3.repo.OffensiveWordRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OffensiveWordService {
    @Value("${offensive-word.expiration:30}")
    private long expiration;

    @Value("${offensive-word.limit:5}")
    private long limit;

    private final OffensiveWordRepo offensiveWordRepo;

    public OffensiveWord validateOffensiveWords(User user) {
        var optional = offensiveWordRepo.findByUserEmail(user.getEmail());

        if (optional.isPresent()) {
            var word = optional.get();

            if (word.getExpireDate().isAfter(LocalDateTime.now())) {
                if (word.getCount() < limit) {
                    word.setCount(word.getCount() + 1);
                    offensiveWordRepo.save(word);
                }

            } else {
                word.setCount(1);
                word.setExpireDate(LocalDateTime.now().plusMinutes(expiration));

                offensiveWordRepo.save(word);
            }

            return word;
        } else {
            var word = new OffensiveWord();
            word.setCount(1);
            word.setExpireDate(LocalDateTime.now().plusMinutes(expiration));
            word.setUser(user);

            offensiveWordRepo.save(word);
            return word;
        }
    }

}
