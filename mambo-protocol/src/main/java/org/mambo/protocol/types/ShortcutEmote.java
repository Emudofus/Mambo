

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(emoteId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        emoteId = buf.readByte();
        if (emoteId < 0)
            throw new RuntimeException("Forbidden value on emoteId = " + emoteId + ", it doesn't respect the following condition : emoteId < 0");
    }
    
}
