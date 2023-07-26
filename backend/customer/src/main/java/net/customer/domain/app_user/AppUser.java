package net.customer.domain.app_user;

import net.customer.domain.shared.UserStatus;
import java.util.UUID;

public class AppUser {

  public final String id;

  public final String password;

  public final String firstName;

  public final String lastName;

  public final String status;

  public AppUser(String password, String lastName, String firstName, UserStatus status) {
    this.id = UUID.randomUUID().toString();
    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.status = status.getName();
  }
}
