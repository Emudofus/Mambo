

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(smileyId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        smileyId = buf.readByte();
        if (smileyId < 0)
            throw new RuntimeException("Forbidden value on smileyId = " + smileyId + ", it doesn't respect the following condition : smileyId < 0");
    }
    
}
