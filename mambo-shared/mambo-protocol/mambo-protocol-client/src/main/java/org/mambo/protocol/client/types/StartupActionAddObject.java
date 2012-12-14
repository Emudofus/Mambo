

// Generated on 12/14/2012 18:44:23
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class StartupActionAddObject implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 52;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(uid);
        writer.writeString(title);
        writer.writeString(text);
        writer.writeString(descUrl);
        writer.writeString(pictureUrl);
        writer.writeUnsignedShort(items.length);
        for (ObjectItemInformationWithQuantity entry : items) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        uid = reader.readInt();
        if (uid < 0)
            throw new RuntimeException("Forbidden value on uid = " + uid + ", it doesn't respect the following condition : uid < 0");
        title = reader.readString();
        text = reader.readString();
        descUrl = reader.readString();
        pictureUrl = reader.readString();
        int limit = reader.readUnsignedShort();
        items = new ObjectItemInformationWithQuantity[limit];
        for (int i = 0; i < limit; i++) {
            items[i] = new ObjectItemInformationWithQuantity();
            items[i].deserialize(reader);
        }
    }
    
}
