package MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);

}
