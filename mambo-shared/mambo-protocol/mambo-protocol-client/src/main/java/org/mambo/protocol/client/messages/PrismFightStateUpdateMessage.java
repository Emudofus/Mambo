

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class PrismFightStateUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6040;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte state;
    
    public PrismFightStateUpdateMessage() { }
    
    public PrismFightStateUpdateMessage(byte state) {
        this.state = state;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(state);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        state = reader.readByte();
        if (state < 0)
            throw new RuntimeException("Forbidden value on state = " + state + ", it doesn't respect the following condition : state < 0");
    }
    
}
