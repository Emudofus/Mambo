

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryPresetUseResultMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6163;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public byte code;
    public short[] unlinkedPosition;
    
    public InventoryPresetUseResultMessage() { }
    
    public InventoryPresetUseResultMessage(byte presetId, byte code, short[] unlinkedPosition) {
        this.presetId = presetId;
        this.code = code;
        this.unlinkedPosition = unlinkedPosition;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        writer.writeByte(code);
        writer.writeUnsignedShort(unlinkedPosition.length);
        for (short entry : unlinkedPosition) {
            writer.writeUnsignedByte(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        code = reader.readByte();
        if (code < 0)
            throw new RuntimeException("Forbidden value on code = " + code + ", it doesn't respect the following condition : code < 0");
        int limit = reader.readUnsignedShort();
        unlinkedPosition = new short[limit];
        for (int i = 0; i < limit; i++) {
            unlinkedPosition[i] = reader.readUnsignedByte();
        }
    }
    
}
