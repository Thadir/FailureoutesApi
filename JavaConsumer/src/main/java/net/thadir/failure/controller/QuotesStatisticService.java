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
public class QuotesStatisticService {
  private static final  RestTemplateBuilder  restTemplateBuilder = new RestTemplateBuilder();
  private static final RestTemplate restTemplate = restTemplateBuilder.build();;
  private static final Map<Quote,Integer> statistic = new HashMap<>();


  public static QuoteStat getRandomQuote(String url) {
    String toUseURL = "http://127.0.0.1:8080/quotes/failure";
    if (url != null) {
      toUseURL = url + "/quotes/failure";
    }
    ResponseEntity<Quote> result = restTemplate.exchange(toUseURL, HttpMethod.GET, null, new ParameterizedTypeReference<Quote>() {});
    Quote toStoreAndReturn = result.getBody();
    log.info("Quote recieved {} is in store {}", toStoreAndReturn, statistic.containsKey(toStoreAndReturn));
    Integer increment = 0;
    if(statistic.containsKey(toStoreAndReturn)) {
      increment = statistic.get(statistic);
    }
    increment = increment + 1;
    statistic.put(toStoreAndReturn,increment);
    return new QuoteStat(toStoreAndReturn,increment);
  }
}
