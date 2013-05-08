

// Generated on 05/08/2013 19:37:38
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        short flag1 = 0;
        flag1 = BooleanByteWrapper.setFlag(flag1, 0, hasRights);
        flag1 = BooleanByteWrapper.setFlag(flag1, 1, wasAlreadyConnected);
        buf.writeUByte(flag1);
        buf.writeString(login);
        buf.writeString(nickname);
        buf.writeInt(accountId);
        buf.writeByte(communityId);
        buf.writeString(secretQuestion);
        buf.writeDouble(subscriptionEndDate);
        buf.writeDouble(accountCreation);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        short flag1 = buf.readUByte();
        hasRights = BooleanByteWrapper.getFlag(flag1, 0);
        wasAlreadyConnected = BooleanByteWrapper.getFlag(flag1, 1);
        login = buf.readString();
        nickname = buf.readString();
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        communityId = buf.readByte();
        if (communityId < 0)
            throw new RuntimeException("Forbidden value on communityId = " + communityId + ", it doesn't respect the following condition : communityId < 0");
        secretQuestion = buf.readString();
        subscriptionEndDate = buf.readDouble();
        if (subscriptionEndDate < 0)
            throw new RuntimeException("Forbidden value on subscriptionEndDate = " + subscriptionEndDate + ", it doesn't respect the following condition : subscriptionEndDate < 0");
        accountCreation = buf.readDouble();
        if (accountCreation < 0)
            throw new RuntimeException("Forbidden value on accountCreation = " + accountCreation + ", it doesn't respect the following condition : accountCreation < 0");
    }
    
}
