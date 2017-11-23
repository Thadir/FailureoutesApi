package net.thadir.failure;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import lombok.extern.slf4j.Slf4j;
import net.thadir.failure.endpoints.QuotesStatisticEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    doRegister();
  }

  private void doRegister() {
    log.info("Start Failure Quotes API Provider configure");
    register(ApiListingResource.class);
    register(SwaggerSerializers.class);
    register(QuotesStatisticEndpoint.class);
    log.info("End Failure Quotes API Provider configure");
  }
}
