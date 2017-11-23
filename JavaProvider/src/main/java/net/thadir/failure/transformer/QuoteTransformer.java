package net.thadir.failure.transformer;

import net.thadir.failure.dto.Quote;
import net.thadir.failure.model.JsonQoutes;

public class QuoteTransformer {
  public static JsonQoutes transform(Quote randomQuote) {
    return JsonQoutes.builder().author(randomQuote.getBy()).quote(randomQuote.getQuote()).build();
  }
}
