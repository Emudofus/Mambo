

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class ShortcutSmiley extends Shortcut {
    public static final short TYPE_ID = 388;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte smileyId;
    
    public ShortcutSmiley() { }
    
    public ShortcutSmiley(int slot, byte smileyId) {
        super(slot);
        this.smileyId = smileyId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        smileyId = reader.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
    }
    
}
