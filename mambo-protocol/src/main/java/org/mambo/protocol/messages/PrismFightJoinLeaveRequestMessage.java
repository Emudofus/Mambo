

// Generated on 05/08/2013 19:37:57
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PrismFightJoinLeaveRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 5843;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public boolean join;
    
    public PrismFightJoinLeaveRequestMessage() { }
    
    public PrismFightJoinLeaveRequestMessage(boolean join) {
        this.join = join;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeBoolean(join);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        join = buf.readBoolean();
    }
    
}
