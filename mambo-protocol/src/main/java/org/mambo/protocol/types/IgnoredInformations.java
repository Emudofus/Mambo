

// Generated on 05/08/2013 19:38:02
package org.mambo.protocol.types;

import java.util.*;
import org.mambo.protocol.enums.*;
import org.mambo.protocol.*;
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
    public void serialize(Buffer buf) {
        super.serialize(buf);
    }
    
    @Override
    public void deserialize(Buffer buf) {
        super.deserialize(buf);
    }
    
}
