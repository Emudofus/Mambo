

// Generated on 05/08/2013 19:38:00
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class PlayerStatusExtended extends PlayerStatus {
    public static final short TYPE_ID = 414;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public String message;
    
    public PlayerStatusExtended() { }
    
    public PlayerStatusExtended(byte statusId, String message) {
        super(statusId);
        this.message = message;
    }
    
    @Override
    public void serialize(Buffer buf) {
        super.serialize(buf);
        buf.writeString(message);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
        message = buf.readString();
    }
    
}
