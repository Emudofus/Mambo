

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameMapMovementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 951;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] keyMovements;
    public int actorId;
    
    public GameMapMovementMessage() { }
    
    public GameMapMovementMessage(short[] keyMovements, int actorId) {
        this.keyMovements = keyMovements;
        this.actorId = actorId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(keyMovements.length);
        for (short entry : keyMovements) {
            writer.writeShort(entry);
        }
        writer.writeInt(actorId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        keyMovements = new short[limit];
        for (int i = 0; i < limit; i++) {
            keyMovements[i] = reader.readShort();
        }
        actorId = reader.readInt();
    }
    
}
