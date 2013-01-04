

// Generated on 01/04/2013 14:54:41
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TitlesAndOrnamentsListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6367;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] titles;
    public short[] ornaments;
    public short activeTitle;
    public short activeOrnament;
    
    public TitlesAndOrnamentsListMessage() { }
    
    public TitlesAndOrnamentsListMessage(short[] titles, short[] ornaments, short activeTitle, short activeOrnament) {
        this.titles = titles;
        this.ornaments = ornaments;
        this.activeTitle = activeTitle;
        this.activeOrnament = activeOrnament;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(titles.length);
        for (short entry : titles) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(ornaments.length);
        for (short entry : ornaments) {
            writer.writeShort(entry);
        }
        writer.writeShort(activeTitle);
        writer.writeShort(activeOrnament);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        titles = new short[limit];
        for (int i = 0; i < limit; i++) {
            titles[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        ornaments = new short[limit];
        for (int i = 0; i < limit; i++) {
            ornaments[i] = reader.readShort();
        }
        activeTitle = reader.readShort();
        if (activeTitle < 0)
            throw new RuntimeException("Forbidden value on activeTitle = " + activeTitle + ", it doesn't respect the following condition : activeTitle < 0");
        activeOrnament = reader.readShort();
        if (activeOrnament < 0)
            throw new RuntimeException("Forbidden value on activeOrnament = " + activeOrnament + ", it doesn't respect the following condition : activeOrnament < 0");
    }
    
}
