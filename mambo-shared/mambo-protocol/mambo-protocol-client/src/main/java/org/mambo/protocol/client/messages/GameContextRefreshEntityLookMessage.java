

// Generated on 11/11/2012 20:41:25
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameContextRefreshEntityLookMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5637;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    public EntityLook look;
    
    public GameContextRefreshEntityLookMessage() { }
    
    public GameContextRefreshEntityLookMessage(int id, EntityLook look) {
        this.id = id;
        this.look = look;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        look.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        look = new EntityLook();
        look.deserialize(reader);
    }
    
}
