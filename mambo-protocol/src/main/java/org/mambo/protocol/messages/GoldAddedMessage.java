

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GoldAddedMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6030;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public GoldItem gold;
    
    public GoldAddedMessage() { }
    
    public GoldAddedMessage(GoldItem gold) {
        this.gold = gold;
    }
    
    @Override
    public void serialize(Buffer buf) {
        gold.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        gold = new GoldItem();
        gold.deserialize(buf);
    }
    
}
