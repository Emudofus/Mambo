

// Generated on 11/11/2012 20:41:28
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameDataPlayFarmObjectAnimationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6026;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] cellId;
    
    public GameDataPlayFarmObjectAnimationMessage() { }
    
    public GameDataPlayFarmObjectAnimationMessage(short[] cellId) {
        this.cellId = cellId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(cellId.length);
        for (short entry : cellId) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        cellId = new short[limit];
        for (int i = 0; i < limit; i++) {
            cellId[i] = reader.readShort();
        }
    }
    
}
