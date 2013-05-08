

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class GuildEmblem extends NetworkType {
    public static final short TYPE_ID = 87;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public short symbolShape;
    public int symbolColor;
    public short backgroundShape;
    public int backgroundColor;
    
    public GuildEmblem() { }
    
    public GuildEmblem(short symbolShape, int symbolColor, short backgroundShape, int backgroundColor) {
        this.symbolShape = symbolShape;
        this.symbolColor = symbolColor;
        this.backgroundShape = backgroundShape;
        this.backgroundColor = backgroundColor;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeShort(symbolShape);
        buf.writeInt(symbolColor);
        buf.writeShort(backgroundShape);
        buf.writeInt(backgroundColor);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        symbolShape = buf.readShort();
        symbolColor = buf.readInt();
        backgroundShape = buf.readShort();
        backgroundColor = buf.readInt();
    }
    
}
