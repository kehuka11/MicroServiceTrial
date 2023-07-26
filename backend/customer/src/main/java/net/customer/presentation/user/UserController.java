package net.customer.presentation.user;

import net.customer.domain.shared.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import net.customer.presentation.shared.EmptyResponse;
import net.customer.usecase.user.CreateUserUseCase;

@RestController
@Validated
public class UserController {

  @Autowired private CreateUserUseCase createUserUseCase;

  @PostMapping(value = "/user/create")
  public ResponseEntity<EmptyResponse> createUser(@RequestBody CreateUserReq req) {

    // ユースケースに渡すために詰め替え
    CreateUserParam param =
        CreateUserParam.createParam(
            req.getPassword(), req.getLastName(), req.getFirstName(), UserStatus.ACTIVE);
    createUserUseCase.createUser(param);

    return ResponseEntity.ok(new EmptyResponse());
  }
}
