

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class StatedElement implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 108;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int elementId;
    public short elementCellId;
    public int elementState;
    
    public StatedElement() { }
    
    public StatedElement(int elementId, short elementCellId, int elementState) {
        this.elementId = elementId;
        this.elementCellId = elementCellId;
        this.elementState = elementState;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(elementId);
        writer.writeShort(elementCellId);
        writer.writeInt(elementState);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        elementId = reader.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
        elementCellId = reader.readShort();
        if (elementCellId < 0 || elementCellId > 559)
            throw new RuntimeException("Forbidden value on elementCellId = " + elementCellId + ", it doesn't respect the following condition : elementCellId < 0 || elementCellId > 559");
        elementState = reader.readInt();
        if (elementState < 0)
            throw new RuntimeException("Forbidden value on elementState = " + elementState + ", it doesn't respect the following condition : elementState < 0");
    }
    
}
