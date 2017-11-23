package net.thadir.failure.controller;

import lombok.extern.slf4j.Slf4j;
import net.thadir.failure.dto.Quote;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class QuotesService {
  List<Quote>         failures;
  private SecureRandom randomiser = new SecureRandom();

  public QuotesService() {
    failures = new ArrayList<>();
    failures.add(new Quote("Winston Churchill", "Success is not final, failure is not fatal: it is the courage to continue that counts."));
    failures.add(new Quote("Winston Churchill", "Success consists of going from failure to failure without loss of enthusiasm."));
    failures.add(new Quote("Oprah Winfrey", "Think like a queen. A queen is not afraid to fail. Failure is another steppingstone to greatness."));
    failures.add(new Quote("Jawaharlal Nehru", "Failure comes only when we forget our ideals and objectives and principles."));
    failures.add(new Quote("Og Mandino", "Failure will never overtake me if my determination to succeed is strong enough."));
    failures.add(new Quote("Colin Powell", "There are no secrets to success. It is the result of preparation, hard work, and learning from failure."));
    failures.add(new Quote("Colin Powell", "Success is the result of perfection, hard work, learning from failure, loyalty, and persistence."));
    failures.add(new Quote("Thomas A. Edison", "I have not failed. I've just found 10,000 ways that won't work."));
    failures.add(new Quote("Henry Ford", "Failure is simply the opportunity to begin again, this time more intelligently."));
    failures.add(new Quote("Erin Cummings",
                "At the end of the day, you are solely responsible for your success and your failure. And the sooner you realize that, you accept that, and integrate that into your work ethic, you will start being successful. As long as you blame others for the reason you aren't where you want to be, you will always be a failure."));
    failures.add(new Quote("Johnny Cash",
                "You build on failure. You use it as a stepping stone. Close the door on the past. You don't try to forget the mistakes, but you don't dwell on it. You don't let it have any of your energy, or any of your time, or any of your space."));
    failures.add(new Quote("Michael Jordan", "I can accept failure, everyone fails at something. But I can't accept not trying."));
  }

  public Quote getRandomQuote() {
    int byInt = randomiser.nextInt(failures.size());
    log.info("The random number for this quote is {}", byInt);
    return failures.get(byInt);
  }
}
