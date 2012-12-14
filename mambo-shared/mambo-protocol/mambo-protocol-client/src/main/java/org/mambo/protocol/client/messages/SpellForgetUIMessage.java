

// Generated on 12/14/2012 18:44:10
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class SpellForgetUIMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5565;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean open;
    
    public SpellForgetUIMessage() { }
    
    public SpellForgetUIMessage(boolean open) {
        this.open = open;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeBoolean(open);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        open = reader.readBoolean();
    }
    
}
