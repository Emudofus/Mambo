

// Generated on 05/08/2013 19:37:56
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeObjectModifiedMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 5519;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public ExchangeObjectModifiedMessage() { }
    
    public ExchangeObjectModifiedMessage(boolean remote, ObjectItem object) {
        super(remote);
        this.object = object;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        object.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        object = new ObjectItem();
        object.deserialize(buf);
    }
    
}
