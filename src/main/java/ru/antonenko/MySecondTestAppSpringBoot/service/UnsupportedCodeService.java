package ru.antonenko.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.antonenko.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;

@Service
public interface UnsupportedCodeService {

    void isValid(String s) throws UnsupportedCodeException;
}
