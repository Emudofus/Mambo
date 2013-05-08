

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class IdentificationSuccessWithLoginTokenMessage extends IdentificationSuccessMessage {
    public static final int MESSAGE_ID = 6209;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public String loginToken;
    
    public IdentificationSuccessWithLoginTokenMessage() { }
    
    public IdentificationSuccessWithLoginTokenMessage(boolean hasRights, boolean wasAlreadyConnected, String login, String nickname, int accountId, byte communityId, String secretQuestion, double subscriptionEndDate, double accountCreation, String loginToken) {
        super(hasRights, wasAlreadyConnected, login, nickname, accountId, communityId, secretQuestion, subscriptionEndDate, accountCreation);
        this.loginToken = loginToken;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(loginToken);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        loginToken = buf.readString();
    }
    
}
