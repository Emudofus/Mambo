

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ObjectItemToSellInBid extends ObjectItemToSell {
    public static final short TYPE_ID = 164;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short unsoldDelay;
    
    public ObjectItemToSellInBid() { }
    
    public ObjectItemToSellInBid(short objectGID, short powerRate, boolean overMax, ObjectEffect[] effects, int objectUID, int quantity, int objectPrice, short unsoldDelay) {
        super(objectGID, powerRate, overMax, effects, objectUID, quantity, objectPrice);
        this.unsoldDelay = unsoldDelay;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeShort(unsoldDelay);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        unsoldDelay = reader.readShort();
        if (unsoldDelay < 0)
            throw new RuntimeException("Forbidden value on unsoldDelay = " + unsoldDelay + ", it doesn't respect the following condition : unsoldDelay < 0");
    }
    
}
