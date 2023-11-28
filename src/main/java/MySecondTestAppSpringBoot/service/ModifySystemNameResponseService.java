package MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import MySecondTestAppSpringBoot.model.Request;
import MySecondTestAppSpringBoot.model.Response;
import MySecondTestAppSpringBoot.model.SystemsName;

import static MySecondTestAppSpringBoot.model.SystemsName.*;

@Slf4j
public class ModifySystemNameResponseService implements ModifyResponseService {
    Request request;
    @Override
    public Response modify(Response response) {

        switch (response.getSystemsName()) {
        }

        log.info("Здесь проверяется какое SystemName и в зависимости от аббревиатуры " +
                "присваивается значения из класса перечисления: " + response.getOperationUid());
        return response;
    }
}
