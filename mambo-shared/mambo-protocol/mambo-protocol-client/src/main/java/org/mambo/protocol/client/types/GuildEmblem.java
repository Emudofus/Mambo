

// Generated on 11/11/2012 19:06:14
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class GuildEmblem implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 87;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeShort(symbolShape);
        writer.writeInt(symbolColor);
        writer.writeShort(backgroundShape);
        writer.writeInt(backgroundColor);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        symbolShape = reader.readShort();
        symbolColor = reader.readInt();
        backgroundShape = reader.readShort();
        backgroundColor = reader.readInt();
    }
    
}
