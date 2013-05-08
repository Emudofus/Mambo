

// Generated on 05/08/2013 19:37:45
package org.mambo.protocol.messages;

import java.util.*;
import org.mambo.protocol.types.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        buf.writeDouble(mountUid);
        buf.writeByte(mountLocation);
        buf.writeInt(mountFoodUid);
        buf.writeInt(quantity);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        mountUid = buf.readDouble();
        if (mountUid < 0)
            throw new RuntimeException("Forbidden value on mountUid = " + mountUid + ", it doesn't respect the following condition : mountUid < 0");
        mountLocation = buf.readByte();
        mountFoodUid = buf.readInt();
        if (mountFoodUid < 0)
            throw new RuntimeException("Forbidden value on mountFoodUid = " + mountFoodUid + ", it doesn't respect the following condition : mountFoodUid < 0");
        quantity = buf.readInt();
        if (quantity < 0)
            throw new RuntimeException("Forbidden value on quantity = " + quantity + ", it doesn't respect the following condition : quantity < 0");
    }
    
}
