package net.thadir.failure.endpoints.pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.TestTarget;
import net.thadir.failure.controller.QuotesService;
import net.thadir.failure.dto.Quote;
import net.thadir.failure.endpoints.QuotesEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PactRunner.class)
@Provider("quotesProvider")
@PactFolder(value = "target/pacts")
@Ignore
public class QuoteServiceProviderPactTest extends JerseyTest {
  private QuotesService quotesService;
  @TestTarget
  public final HttpTarget target = new HttpTarget(getPort());

  @Override
  protected ResourceConfig configure() {
    quotesService = mock(QuotesService.class);
    return new ResourceConfig()
        .register(new QuotesEndpoint(quotesService));
  }

  @Override
  protected TestContainerFactory getTestContainerFactory() {
    return new GrizzlyWebTestContainerFactory();
  }

  protected DeploymentContext configureDeployment() {
    return ServletDeploymentContext.forServlet(new ServletContainer(this.configure()))
        .build();
  }

  @State("test state")
  public void systemUsersAreAvailable() throws Exception {
    when(quotesService.getRandomQuote()).thenReturn(new Quote("Jawaharlal Nehru","Failure comes only when we forget our ideals and objectives and principles."));
  }
}
