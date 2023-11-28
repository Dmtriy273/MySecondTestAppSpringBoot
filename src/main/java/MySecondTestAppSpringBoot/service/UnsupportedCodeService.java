package MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import MySecondTestAppSpringBoot.exception.UnsupportedCodeException;

@Service
public interface UnsupportedCodeService {

    void isValid(String s) throws UnsupportedCodeException;
}
