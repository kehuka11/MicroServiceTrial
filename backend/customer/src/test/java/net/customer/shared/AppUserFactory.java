package net.customer.shared;

import net.customer.domain.app_user.AppUser;
import net.customer.domain.shared.UserStatus;

public class AppUserFactory {

    public static AppUser normal() {
        return new AppUser("abcdef", "テスト", "太郎", UserStatus.ACTIVE);
    }
}
