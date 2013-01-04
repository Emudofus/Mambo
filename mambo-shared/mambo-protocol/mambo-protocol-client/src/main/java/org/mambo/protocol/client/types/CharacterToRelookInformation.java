

// Generated on 01/04/2013 14:54:44
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(cosmeticId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        cosmeticId = reader.readInt();
        if (cosmeticId < 0)
            throw new RuntimeException("Forbidden value on cosmeticId = " + cosmeticId + ", it doesn't respect the following condition : cosmeticId < 0");
    }
    
}
