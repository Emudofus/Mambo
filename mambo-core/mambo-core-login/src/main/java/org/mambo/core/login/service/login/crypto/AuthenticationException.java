package org.mambo.core.login.service.login.crypto;

import org.jetbrains.annotations.NotNull;
import org.mambo.protocol.client.enums.IdentificationFailureReasonEnum;

/**
 * @author Blackrush
 */
public class AuthenticationException extends RuntimeException {
    private final IdentificationFailureReasonEnum reason;

    public AuthenticationException(@NotNull IdentificationFailureReasonEnum reason) {
        this.reason = reason;
    }

    public AuthenticationException(@NotNull String message, @NotNull IdentificationFailureReasonEnum reason) {
        super(message);
        this.reason = reason;
    }

    @NotNull
    public IdentificationFailureReasonEnum getReason() {
        return reason;
    }
}
