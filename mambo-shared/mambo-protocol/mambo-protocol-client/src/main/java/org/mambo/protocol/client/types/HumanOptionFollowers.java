

// Generated on 01/04/2013 14:54:46
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class HumanOptionFollowers extends HumanOption {
    public static final short TYPE_ID = 410;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public IndexedEntityLook[] followingCharactersLook;
    
    public HumanOptionFollowers() { }
    
    public HumanOptionFollowers(IndexedEntityLook[] followingCharactersLook) {
        this.followingCharactersLook = followingCharactersLook;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeUnsignedShort(followingCharactersLook.length);
        for (IndexedEntityLook entry : followingCharactersLook) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        int limit = reader.readUnsignedShort();
        followingCharactersLook = new IndexedEntityLook[limit];
        for (int i = 0; i < limit; i++) {
            followingCharactersLook[i] = new IndexedEntityLook();
            followingCharactersLook[i].deserialize(reader);
        }
    }
    
}
