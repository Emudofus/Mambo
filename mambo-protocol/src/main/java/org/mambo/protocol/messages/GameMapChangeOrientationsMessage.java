

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeUShort(orientations.length);
        for (ActorOrientation entry : orientations) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        orientations = new ActorOrientation[limit];
        for (int i = 0; i < limit; i++) {
            orientations[i] = new ActorOrientation();
            orientations[i].deserialize(buf);
        }
    }
    
}
