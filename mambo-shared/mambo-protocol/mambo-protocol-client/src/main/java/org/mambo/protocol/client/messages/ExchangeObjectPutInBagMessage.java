

// Generated on 11/11/2012 20:41:36
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class ExchangeObjectPutInBagMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 6009;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public ExchangeObjectPutInBagMessage() { }
    
    public ExchangeObjectPutInBagMessage(boolean remote, ObjectItem object) {
        super(remote);
        this.object = object;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        object.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        object = new ObjectItem();
        object.deserialize(reader);
    }
    
}
