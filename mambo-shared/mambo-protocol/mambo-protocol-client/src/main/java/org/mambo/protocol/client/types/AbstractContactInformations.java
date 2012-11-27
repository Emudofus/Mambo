

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.DeserializerInterface;
import org.mambo.protocol.client.SerializerInterface;
import org.mambo.core.io.DataReaderInterface;
import org.mambo.core.io.DataWriterInterface;

public class AbstractContactInformations implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 380;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int accountId;
    public String accountName;
    
    public AbstractContactInformations() { }
    
    public AbstractContactInformations(int accountId, String accountName) {
        this.accountId = accountId;
        this.accountName = accountName;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(accountId);
        writer.writeString(accountName);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        accountId = reader.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        accountName = reader.readString();
    }
    
}
