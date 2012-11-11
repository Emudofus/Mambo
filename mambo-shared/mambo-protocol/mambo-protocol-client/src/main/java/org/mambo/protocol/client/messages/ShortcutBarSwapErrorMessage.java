

// Generated on 11/11/2012 19:17:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ShortcutBarSwapErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6226;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte error;
    
    public ShortcutBarSwapErrorMessage() { }
    
    public ShortcutBarSwapErrorMessage(byte error) {
        this.error = error;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(error);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        error = reader.readByte();
        if (error < 0)
            throw new RuntimeException("Forbidden value on error = " + error + ", it doesn't respect the following condition : error < 0");
    }
    
}
