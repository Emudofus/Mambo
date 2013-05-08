

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(actions.length);
        for (StartupActionAddObject entry : actions) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        actions = new StartupActionAddObject[limit];
        for (int i = 0; i < limit; i++) {
            actions[i] = new StartupActionAddObject();
            actions[i].deserialize(buf);
        }
    }
    
}
