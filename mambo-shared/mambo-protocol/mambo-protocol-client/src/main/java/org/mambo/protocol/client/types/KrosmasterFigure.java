

// Generated on 01/04/2013 14:54:49
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class KrosmasterFigure implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 397;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String uid;
    public short figure;
    public short pedestal;
    public boolean bound;
    
    public KrosmasterFigure() { }
    
    public KrosmasterFigure(String uid, short figure, short pedestal, boolean bound) {
        this.uid = uid;
        this.figure = figure;
        this.pedestal = pedestal;
        this.bound = bound;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeString(uid);
        writer.writeShort(figure);
        writer.writeShort(pedestal);
        writer.writeBoolean(bound);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readString();
        figure = reader.readShort();
        if (figure < 0)
            throw new RuntimeException("Forbidden value on figure = " + figure + ", it doesn't respect the following condition : figure < 0");
        pedestal = reader.readShort();
        if (pedestal < 0)
            throw new RuntimeException("Forbidden value on pedestal = " + pedestal + ", it doesn't respect the following condition : pedestal < 0");
        bound = reader.readBoolean();
    }
    
}
