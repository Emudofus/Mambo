

// Generated on 05/08/2013 19:37:50
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class SpellUpgradeFailureMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 1202;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    
    public SpellUpgradeFailureMessage() { }
    
    
    @Override
    public void serialize(Buffer buf) {
    }
    
    @Override
    public void deserialize(Buffer buf) {
    }
    
}
