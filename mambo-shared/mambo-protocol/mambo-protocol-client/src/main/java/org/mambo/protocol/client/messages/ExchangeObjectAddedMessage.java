

// Generated on 11/11/2012 20:41:35
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ExchangeObjectAddedMessage extends ExchangeObjectMessage {
    public static final int MESSAGE_ID = 5516;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public ObjectItem object;
    
    public ExchangeObjectAddedMessage() { }
    
    public ExchangeObjectAddedMessage(boolean remote, ObjectItem object) {
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
