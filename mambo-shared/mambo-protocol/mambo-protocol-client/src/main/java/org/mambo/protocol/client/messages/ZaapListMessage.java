

// Generated on 11/11/2012 19:17:08
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class ZaapListMessage extends TeleportDestinationsListMessage {
    public static final int MESSAGE_ID = 1604;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public int spawnMapId;
    
    public ZaapListMessage() { }
    
    public ZaapListMessage(byte teleporterType, int[] mapIds, short[] subAreaIds, short[] costs, int spawnMapId) {
        super(teleporterType, mapIds, subAreaIds, costs);
        this.spawnMapId = spawnMapId;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeInt(spawnMapId);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        spawnMapId = reader.readInt();
        if (spawnMapId < 0)
            throw new RuntimeException("Forbidden value on spawnMapId = " + spawnMapId + ", it doesn't respect the following condition : spawnMapId < 0");
    }
    
}
