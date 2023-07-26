package net.customer.usecase.user;

import net.customer.domain.app_user.AppUser;
import net.customer.infra.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.customer.presentation.user.CreateUserParam;
import net.customer.usecase.shared.exception.UserCaseException;

@Service
public class CreateUserUseCase {
  @Autowired private UserRepository userRepository;

  public void createUser(CreateUserParam param) {
    AppUser appUser =
        new AppUser(
            param.getPassword(), param.getLastName(), param.getFirstName(), param.getStatus());
    try {
      userRepository.save(appUser);
    } catch (RuntimeException e) {
      throw new UserCaseException("アプリユーザの作成に失敗しました");
    }
  }
}
