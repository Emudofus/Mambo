

// Generated on 12/14/2012 18:44:22
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
