package net.thadir.failure.exception;

public class FailureRuntimeException extends RuntimeException {

  private static final long serialVersionUID = 131510984234081708L;
  private ExceptionStatus exceptionStatus;

  public FailureRuntimeException(ExceptionStatus exceptionStatus) {
    this.exceptionStatus = exceptionStatus;

  }

  public FailureRuntimeException(ExceptionStatus exceptionStatus, String message) {
    super(message);
    this.exceptionStatus = exceptionStatus;
  }

  public ExceptionStatus getExceptionStatus() {
    return exceptionStatus;
  }
}
