

// Generated on 05/08/2013 19:37:47
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(cellId.length);
        for (short entry : cellId) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        cellId = new short[limit];
        for (int i = 0; i < limit; i++) {
            cellId[i] = buf.readShort();
        }
    }
    
}
