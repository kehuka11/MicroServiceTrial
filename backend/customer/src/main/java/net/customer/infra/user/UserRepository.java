package net.customer.infra.user;

import net.customer.domain.app_user.AppUser;

public interface UserRepository {

  /**
   * ユーザ登録
   *
   * @param appUser アプリユーザドメイン
   * @return 登録情報
   */
  public void save(AppUser appUser);
}
