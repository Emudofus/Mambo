

// Generated on 05/08/2013 19:37:44
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameFightTurnListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 713;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] ids;
    public int[] deadsIds;
    
    public GameFightTurnListMessage() { }
    
    public GameFightTurnListMessage(int[] ids, int[] deadsIds) {
        this.ids = ids;
        this.deadsIds = deadsIds;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(ids.length);
        for (int entry : ids) {
            buf.writeInt(entry);
        }
        buf.writeUShort(deadsIds.length);
        for (int entry : deadsIds) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        ids = new int[limit];
        for (int i = 0; i < limit; i++) {
            ids[i] = buf.readInt();
        }
        limit = buf.readUShort();
        deadsIds = new int[limit];
        for (int i = 0; i < limit; i++) {
            deadsIds[i] = buf.readInt();
        }
    }
    
}
