

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class CharacterToRelookInformation extends AbstractCharacterInformation {
    public static final short TYPE_ID = 399;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int cosmeticId;
    
    public CharacterToRelookInformation() { }
    
    public CharacterToRelookInformation(int id, int cosmeticId) {
        super(id);
        this.cosmeticId = cosmeticId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(cosmeticId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        cosmeticId = buf.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
