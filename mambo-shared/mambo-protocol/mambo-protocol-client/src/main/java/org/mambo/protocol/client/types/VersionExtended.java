

// Generated on 11/11/2012 20:41:41
package org.mambo.protocol.client.types;

import java.util.*;
import org.mambo.protocol.client.enums.*;
import org.mambo.protocol.client.*;
import org.mambo.protocol.client.io.*;

public class VersionExtended extends Version {
    public static final short TYPE_ID = 393;
    
    @Override
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public byte install;
    public byte technology;
    
    public VersionExtended() { }
    
    public VersionExtended(byte major, byte minor, byte release, int revision, byte patch, byte buildType, byte install, byte technology) {
        super(major, minor, release, revision, patch, buildType);
        this.install = install;
        this.technology = technology;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(install);
        writer.writeByte(technology);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        install = reader.readByte();
        if (install < 0)
            throw new RuntimeException("Forbidden value on install = " + install + ", it doesn't respect the following condition : install < 0");
        technology = reader.readByte();
        if (technology < 0)
            throw new RuntimeException("Forbidden value on technology = " + technology + ", it doesn't respect the following condition : technology < 0");
    }
    
}
