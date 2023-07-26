package net.customer.presentation.user;

import net.customer.domain.shared.UserStatus;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserParam {

  @NotNull private String password;

  @NotNull private String lastName;

  @NotNull private String firstName;

  @NotNull private UserStatus status;

  public static CreateUserParam createParam(
      String password, String lastName, String firstName, UserStatus status) {

    return CreateUserParam.builder()
        .password(password)
        .lastName(lastName)
        .firstName(firstName)
        .status(status)
        .build();
  }
}
