

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightStartingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 700;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte fightType;
    
    public GameFightStartingMessage() { }
    
    public GameFightStartingMessage(byte fightType) {
        this.fightType = fightType;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(fightType);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        fightType = reader.readByte();
        if (fightType < 0)
            throw new RuntimeException("Forbidden value on fightType = " + fightType + ", it doesn't respect the following condition : fightType < 0");
    }
    
}
