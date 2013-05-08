

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class StatedElement extends NetworkType {
    public static final short TYPE_ID = 108;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(elementId);
        buf.writeShort(elementCellId);
        buf.writeInt(elementState);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        elementId = buf.readInt();
        if (elementId < 0)
            throw new RuntimeException("Forbidden value on elementId = " + elementId + ", it doesn't respect the following condition : elementId < 0");
        elementCellId = buf.readShort();
        if (elementCellId < 0 || elementCellId > 559)
            throw new RuntimeException("Forbidden value on elementCellId = " + elementCellId + ", it doesn't respect the following condition : elementCellId < 0 || elementCellId > 559");
        elementState = buf.readInt();
        if (elementState < 0)
            throw new RuntimeException("Forbidden value on elementState = " + elementState + ", it doesn't respect the following condition : elementState < 0");
    }
    
}
