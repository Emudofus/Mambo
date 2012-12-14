

// Generated on 12/14/2012 18:44:06
package org.mambo.protocol.client.messages;

import java.util.*;
import org.mambo.protocol.client.types.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class MountFeedRequestMessage extends NetworkMessage {
    public static final int MESSAGE_ID = 6189;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public double mountUid;
    public byte mountLocation;
    public int mountFoodUid;
    public int quantity;
    
    public MountFeedRequestMessage() { }
    
    public MountFeedRequestMessage(double mountUid, byte mountLocation, int mountFoodUid, int quantity) {
        this.mountUid = mountUid;
        this.mountLocation = mountLocation;
        this.mountFoodUid = mountFoodUid;
        this.quantity = quantity;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeDouble(mountUid);
        writer.writeByte(mountLocation);
        writer.writeInt(mountFoodUid);
        writer.writeInt(quantity);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        mountUid = reader.readDouble();
        if (mountUid < 0)
            throw new RuntimeException("Forbidden value on mountUid = " + mountUid + ", it doesn't respect the following condition : mountUid < 0");
        mountLocation = reader.readByte();
        mountFoodUid = reader.readInt();
        if (mountFoodUid < 0)
            throw new RuntimeException("Forbidden value on mountFoodUid = " + mountFoodUid + ", it doesn't respect the following condition : mountFoodUid < 0");
        quantity = reader.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
