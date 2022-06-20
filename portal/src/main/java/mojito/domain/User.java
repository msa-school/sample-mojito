package mojito.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mojito.PortalApplication;
import mojito.domain.UserLocationSet;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "User_table")
@Data
public class User {

    @Id
    private String id;

    private String city;

    @PostPersist
    public void onPostPersist() {
        UserLocationSet userLocationSet = new UserLocationSet();
        BeanUtils.copyProperties(this, userLocationSet);
        userLocationSet.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = PortalApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }
    // keep

}
