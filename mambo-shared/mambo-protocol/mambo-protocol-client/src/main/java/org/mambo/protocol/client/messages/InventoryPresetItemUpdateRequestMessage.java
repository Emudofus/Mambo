

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class InventoryPresetItemUpdateRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6210;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte presetId;
    public short position;
    public int objUid;
    
    public InventoryPresetItemUpdateRequestMessage() { }
    
    public InventoryPresetItemUpdateRequestMessage(byte presetId, short position, int objUid) {
        this.presetId = presetId;
        this.position = position;
        this.objUid = objUid;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeByte(presetId);
        writer.writeUnsignedByte(position);
        writer.writeInt(objUid);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        presetId = reader.readByte();
        if (presetId < 0)
            throw new RuntimeException("Forbidden value on presetId = " + presetId + ", it doesn't respect the following condition : presetId < 0");
        position = reader.readUnsignedByte();
        if (position < 0 || position > 255)
            throw new RuntimeException("Forbidden value on position = " + position + ", it doesn't respect the following condition : position < 0 || position > 255");
        objUid = reader.readInt();
        if (objUid < 0)
            throw new RuntimeException("Forbidden value on objUid = " + objUid + ", it doesn't respect the following condition : objUid < 0");
    }
    
}
