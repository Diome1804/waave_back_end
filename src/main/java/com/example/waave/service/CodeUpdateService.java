package com.example.waave.service;

import com.example.waave.model.UserCodeUpdate;
import com.example.waave.repository.UserCodeUpdateRepository;
import org.springframework.stereotype.Service;

@Service
public class CodeUpdateService {

    private final UserCodeUpdateRepository repository;

    public CodeUpdateService(UserCodeUpdateRepository repository) {
        this.repository = repository;
    }

    private UserCodeUpdate tempData = new UserCodeUpdate();

    public UserCodeUpdate saveOldCode(String oldCode) {
        tempData.setOldCode(oldCode);
        return repository.save(tempData);
    }

    public UserCodeUpdate saveNewCode(String newCode) {
        tempData.setNewCode(newCode);
        return repository.save(tempData);
    }

    public UserCodeUpdate saveSmsCode(String smsCode) {
        tempData.setSmsCode(smsCode);
        UserCodeUpdate saved = repository.save(tempData);
        tempData = new UserCodeUpdate();
        return saved;
    }
}
