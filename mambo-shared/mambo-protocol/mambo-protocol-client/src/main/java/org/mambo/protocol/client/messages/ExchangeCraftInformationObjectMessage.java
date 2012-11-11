

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeCraftInformationObjectMessage extends ExchangeCraftResultWithObjectIdMessage {
    public static final int MESSAGE_ID = 5794;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int playerId;
    
    public ExchangeCraftInformationObjectMessage() { }
    
    public ExchangeCraftInformationObjectMessage(byte craftResult, int objectGenericId, int playerId) {
        super(craftResult, objectGenericId);
        this.playerId = playerId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(playerId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        playerId = reader.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
