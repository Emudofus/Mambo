

// Generated on 12/14/2012 18:44:17
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShortcutBarAddErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6227;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte error;
    
    public ShortcutBarAddErrorMessage() { }
    
    public ShortcutBarAddErrorMessage(byte error) {
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
