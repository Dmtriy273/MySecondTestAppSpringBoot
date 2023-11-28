package MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import MySecondTestAppSpringBoot.model.Request;
import MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@Service
@Component
public class ModifySystemNameRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request) {
        log.info("из ModifySystemNameRequestService " + request);

        request.setSystemName("Service 1");
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

        log.info("из ModifySystemNameRequestService после изменения имя сервиса" + request);

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });

    }
}
