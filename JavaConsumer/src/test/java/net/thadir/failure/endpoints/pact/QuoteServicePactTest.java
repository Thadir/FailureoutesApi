package net.thadir.failure.endpoints.pact;

import au.com.dius.pact.consumer.ConsumerPactBuilder;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactSpecVersion;
import au.com.dius.pact.model.RequestResponsePact;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import net.thadir.failure.controller.QuotesStatisticService;
import net.thadir.failure.dto.QuoteStat;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.SocketUtils;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class QuoteServicePactTest {
  @Rule
  public PactProviderRuleMk2 mockProvider  = new PactProviderRuleMk2("quotesProvider", "localhost", SocketUtils.findAvailableTcpPort(), PactSpecVersion.V3, this);

  @Pact(consumer="quotesJavaConsumer") // will default to the provider name from mockProvider
  public RequestResponsePact createFragment(PactDslWithProvider builder) {
    return builder
        .given("test state")
        .uponReceiving("ExampleJavaConsumerPactRuleTest test interaction")
        .path("/quotes/failure")
        .method(HttpMethod.GET.name())
        .willRespondWith()
        .status(200)
        .body("{\n" + "    \"quote\": \"Failure comes only when we forget our ideals and objectives and principles.\",\n"
                  + "    \"author\": \"Jawaharlal Nehru\"\n" + "}", MediaType.APPLICATION_JSON.toString())
        .toPact();
  }

  @Test
  @PactVerification
  public void validQoute() {
    QuoteStat result = QuotesStatisticService.getRandomQuote(mockProvider.getUrl());
    assertThat(result,is(not(nullValue())));
  }
}
