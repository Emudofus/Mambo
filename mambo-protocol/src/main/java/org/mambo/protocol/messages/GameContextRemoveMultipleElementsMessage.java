

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameContextRemoveMultipleElementsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 252;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] id;
    
    public GameContextRemoveMultipleElementsMessage() { }
    
    public GameContextRemoveMultipleElementsMessage(int[] id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(id.length);
        for (int entry : id) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        id = new int[limit];
        for (int i = 0; i < limit; i++) {
            id[i] = buf.readInt();
        }
    }
    
}
