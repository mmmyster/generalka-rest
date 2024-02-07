package org.generalka.PAZ1c_Generalka.storage;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3881335702567833226L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
