

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ObjectFoundWhileRecoltingMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6017;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int genericId;
    public int quantity;
    public int ressourceGenericId;
    
    public ObjectFoundWhileRecoltingMessage() { }
    
    public ObjectFoundWhileRecoltingMessage(int genericId, int quantity, int ressourceGenericId) {
        this.genericId = genericId;
        this.quantity = quantity;
        this.ressourceGenericId = ressourceGenericId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(genericId);
        buf.writeInt(quantity);
        buf.writeInt(ressourceGenericId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        genericId = buf.readInt();
        if (genericId < 0)
            throw new RuntimeException("Forbidden value on genericId = " + genericId + ", it doesn't respect the following condition : genericId < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
        ressourceGenericId = buf.readInt();
        if (ressourceGenericId < 0)
            throw new RuntimeException("Forbidden value on ressourceGenericId = " + ressourceGenericId + ", it doesn't respect the following condition : ressourceGenericId < 0");
    }
    
}
