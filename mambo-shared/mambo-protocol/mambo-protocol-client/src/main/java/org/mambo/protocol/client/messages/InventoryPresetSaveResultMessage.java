

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryPresetSaveResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6170;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte code;
    
    public InventoryPresetSaveResultMessage() { }
    
    public InventoryPresetSaveResultMessage(byte presetId, byte code) {
        this.presetId = presetId;
        this.code = code;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        writer.writeByte(code);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        code = reader.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
    }
    
}
