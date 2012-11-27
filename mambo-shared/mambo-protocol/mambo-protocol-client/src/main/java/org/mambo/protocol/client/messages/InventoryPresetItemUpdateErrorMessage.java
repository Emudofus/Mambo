

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InventoryPresetItemUpdateErrorMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6211;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte code;
    
    public InventoryPresetItemUpdateErrorMessage() { }
    
    public InventoryPresetItemUpdateErrorMessage(byte code) {
        this.code = code;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(code);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        code = reader.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
    }
    
}
