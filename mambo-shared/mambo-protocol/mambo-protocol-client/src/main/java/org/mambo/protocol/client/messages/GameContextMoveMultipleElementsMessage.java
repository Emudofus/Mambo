

// Generated on 01/04/2013 14:54:22
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(movements.length);
        for (EntityMovementInformations entry : movements) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        movements = new EntityMovementInformations[limit];
        for (int i = 0; i < limit; i++) {
            movements[i] = new EntityMovementInformations();
            movements[i].deserialize(reader);
        }
    }
    
}
