

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameMapChangeOrientationsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6155;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ActorOrientation[] orientations;
    
    public GameMapChangeOrientationsMessage() { }
    
    public GameMapChangeOrientationsMessage(ActorOrientation[] orientations) {
        this.orientations = orientations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(orientations.length);
        for (ActorOrientation entry : orientations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        orientations = new ActorOrientation[limit];
        for (int i = 0; i < limit; i++) {
            orientations[i] = new ActorOrientation();
            orientations[i].deserialize(reader);
        }
    }
    
}
