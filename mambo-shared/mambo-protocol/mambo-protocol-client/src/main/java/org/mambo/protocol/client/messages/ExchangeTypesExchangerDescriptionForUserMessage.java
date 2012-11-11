

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(typeDescription.length);
        for (int entry : typeDescription) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        typeDescription = new int[limit];
        for (int i = 0; i < limit; i++) {
            typeDescription[i] = reader.readInt();
        }
    }
    
}
