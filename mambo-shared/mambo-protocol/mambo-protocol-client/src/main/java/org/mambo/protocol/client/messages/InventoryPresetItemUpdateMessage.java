

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryPresetItemUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6168;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public PresetItem presetItem;
    
    public InventoryPresetItemUpdateMessage() { }
    
    public InventoryPresetItemUpdateMessage(byte presetId, PresetItem presetItem) {
        this.presetId = presetId;
        this.presetItem = presetItem;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        presetItem.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        presetItem = new PresetItem();
        presetItem.deserialize(reader);
    }
    
}
