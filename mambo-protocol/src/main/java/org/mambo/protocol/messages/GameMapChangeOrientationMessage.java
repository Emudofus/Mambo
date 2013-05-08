

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        orientation.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        orientation = new ActorOrientation();
        orientation.deserialize(buf);
    }
    
}
