

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class InventoryPresetSaveMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6165;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte symbolId;
    public boolean saveEquipment;
    
    public InventoryPresetSaveMessage() { }
    
    public InventoryPresetSaveMessage(byte presetId, byte symbolId, boolean saveEquipment) {
        this.presetId = presetId;
        this.symbolId = symbolId;
        this.saveEquipment = saveEquipment;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        writer.writeByte(symbolId);
        writer.writeBoolean(saveEquipment);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        symbolId = reader.readByte();
        if (symbolId < 0)
            throw new RuntimeException("Forbidden value on symbolId = " + symbolId + ", it doesn't respect the following condition : symbolId < 0");
        saveEquipment = reader.readBoolean();
    }
    
}
