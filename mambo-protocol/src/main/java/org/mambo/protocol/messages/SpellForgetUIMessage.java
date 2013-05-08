

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeBoolean(open);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        open = buf.readBoolean();
    }
    
}
