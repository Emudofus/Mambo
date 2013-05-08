

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameContextMoveElementMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 253;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public EntityMovementInformations movement;
    
    public GameContextMoveElementMessage() { }
    
    public GameContextMoveElementMessage(EntityMovementInformations movement) {
        this.movement = movement;
    }
    
    @Override
    public void serialize(Buffer buf) {
        movement.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        movement = new EntityMovementInformations();
        movement.deserialize(buf);
    }
    
}
