

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class GameDataPaddockObjectListAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5992;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockItem[] paddockItemDescription;
    
    public GameDataPaddockObjectListAddMessage() { }
    
    public GameDataPaddockObjectListAddMessage(PaddockItem[] paddockItemDescription) {
        this.paddockItemDescription = paddockItemDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(paddockItemDescription.length);
        for (PaddockItem entry : paddockItemDescription) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        paddockItemDescription = new PaddockItem[limit];
        for (int i = 0; i < limit; i++) {
            paddockItemDescription[i] = new PaddockItem();
            paddockItemDescription[i].deserialize(reader);
        }
    }
    
}
