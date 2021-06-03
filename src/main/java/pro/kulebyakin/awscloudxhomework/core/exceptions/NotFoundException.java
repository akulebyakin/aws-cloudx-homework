package pro.kulebyakin.awscloudxhomework.core.exceptions;


public class NotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Error! Entity with id '%s' not found";

    public NotFoundException(Long entityId) {
        super(String.format(ERROR_MESSAGE, entityId));
    }
}
