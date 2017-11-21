package net.thadir.failure;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import net.thadir.failure.endpoints.QuotesEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class JerseyConfig extends ResourceConfig {

  private static final Logger LOGGER = LoggerFactory.getLogger(JerseyConfig.class);

  public JerseyConfig() {
    doRegister();
  }

  @PostConstruct
  public void init() {
    LOGGER.info("Start Failure Quotes API Provider configure");
    register(ApiListingResource.class);
    register(SwaggerSerializers.class);

    BeanConfig beanConfig = new BeanConfig();
    beanConfig.setSchemes(new String[] {"http"});
    beanConfig.setResourcePackage("net.thadir.failure.endpoints");
    beanConfig.setScan(true);

    LOGGER.info("End Failure Quotes API Provider configure");
  }

  private void doRegister() {
    register(QuotesEndpoint.class);
  }
}
