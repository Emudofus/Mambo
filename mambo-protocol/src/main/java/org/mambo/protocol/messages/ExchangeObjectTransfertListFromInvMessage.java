

// Generated on 05/08/2013 19:37:54
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectTransfertListFromInvMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6183;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] ids;
    
    public ExchangeObjectTransfertListFromInvMessage() { }
    
    public ExchangeObjectTransfertListFromInvMessage(int[] ids) {
        this.ids = ids;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(ids.length);
        for (int entry : ids) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        ids = new int[limit];
        for (int i = 0; i < limit; i++) {
            ids[i] = buf.readInt();
        }
    }
    
}
