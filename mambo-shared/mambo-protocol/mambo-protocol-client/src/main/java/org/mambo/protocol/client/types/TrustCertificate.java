

// Generated on 11/11/2012 19:06:15
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class TrustCertificate implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 377;
    
    
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
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(id);
        writer.writeString(hash);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        id = reader.readInt();
        if (id < 0)
            throw new RuntimeException("Forbidden value on id = " + id + ", it doesn't respect the following condition : id < 0");
        hash = reader.readString();
    }
    
}
