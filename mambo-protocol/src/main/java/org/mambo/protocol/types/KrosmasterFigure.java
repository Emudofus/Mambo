

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class KrosmasterFigure extends NetworkType {
    public static final short TYPE_ID = 397;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeString(uid);
        buf.writeShort(figure);
        buf.writeShort(pedestal);
        buf.writeBoolean(bound);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readString();
        figure = buf.readShort();
        if (figure < 0)
            throw new RuntimeException("Forbidden value on figure = " + figure + ", it doesn't respect the following condition : figure < 0");
        pedestal = buf.readShort();
        if (pedestal < 0)
            throw new RuntimeException("Forbidden value on pedestal = " + pedestal + ", it doesn't respect the following condition : pedestal < 0");
        bound = buf.readBoolean();
    }
    
}
