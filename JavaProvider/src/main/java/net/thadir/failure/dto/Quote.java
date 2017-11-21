package net.thadir.failure.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Quote {
    private final String quote;
    private       String by;

    public Quote(String by, String quote) {
      this.by = by;
      this.quote = quote;
    }
}
