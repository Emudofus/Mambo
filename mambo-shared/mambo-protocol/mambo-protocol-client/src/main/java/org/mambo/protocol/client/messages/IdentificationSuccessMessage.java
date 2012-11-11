

// Generated on 11/11/2012 19:16:57
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class IdentificationSuccessMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 22;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hasRights;
    public boolean wasAlreadyConnected;
    public String login;
    public String nickname;
    public int accountId;
    public byte communityId;
    public String secretQuestion;
    public double subscriptionEndDate;
    public double accountCreation;
    
    public IdentificationSuccessMessage() { }
    
    public IdentificationSuccessMessage(boolean hasRights, boolean wasAlreadyConnected, String login, String nickname, int accountId, byte communityId, String secretQuestion, double subscriptionEndDate, double accountCreation) {
        this.hasRights = hasRights;
        this.wasAlreadyConnected = wasAlreadyConnected;
        this.login = login;
        this.nickname = nickname;
        this.accountId = accountId;
        this.communityId = communityId;
        this.secretQuestion = secretQuestion;
        this.subscriptionEndDate = subscriptionEndDate;
        this.accountCreation = accountCreation;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, hasRights);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, wasAlreadyConnected);
        writer.writeUnsignedByte(flag1);
        writer.writeString(login);
        writer.writeString(nickname);
        writer.writeInt(accountId);
        writer.writeByte(communityId);
        writer.writeString(secretQuestion);
        writer.writeDouble(subscriptionEndDate);
        writer.writeDouble(accountCreation);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        short flag1 = reader.readUnsignedByte();
        hasRights = BooleanByteWrapper.getFlag(flag1, 0);
        wasAlreadyConnected = BooleanByteWrapper.getFlag(flag1, 1);
        login = reader.readString();
        nickname = reader.readString();
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        communityId = reader.readByte();
        if (communityId < 0)
            throw new RuntimeException("Forbidden value on communityId = " + communityId + ", it doesn't respect the following condition : communityId < 0");
        secretQuestion = reader.readString();
        subscriptionEndDate = reader.readDouble();
        if (subscriptionEndDate < 0)
            throw new RuntimeException("Forbidden value on subscriptionEndDate = " + subscriptionEndDate + ", it doesn't respect the following condition : subscriptionEndDate < 0");
        accountCreation = reader.readDouble();
        if (accountCreation < 0)
            throw new RuntimeException("Forbidden value on accountCreation = " + accountCreation + ", it doesn't respect the following condition : accountCreation < 0");
    }
    
}
