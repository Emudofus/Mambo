

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(colors.length);
        for (int entry : colors) {
            buf.writeInt(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        colors = new int[limit];
        for (int i = 0; i < limit; i++) {
            colors[i] = buf.readInt();
        }
    }
    
}
