package net.customer.domain.app_user;

import net.customer.domain.app_user.AppUser;
import net.customer.domain.shared.UserStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class AppUserTest {

    @Test
    @DisplayName("正常系-オブジェクト生成")
    public void normal() {
        AppUser appUser = new AppUser("abcdef", "テスト", "太郎", UserStatus.ACTIVE);

        assertThat(appUser.id).isNotEmpty();
        assertThat(appUser.password).isEqualTo("abcdef");
        assertThat(appUser.lastName).isEqualTo("テスト");
        assertThat(appUser.firstName).isEqualTo("太郎");
        assertThat(appUser.status).isEqualTo("有効");

    }
}
