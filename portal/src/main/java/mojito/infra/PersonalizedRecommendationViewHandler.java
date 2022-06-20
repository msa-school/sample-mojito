package mojito.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import mojito.config.kafka.KafkaProcessor;
import mojito.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PersonalizedRecommendationViewHandler {

    @Autowired
    private PersonalizedRecommendationRepository personalizedRecommendationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUserLocationSet_then_CREATE_1(
        @Payload UserLocationSet userLocationSet
    ) {
        try {
            if (!userLocationSet.validate()) return;

            // view 객체 생성
            PersonalizedRecommendation personalizedRecommendation = new PersonalizedRecommendation();
            // view 객체에 이벤트의 Value 를 set 함
            personalizedRecommendation.setId(userLocationSet.getId());
            personalizedRecommendation.setLocation(
                userLocationSet.getCity()
            );
            personalizedRecommendation.setKey(
                userLocationSet.getCity() + "_" + personalizedRecommendation.getWeather()
            );
            // view 레파지 토리에 save
            personalizedRecommendationRepository.save(
                personalizedRecommendation
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAttireRecommended_then_UPDATE_1(
        @Payload AttireRecommended attireRecommended
    ) {
        try {
            if (!attireRecommended.validate()) return;
            // view 객체 조회

            List<PersonalizedRecommendation> personalizedRecommendationList = personalizedRecommendationRepository.findByKey(
                attireRecommended.getKey()
            );
            for (PersonalizedRecommendation personalizedRecommendation : personalizedRecommendationList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                personalizedRecommendation.setAttireId(
                    String.valueOf(attireRecommended.getId())
                );
                // view 레파지 토리에 save
                personalizedRecommendationRepository.save(
                    personalizedRecommendation
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenWeatherChanged_then_UPDATE_2(
        @Payload WeatherChanged weatherChanged
    ) {
        try {
            if (!weatherChanged.validate()) return;
            // view 객체 조회

            List<PersonalizedRecommendation> personalizedRecommendationList = personalizedRecommendationRepository.findByLocation(
                weatherChanged.getCity()
            );
            for (PersonalizedRecommendation personalizedRecommendation : personalizedRecommendationList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                personalizedRecommendation.setWeather(
                    weatherChanged.getWeather()
                );
                personalizedRecommendation.setKey(
                    personalizedRecommendation.getLocation() + "_" + personalizedRecommendation.getWeather()
                );
                
                // view 레파지 토리에 save
                personalizedRecommendationRepository.save(
                    personalizedRecommendation
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenFoodRecommended_then_UPDATE_3(
        @Payload FoodRecommended foodRecommended
    ) {
        try {
            if (!foodRecommended.validate()) return;
            // view 객체 조회

            List<PersonalizedRecommendation> personalizedRecommendationList = personalizedRecommendationRepository.findByKey(
                foodRecommended.getKey()
            );
            for (PersonalizedRecommendation personalizedRecommendation : personalizedRecommendationList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                personalizedRecommendation.setFoodId(
                    String.valueOf(foodRecommended.getId())
                );
                // view 레파지 토리에 save
                personalizedRecommendationRepository.save(
                    personalizedRecommendation
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
