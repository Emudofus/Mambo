

// Generated on 12/14/2012 18:44:12
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class KamasUpdateMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5537;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int kamasTotal;
    
    public KamasUpdateMessage() { }
    
    public KamasUpdateMessage(int kamasTotal) {
        this.kamasTotal = kamasTotal;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(kamasTotal);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        kamasTotal = reader.readInt();
    }
    
}
