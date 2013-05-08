

// Generated on 05/08/2013 19:37:52
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildPaddockRemovedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5955;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int paddockId;
    
    public GuildPaddockRemovedMessage() { }
    
    public GuildPaddockRemovedMessage(int paddockId) {
        this.paddockId = paddockId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(paddockId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        paddockId = buf.readInt();
    }
    
}
