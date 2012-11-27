

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StartupActionsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1301;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public StartupActionAddObject[] actions;
    
    public StartupActionsListMessage() { }
    
    public StartupActionsListMessage(StartupActionAddObject[] actions) {
        this.actions = actions;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(actions.length);
        for (StartupActionAddObject entry : actions) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        actions = new StartupActionAddObject[limit];
        for (int i = 0; i < limit; i++) {
            actions[i] = new StartupActionAddObject();
            actions[i].deserialize(reader);
        }
    }
    
}
