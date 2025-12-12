package com.example.waave.controller;

import com.example.waave.dto.NewCodeRequest;
import com.example.waave.dto.OldCodeRequest;
import com.example.waave.dto.SmsCodeRequest;
import com.example.waave.model.UserCodeUpdate;
import com.example.waave.service.CodeUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
public class CodeUpdateController {

    private final CodeUpdateService service;

    public CodeUpdateController(CodeUpdateService service) {
        this.service = service;
    }

    @PostMapping("/old")
    public UserCodeUpdate receiveOldCode(@RequestBody OldCodeRequest request) {
        return service.saveOldCode(request.getOldCode());
    }

    @PostMapping("/new")
    public UserCodeUpdate receiveNewCode(@RequestBody NewCodeRequest request) {
        return service.saveNewCode(request.getNewCode());
    }

    @PostMapping("/sms")
    public UserCodeUpdate receiveSmsCode(@RequestBody SmsCodeRequest request) {
        return service.saveSmsCode(request.getSmsCode());
    }
}
