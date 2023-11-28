package MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import MySecondTestAppSpringBoot.model.Request;
import MySecondTestAppSpringBoot.util.DateTimeUtil;

import java.util.Date;

@Service
@Component
public class ModifySystemTimeRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request) {
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));

    }
}