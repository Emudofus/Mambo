

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.core.io.*;

public class IgnoredInformations extends AbstractContactInformations {
    public static final short TYPE_ID = 106;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    
    public IgnoredInformations() { }
    
    public IgnoredInformations(int accountId, String accountName) {
        super(accountId, accountName);
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
    }
    
}
