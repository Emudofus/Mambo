

// Generated on 05/08/2013 19:37:41
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterSelectionMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 152;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int id;
    
    public CharacterSelectionMessage() { }
    
    public CharacterSelectionMessage(int id) {
        this.id = id;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        if (id < 1 || id > 2147483647)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 1 || id > 2147483647");
    }
    
}
