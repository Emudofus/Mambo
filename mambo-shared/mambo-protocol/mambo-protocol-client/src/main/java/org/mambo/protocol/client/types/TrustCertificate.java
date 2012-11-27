

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
