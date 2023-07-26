package net.customer.presentation.user;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserReq {

  @Size(min = 8, max = 100)
  private String password;

  @Size(min = 1, max = 100)
  @NotNull
  private String lastName;

  @Size(min = 1, max = 100)
  @NotNull
  private String firstName;

  @NotNull
  @Pattern(regexp = "^(\\d{4})-(\\d{1,2})-(\\d{1,2})$")
  private LocalDate useStartDate;
}
