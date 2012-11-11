

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeString(loginToken);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        loginToken = reader.readString();
    }
    
}
