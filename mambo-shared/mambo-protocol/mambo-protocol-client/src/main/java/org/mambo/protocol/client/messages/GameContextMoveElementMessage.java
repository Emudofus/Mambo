

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        movement.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        movement = new EntityMovementInformations();
        movement.deserialize(reader);
    }
    
}
