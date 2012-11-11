

// Generated on 11/11/2012 19:06:15
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(itemUID);
        writer.writeInt(itemGID);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        itemUID = reader.readInt();
        itemGID = reader.readInt();
    }
    
}
