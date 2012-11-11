

// Generated on 11/11/2012 20:41:37
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

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
    public void serialize(DataWriterInterface writer) {
        writer.writeUnsignedShort(angelsSubAreas.length);
        for (short entry : angelsSubAreas) {
            writer.writeShort(entry);
        }
        writer.writeUnsignedShort(evilsSubAreas.length);
        for (short entry : evilsSubAreas) {
            writer.writeShort(entry);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        int limit = reader.readUnsignedShort();
        angelsSubAreas = new short[limit];
        for (int i = 0; i < limit; i++) {
            angelsSubAreas[i] = reader.readShort();
        }
        limit = reader.readUnsignedShort();
        evilsSubAreas = new short[limit];
        for (int i = 0; i < limit; i++) {
            evilsSubAreas[i] = reader.readShort();
        }
    }
    
}
