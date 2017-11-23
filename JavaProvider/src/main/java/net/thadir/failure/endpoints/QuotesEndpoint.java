package net.thadir.failure.endpoints;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.thadir.failure.controller.QuotesService;
import net.thadir.failure.model.JsonQoutes;
import net.thadir.failure.transformer.QuoteTransformer;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Named
@Path("/quotes")
@Api(value = "Give inspiring quotes about failing")
@Slf4j
public class QuotesEndpoint extends Endpoint {
  private QuotesService quotesService = new QuotesService();

  @GET
  @Path("/failure/")
  @Produces(MediaType.APPLICATION_JSON)
  @ApiOperation(value = "Get organisation by alias",
                notes = "Get organisation matching the given alias.",
                responseContainer = "single result",
                response = JsonQoutes.class)
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Quote found"),
                         @ApiResponse(code = 404, message = "Quote not found"),
                         @ApiResponse(code = 500, message = "Internal Error")})
  public Response getFailureQuotes() {
    Response response = handleErrors(
        () -> Response.ok(QuoteTransformer.transform(quotesService.getRandomQuote()))
            .build());
    return response;
  }
}
