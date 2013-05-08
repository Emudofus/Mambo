

// Generated on 05/08/2013 19:37:53
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

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
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeInt(spawnMapId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        spawnMapId = buf.readInt();
        if (spawnMapId < 0)
            throw new RuntimeException("Forbidden value on spawnMapId = " + spawnMapId + ", it doesn't respect the following condition : spawnMapId < 0");
    }
    
}
