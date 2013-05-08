

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
import org.mambo.core.io.*;

public class AbstractContactInformations extends NetworkType {
    public static final short TYPE_ID = 380;
    
    @Override
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
    public void serialize(Buffer buf) {
        buf.writeInt(accountId);
        buf.writeString(accountName);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        accountId = buf.readInt();
        if (accountId < 0)
            throw new RuntimeException("Forbidden value on accountId = " + accountId + ", it doesn't respect the following condition : accountId < 0");
        accountName = buf.readString();
    }
    
}
