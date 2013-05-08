

// Generated on 05/08/2013 19:38:03
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class TrustCertificate extends NetworkType {
    public static final short TYPE_ID = 377;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int id;
    public String hash;
    
    public TrustCertificate() { }
    
    public TrustCertificate(int id, String hash) {
        this.id = id;
        this.hash = hash;
    }
    
    @Override
    public void serialize(Buffer buf) {
        buf.writeInt(id);
        buf.writeString(hash);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        id = buf.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        hash = buf.readString();
    }
    
}
