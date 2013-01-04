

// Generated on 01/04/2013 14:54:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(firstCharacterId);
        writer.writeInt(firstCharacterCurrentWeight);
        writer.writeInt(firstCharacterMaxWeight);
        writer.writeInt(secondCharacterId);
        writer.writeInt(secondCharacterCurrentWeight);
        writer.writeInt(secondCharacterMaxWeight);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        firstCharacterId = reader.readInt();
        firstCharacterCurrentWeight = reader.readInt();
        if (firstCharacterCurrentWeight < 0)
            throw new RuntimeException("Forbidden value on firstCharacterCurrentWeight = " + firstCharacterCurrentWeight + ", it doesn't respect the following condition : firstCharacterCurrentWeight < 0");
        firstCharacterMaxWeight = reader.readInt();
        if (firstCharacterMaxWeight < 0)
            throw new RuntimeException("Forbidden value on firstCharacterMaxWeight = " + firstCharacterMaxWeight + ", it doesn't respect the following condition : firstCharacterMaxWeight < 0");
        secondCharacterId = reader.readInt();
        secondCharacterCurrentWeight = reader.readInt();
        if (secondCharacterCurrentWeight < 0)
            throw new RuntimeException("Forbidden value on secondCharacterCurrentWeight = " + secondCharacterCurrentWeight + ", it doesn't respect the following condition : secondCharacterCurrentWeight < 0");
        secondCharacterMaxWeight = reader.readInt();
        if (secondCharacterMaxWeight < 0)
            throw new RuntimeException("Forbidden value on secondCharacterMaxWeight = " + secondCharacterMaxWeight + ", it doesn't respect the following condition : secondCharacterMaxWeight < 0");
    }
    
}
