

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class DungeonKeyRingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6299;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] availables;
    public short[] unavailables;
    
    public DungeonKeyRingMessage() { }
    
    public DungeonKeyRingMessage(short[] availables, short[] unavailables) {
        this.availables = availables;
        this.unavailables = unavailables;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(availables.length);
        for (short entry : availables) {
            buf.writeShort(entry);
        }
        buf.writeUShort(unavailables.length);
        for (short entry : unavailables) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        availables = new short[limit];
        for (int i = 0; i < limit; i++) {
            availables[i] = buf.readShort();
        }
        limit = buf.readUShort();
        unavailables = new short[limit];
        for (int i = 0; i < limit; i++) {
            unavailables[i] = buf.readShort();
        }
    }
    
}
