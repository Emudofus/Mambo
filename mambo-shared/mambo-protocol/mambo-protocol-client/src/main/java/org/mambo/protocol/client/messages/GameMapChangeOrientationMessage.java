

// Generated on 11/11/2012 19:17:01
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameMapChangeOrientationMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 946;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ActorOrientation orientation;
    
    public GameMapChangeOrientationMessage() { }
    
    public GameMapChangeOrientationMessage(ActorOrientation orientation) {
        this.orientation = orientation;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        orientation.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        orientation = new ActorOrientation();
        orientation.deserialize(reader);
    }
    
}
