

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeUShort(titles.length);
        for (short entry : titles) {
            buf.writeShort(entry);
        }
        buf.writeUShort(ornaments.length);
        for (short entry : ornaments) {
            buf.writeShort(entry);
        }
        buf.writeShort(activeTitle);
        buf.writeShort(activeOrnament);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        titles = new short[limit];
        for (int i = 0; i < limit; i++) {
            titles[i] = buf.readShort();
        }
        limit = buf.readUShort();
        ornaments = new short[limit];
        for (int i = 0; i < limit; i++) {
            ornaments[i] = buf.readShort();
        }
        activeTitle = buf.readShort();
        if (activeTitle < 0)
            throw new RuntimeException("Forbidden value on activeTitle = " + activeTitle + ", it doesn't respect the following condition : activeTitle < 0");
        activeOrnament = buf.readShort();
        if (activeOrnament < 0)
            throw new RuntimeException("Forbidden value on activeOrnament = " + activeOrnament + ", it doesn't respect the following condition : activeOrnament < 0");
    }
    
}
