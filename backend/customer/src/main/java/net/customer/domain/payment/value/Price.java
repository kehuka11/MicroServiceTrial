package net.customer.domain.payment.value;

import net.customer.domain.shared.exception.DomainException;

public class Price {
  private final int MIN_PRICE = -100000; // 返金可能額

  private final int MAX_PRICE = 100000; // 支払可能額

  public final int value;

  public Price(int value) {

    if (value < MIN_PRICE || value > MAX_PRICE) {
      throw new DomainException("金額が有効範囲を超えてます。");
    }
    this.value = value;
  }
}
