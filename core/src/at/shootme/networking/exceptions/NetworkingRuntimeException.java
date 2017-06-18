package at.shootme.networking.exceptions;

public class NetworkingRuntimeException extends RuntimeException {
    public NetworkingRuntimeException() {
    }

    public NetworkingRuntimeException(String message) {
        super(message);
    }

    public NetworkingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkingRuntimeException(Throwable cause) {
        super(cause);
    }

    public NetworkingRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}