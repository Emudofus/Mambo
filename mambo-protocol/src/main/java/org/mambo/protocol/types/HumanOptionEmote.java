

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class HumanOptionEmote extends HumanOption {
    public static final short TYPE_ID = 407;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte emoteId;
    public double emoteStartTime;
    
    public HumanOptionEmote() { }
    
    public HumanOptionEmote(byte emoteId, double emoteStartTime) {
        this.emoteId = emoteId;
        this.emoteStartTime = emoteStartTime;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeByte(emoteId);
        buf.writeDouble(emoteStartTime);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        emoteId = buf.readByte();
        emoteStartTime = buf.readDouble();
    }
    
}
