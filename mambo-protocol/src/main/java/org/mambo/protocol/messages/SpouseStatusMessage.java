

// Generated on 05/08/2013 19:37:51
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpouseStatusMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6265;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean hasSpouse;
    
    public SpouseStatusMessage() { }
    
    public SpouseStatusMessage(boolean hasSpouse) {
        this.hasSpouse = hasSpouse;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(hasSpouse);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        hasSpouse = buf.readBoolean();
    }
    
}
