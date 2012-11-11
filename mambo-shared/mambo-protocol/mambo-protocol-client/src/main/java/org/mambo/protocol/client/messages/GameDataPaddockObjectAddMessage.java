

// Generated on 11/11/2012 20:41:26
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GameDataPaddockObjectAddMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5990;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public PaddockItem paddockItemDescription;
    
    public GameDataPaddockObjectAddMessage() { }
    
    public GameDataPaddockObjectAddMessage(PaddockItem paddockItemDescription) {
        this.paddockItemDescription = paddockItemDescription;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        paddockItemDescription.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        paddockItemDescription = new PaddockItem();
        paddockItemDescription.deserialize(reader);
    }
    
}
