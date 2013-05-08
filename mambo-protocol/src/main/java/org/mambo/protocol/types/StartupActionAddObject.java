

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class StartupActionAddObject extends NetworkType {
    public static final short TYPE_ID = 52;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int uid;
    public String title;
    public String text;
    public String descUrl;
    public String pictureUrl;
    public ObjectItemInformationWithQuantity[] items;
    
    public StartupActionAddObject() { }
    
    public StartupActionAddObject(int uid, String title, String text, String descUrl, String pictureUrl, ObjectItemInformationWithQuantity[] items) {
        this.uid = uid;
        this.title = title;
        this.text = text;
        this.descUrl = descUrl;
        this.pictureUrl = pictureUrl;
        this.items = items;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(uid);
        buf.writeString(title);
        buf.writeString(text);
        buf.writeString(descUrl);
        buf.writeString(pictureUrl);
        buf.writeUShort(items.length);
        for (ObjectItemInformationWithQuantity entry : items) {
            entry.serialize(buf);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        uid = buf.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        title = buf.readString();
        text = buf.readString();
        descUrl = buf.readString();
        pictureUrl = buf.readString();
        int limit = buf.readUShort();
        items = new ObjectItemInformationWithQuantity[limit];
        for (int i = 0; i < limit; i++) {
            items[i] = new ObjectItemInformationWithQuantity();
            items[i].deserialize(buf);
        }
    }
    
}
