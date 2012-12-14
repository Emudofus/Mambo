

// Generated on 12/14/2012 18:44:21
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class CharacterToRecolorInformation extends AbstractCharacterInformation {
    public static final short TYPE_ID = 212;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int[] colors;
    
    public CharacterToRecolorInformation() { }
    
    public CharacterToRecolorInformation(int id, int[] colors) {
        super(id);
        this.colors = colors;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(colors.length);
        for (int entry : colors) {
            writer.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        colors = new int[limit];
        for (int i = 0; i < limit; i++) {
            colors[i] = reader.readInt();
        }
    }
    
}
