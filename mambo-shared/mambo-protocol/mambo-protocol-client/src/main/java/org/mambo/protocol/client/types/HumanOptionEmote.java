

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(emoteId);
        writer.writeDouble(emoteStartTime);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        emoteId = reader.readByte();
        emoteStartTime = reader.readDouble();
    }
    
}
