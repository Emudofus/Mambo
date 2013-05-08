

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class MountInformationsForPaddock extends NetworkType {
    public static final short TYPE_ID = 184;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int modelId;
    public String name;
    public String ownerName;
    
    public MountInformationsForPaddock() { }
    
    public MountInformationsForPaddock(int modelId, String name, String ownerName) {
        this.modelId = modelId;
        this.name = name;
        this.ownerName = ownerName;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(modelId);
        buf.writeString(name);
        buf.writeString(ownerName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        modelId = buf.readInt();
        name = buf.readString();
        ownerName = buf.readString();
    }
    
}
