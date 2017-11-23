package net.thadir.failure.dto;

@lombok.Getter
@lombok.Setter
@lombok.ToString
public class Quote {
    private final String quote;
    private       String author;

    public Quote(String by, String quote) {
      this.author = by;
      this.quote = quote;
    }
}
