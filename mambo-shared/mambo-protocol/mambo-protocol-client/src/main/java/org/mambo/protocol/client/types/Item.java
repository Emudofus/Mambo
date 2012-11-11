

// Generated on 11/11/2012 19:06:13
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class Item implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 7;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public Item() { }
    
    
    @Override
    public void serialize(DataWriterInterface writer) {
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
    }
    
}
