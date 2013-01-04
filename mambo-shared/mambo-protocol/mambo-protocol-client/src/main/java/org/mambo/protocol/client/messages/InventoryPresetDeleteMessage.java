

// Generated on 01/04/2013 14:54:39
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InventoryPresetDeleteMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6169;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    
    public InventoryPresetDeleteMessage() { }
    
    public InventoryPresetDeleteMessage(byte presetId) {
        this.presetId = presetId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
    }
    
}
