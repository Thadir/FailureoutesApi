package net.thadir.failure.transformer;

import lombok.extern.slf4j.Slf4j;
import net.thadir.failure.dto.Quote;
import net.thadir.failure.model.JsonQoutes;

@Slf4j
public class QuoteTransformer {
  public static JsonQoutes transform(Quote randomQuote) {
    log.info("Transforming Quote  {} ",randomQuote);
    return JsonQoutes.builder().author(randomQuote.getBy()).quote(randomQuote.getQuote()).build();
  }
}
