

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GameContextMoveMultipleElementsMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 254;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public EntityMovementInformations[] movements;
    
    public GameContextMoveMultipleElementsMessage() { }
    
    public GameContextMoveMultipleElementsMessage(EntityMovementInformations[] movements) {
        this.movements = movements;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(movements.length);
        for (EntityMovementInformations entry : movements) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        movements = new EntityMovementInformations[limit];
        for (int i = 0; i < limit; i++) {
            movements[i] = new EntityMovementInformations();
            movements[i].deserialize(buf);
        }
    }
    
}
