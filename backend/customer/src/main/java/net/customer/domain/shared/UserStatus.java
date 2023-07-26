package net.customer.domain.shared;

public enum UserStatus {
  ACTIVE("active", "有効"),
  INACTIVE("inactive", "無効"),
  WITHDRAWAL("withdrawal", "退会済み");

  private final String key;
  private final String name;

  UserStatus(String key, String name) {
    this.key = key;
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
