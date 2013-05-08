

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeInt(kamasTotal);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        kamasTotal = buf.readInt();
    }
    
}
