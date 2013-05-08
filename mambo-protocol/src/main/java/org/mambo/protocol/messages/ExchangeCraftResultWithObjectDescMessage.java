

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultMessage {
    public static final int MESSAGE_ID = 5999;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItemNotInContainer objectInfo;
    
    public ExchangeCraftResultWithObjectDescMessage() { }
    
    public ExchangeCraftResultWithObjectDescMessage(byte craftResult, ObjectItemNotInContainer objectInfo) {
        super(craftResult);
        this.objectInfo = objectInfo;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        objectInfo.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        objectInfo = new ObjectItemNotInContainer();
        objectInfo.deserialize(buf);
    }
    
}
