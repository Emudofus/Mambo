

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameFightOptionToggleMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 707;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte option;
    
    public GameFightOptionToggleMessage() { }
    
    public GameFightOptionToggleMessage(byte option) {
        this.option = option;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(option);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        option = reader.readByte();
        if (option < 0)
            throw new RuntimeException("Forbidden value on option = " + option + ", it doesn't respect the following condition : option < 0");
    }
    
}
