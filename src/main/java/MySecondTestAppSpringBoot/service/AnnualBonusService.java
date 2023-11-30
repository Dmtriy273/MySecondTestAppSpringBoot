package MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import MySecondTestAppSpringBoot.model.Positions;

@Service
public interface AnnualBonusService {

    double calculate(Positions positions, double salary, double bonus, int workDay);
}
