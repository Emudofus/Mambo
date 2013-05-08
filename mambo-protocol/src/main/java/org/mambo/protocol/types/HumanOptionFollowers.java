

// Generated on 05/08/2013 19:38:01
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeUShort(followingCharactersLook.length);
        for (IndexedEntityLook entry : followingCharactersLook) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        int limit = buf.readUShort();
        followingCharactersLook = new IndexedEntityLook[limit];
        for (int i = 0; i < limit; i++) {
            followingCharactersLook[i] = new IndexedEntityLook();
            followingCharactersLook[i].deserialize(buf);
        }
    }
    
}
