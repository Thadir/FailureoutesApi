package net.thadir.failure.controller;

import lombok.extern.slf4j.Slf4j;
import net.thadir.failure.dto.Quote;
import net.thadir.failure.dto.QuoteStat;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class QuotesService {
  private final RestTemplate restTemplate;
  private final Map<Quote,Integer> statistic;

  public QuotesService() {
    RestTemplateBuilder  restTemplateBuilder = new RestTemplateBuilder();
    this.restTemplate = restTemplateBuilder.build();
    statistic = new HashMap<>();
  }


  public QuoteStat getRandomQuote() {
    ResponseEntity<Quote> result = this.restTemplate.exchange("127.0.0.1:8080/quotes/failure", HttpMethod.GET, null, new ParameterizedTypeReference<Quote>() {});
    Quote toStoreAndReturn = result.getBody();
    Integer increment = 0;
    if(statistic.containsKey(toStoreAndReturn)) {
      increment = statistic.get(statistic);
    }
    increment = increment + 1;
    statistic.put(toStoreAndReturn,increment);
    return new QuoteStat(toStoreAndReturn,increment);
  }
}
