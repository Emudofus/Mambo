

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GoldItem extends Item {
    public static final short TYPE_ID = 123;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int sum;
    
    public GoldItem() { }
    
    public GoldItem(int sum) {
        this.sum = sum;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(sum);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        sum = reader.readInt();
        if (sum < 0)
            throw new RuntimeException("Forbidden value on sum = " + sum + ", it doesn't respect the following condition : sum < 0");
    }
    
}
