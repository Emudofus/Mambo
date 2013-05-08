

// Generated on 05/08/2013 19:37:55
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeTypesExchangerDescriptionForUserMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5765;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int[] typeDescription;
    
    public ExchangeTypesExchangerDescriptionForUserMessage() { }
    
    public ExchangeTypesExchangerDescriptionForUserMessage(int[] typeDescription) {
        this.typeDescription = typeDescription;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(typeDescription.length);
        for (int entry : typeDescription) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        typeDescription = new int[limit];
        for (int i = 0; i < limit; i++) {
            typeDescription[i] = buf.readInt();
        }
    }
    
}
