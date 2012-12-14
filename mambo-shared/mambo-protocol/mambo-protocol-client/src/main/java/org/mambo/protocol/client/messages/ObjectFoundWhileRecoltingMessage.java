

// Generated on 12/14/2012 18:44:16
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(genericId);
        writer.writeInt(quantity);
        writer.writeInt(ressourceGenericId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        genericId = reader.readInt();
        if (genericId < 0)
            throw new RuntimeException("Forbidden value on genericId = " + genericId + ", it doesn't respect the following condition : genericId < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
        ressourceGenericId = reader.readInt();
        if (ressourceGenericId < 0)
            throw new RuntimeException("Forbidden value on ressourceGenericId = " + ressourceGenericId + ", it doesn't respect the following condition : ressourceGenericId < 0");
    }
    
}
