

// Generated on 11/11/2012 19:06:15
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ShortcutEmote extends Shortcut {
    public static final short TYPE_ID = 389;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte emoteId;
    
    public ShortcutEmote() { }
    
    public ShortcutEmote(int slot, byte emoteId) {
        super(slot);
        this.emoteId = emoteId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(emoteId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        emoteId = reader.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
    }
    
}
