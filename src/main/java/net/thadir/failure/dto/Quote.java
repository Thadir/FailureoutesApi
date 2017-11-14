package net.thadir.failure.dto;

@lombok.Getter
@lombok.Setter
@lombok.RequiredArgsConstructor
@lombok.EqualsAndHashCode(of = {"quote", "by"})
@lombok.ToString
public class Quote {
  private final String quote;
  private       String by;
}
