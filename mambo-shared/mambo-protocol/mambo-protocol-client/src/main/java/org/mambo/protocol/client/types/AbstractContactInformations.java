

// Generated on 01/04/2013 14:54:48
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

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
