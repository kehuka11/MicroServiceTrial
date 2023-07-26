package net.customer.infra.user;


import net.customer.domain.app_user.AppUser;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import static jooq.gen.tables.AppUser.APP_USER;


@Repository
public class UserRepositoryImpl implements UserRepository {



  @Autowired DSLContext dslContext;


  @Override
  public void save(AppUser appUser) {

    // TODO: Mapを使用してUPDATE、INSERTできるようにする（時間があるとき）
    dslContext.insertInto(APP_USER)
            .set(APP_USER.ID, appUser.id)
            .set(APP_USER.USER_PASSWORD, appUser.password)
            .set(APP_USER.LAST_NAME, appUser.lastName)
            .set(APP_USER.FIRST_NAME, appUser.firstName)
            .set(APP_USER.STATUS, appUser.status)
            .onDuplicateKeyUpdate()
            .set(APP_USER.ID, appUser.id)
            .set(APP_USER.USER_PASSWORD, appUser.password)
            .set(APP_USER.LAST_NAME, appUser.lastName)
            .set(APP_USER.FIRST_NAME, appUser.firstName)
            .set(APP_USER.STATUS, appUser.status)
            .execute();
  }
}
