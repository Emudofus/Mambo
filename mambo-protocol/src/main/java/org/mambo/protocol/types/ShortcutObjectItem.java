

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class ShortcutObjectItem extends ShortcutObject {
    public static final short TYPE_ID = 371;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int itemUID;
    public int itemGID;
    
    public ShortcutObjectItem() { }
    
    public ShortcutObjectItem(int slot, int itemUID, int itemGID) {
        super(slot);
        this.itemUID = itemUID;
        this.itemGID = itemGID;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(itemUID);
        buf.writeInt(itemGID);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        itemUID = buf.readInt();
        itemGID = buf.readInt();
    }
    
}
