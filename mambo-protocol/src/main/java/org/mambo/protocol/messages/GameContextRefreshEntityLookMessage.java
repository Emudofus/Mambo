

// Generated on 05/08/2013 19:37:43
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        look.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        look = new EntityLook();
        look.deserialize(buf);
    }
    
}
