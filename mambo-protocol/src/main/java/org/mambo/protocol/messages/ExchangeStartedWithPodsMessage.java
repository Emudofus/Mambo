

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeStartedWithPodsMessage extends ExchangeStartedMessage {
    public static final int MESSAGE_ID = 6129;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int firstCharacterId;
    public int firstCharacterCurrentWeight;
    public int firstCharacterMaxWeight;
    public int secondCharacterId;
    public int secondCharacterCurrentWeight;
    public int secondCharacterMaxWeight;
    
    public ExchangeStartedWithPodsMessage() { }
    
    public ExchangeStartedWithPodsMessage(byte exchangeType, int firstCharacterId, int firstCharacterCurrentWeight, int firstCharacterMaxWeight, int secondCharacterId, int secondCharacterCurrentWeight, int secondCharacterMaxWeight) {
        super(exchangeType);
        this.firstCharacterId = firstCharacterId;
        this.firstCharacterCurrentWeight = firstCharacterCurrentWeight;
        this.firstCharacterMaxWeight = firstCharacterMaxWeight;
        this.secondCharacterId = secondCharacterId;
        this.secondCharacterCurrentWeight = secondCharacterCurrentWeight;
        this.secondCharacterMaxWeight = secondCharacterMaxWeight;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(firstCharacterId);
        buf.writeInt(firstCharacterCurrentWeight);
        buf.writeInt(firstCharacterMaxWeight);
        buf.writeInt(secondCharacterId);
        buf.writeInt(secondCharacterCurrentWeight);
        buf.writeInt(secondCharacterMaxWeight);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        firstCharacterId = buf.readInt();
        firstCharacterCurrentWeight = buf.readInt();
        if (firstCharacterCurrentWeight < 0)
            throw new RuntimeException("Forbidden value on firstCharacterCurrentWeight = " + firstCharacterCurrentWeight + ", it doesn't respect the following condition : firstCharacterCurrentWeight < 0");
        firstCharacterMaxWeight = buf.readInt();
        if (firstCharacterMaxWeight < 0)
            throw new RuntimeException("Forbidden value on firstCharacterMaxWeight = " + firstCharacterMaxWeight + ", it doesn't respect the following condition : firstCharacterMaxWeight < 0");
        secondCharacterId = buf.readInt();
        secondCharacterCurrentWeight = buf.readInt();
        if (secondCharacterCurrentWeight < 0)
            throw new RuntimeException("Forbidden value on secondCharacterCurrentWeight = " + secondCharacterCurrentWeight + ", it doesn't respect the following condition : secondCharacterCurrentWeight < 0");
        secondCharacterMaxWeight = buf.readInt();
        if (secondCharacterMaxWeight < 0)
            throw new RuntimeException("Forbidden value on secondCharacterMaxWeight = " + secondCharacterMaxWeight + ", it doesn't respect the following condition : secondCharacterMaxWeight < 0");
    }
    
}
