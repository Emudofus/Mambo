

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PlayerStatus extends NetworkType {
    public static final short TYPE_ID = 415;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte statusId;
    
    public PlayerStatus() { }
    
    public PlayerStatus(byte statusId) {
        this.statusId = statusId;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeByte(statusId);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        statusId = buf.readByte();
        if (statusId < 0)
            throw new RuntimeException("Forbidden value on statusId = " + statusId + ", it doesn't respect the following condition : statusId < 0");
    }
    
}
