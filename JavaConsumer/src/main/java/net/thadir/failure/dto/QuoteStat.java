package net.thadir.failure.dto;


@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.RequiredArgsConstructor
public class QuoteStat {
  private final Quote   quote;
  private final Integer amountReturn;
}
