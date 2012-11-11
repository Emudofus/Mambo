

// Generated on 11/11/2012 19:17:09
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        objectInfo.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        objectInfo = new ObjectItemNotInContainer();
        objectInfo.deserialize(reader);
    }
    
}
