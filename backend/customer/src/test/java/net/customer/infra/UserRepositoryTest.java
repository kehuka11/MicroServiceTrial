package net.customer.infra;

import net.customer.domain.app_user.AppUser;
import net.customer.infra.user.UserRepository;
import net.customer.shared.AppUserFactory;
import net.customer.shared.TestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.assertj.db.type.Changes;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.db.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest extends TestSupport {

    @Autowired private UserRepository userRepository;


    @AfterEach
    public void tearDown(){
        jdbcTemplate.execute("Delete FROM customer.app_user ");
    }



    @Test
    @DisplayName("正常系-インサートできること")
    public void normalInsert() {
        AppUser appUser = AppUserFactory.normal();

        Changes changes = createChanges();
        changes.setStartPointNow();
        userRepository.save(appUser);

        changes.setEndPointNow();

        assertThat(changes)
                .hasNumberOfChanges(1)
                .ofCreationOnTable("app_user")
                .hasNumberOfChanges(1)
                .changeOnTable("app_user")
                .isCreation()
                .rowAtEndPoint()
                .value("id").isNotNull()
                .value("user_password").isEqualTo("abcdef")
                .value("last_name").isEqualTo("テスト")
                .value("first_name").isEqualTo("太郎")
                .value("status").isEqualTo("有効");

    }


}
