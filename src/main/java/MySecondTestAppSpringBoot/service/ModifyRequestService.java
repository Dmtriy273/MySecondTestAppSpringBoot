package MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import MySecondTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
