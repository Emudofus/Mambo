

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShortcutObject extends Shortcut {
    public static final short TYPE_ID = 367;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public ShortcutObject() { }
    
    public ShortcutObject(int slot) {
        super(slot);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
