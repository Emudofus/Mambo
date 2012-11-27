

// Generated on 11/11/2012 20:41:39
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterToRecolorInformation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 212;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public int[] colors;
    
    public CharacterToRecolorInformation() { }
    
    public CharacterToRecolorInformation(int id, int[] colors) {
        this.id = id;
        this.colors = colors;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeUnsignedShort(colors.length);
        for (int entry : colors) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        int limit = reader.readUnsignedShort();
        colors = new int[limit];
        for (int i = 0; i < limit; i++) {
            colors[i] = reader.readInt();
        }
    }
    
}
