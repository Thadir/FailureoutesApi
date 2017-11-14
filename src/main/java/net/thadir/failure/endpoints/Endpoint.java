package net.thadir.failure.endpoints;

import net.thadir.failure.exception.ExceptionStatus;
import net.thadir.failure.exception.FailureRuntimeException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.function.Supplier;

public class Endpoint {

  protected Response handleErrors(Supplier<Response> responseSupplier) {
    Response response;
    try {
      response = responseSupplier.get();
    } catch (FailureRuntimeException e) {
      response = createExceptionResponse(e);
    }
    return response;
  }

  private Response createExceptionResponse(FailureRuntimeException e) {
    Response.ResponseBuilder response;

    if (e.getExceptionStatus() == ExceptionStatus.NOT_FOUND) {
      response = Response.status(Status.NOT_FOUND).entity(e.getMessage());
    } else if (e.getExceptionStatus() == ExceptionStatus.ILLEGAL_ARGUMENT) {
      response = Response.status(Status.BAD_REQUEST).entity(e.getMessage());
    } else {
      response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage());
    }
    return response.header("Pragma", "no-cache, no-store").header("Cache-Control", "no-cache, no-store").header("Expires", "0").build();
  }

}