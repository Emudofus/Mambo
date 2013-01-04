

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
