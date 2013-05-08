

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(playerId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        playerId = buf.readInt();
        if (playerId < 0)
            throw new RuntimeException("Forbidden value on playerId = " + playerId + ", it doesn't respect the following condition : playerId < 0");
    }
    
}
