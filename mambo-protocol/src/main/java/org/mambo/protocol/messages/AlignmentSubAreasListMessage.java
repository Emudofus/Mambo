

// Generated on 05/08/2013 19:37:58
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AlignmentSubAreasListMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6059;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public short[] angelsSubAreas;
    public short[] evilsSubAreas;
    
    public AlignmentSubAreasListMessage() { }
    
    public AlignmentSubAreasListMessage(short[] angelsSubAreas, short[] evilsSubAreas) {
        this.angelsSubAreas = angelsSubAreas;
        this.evilsSubAreas = evilsSubAreas;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeUShort(angelsSubAreas.length);
        for (short entry : angelsSubAreas) {
            buf.writeShort(entry);
        }
        buf.writeUShort(evilsSubAreas.length);
        for (short entry : evilsSubAreas) {
            buf.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(Buffer buf) {
        int limit = buf.readUShort();
        angelsSubAreas = new short[limit];
        for (int i = 0; i < limit; i++) {
            angelsSubAreas[i] = buf.readShort();
        }
        limit = buf.readUShort();
        evilsSubAreas = new short[limit];
        for (int i = 0; i < limit; i++) {
            evilsSubAreas[i] = buf.readShort();
        }
    }
    
}
