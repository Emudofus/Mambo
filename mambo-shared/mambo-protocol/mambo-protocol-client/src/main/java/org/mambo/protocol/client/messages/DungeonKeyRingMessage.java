

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(availables.length);
        for (short entry : availables) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(unavailables.length);
        for (short entry : unavailables) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        availables = new short[limit];
        for (int i = 0; i < limit; i++) {
            availables[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        unavailables = new short[limit];
        for (int i = 0; i < limit; i++) {
            unavailables[i] = reader.readShort();
        }
    }
    
}
