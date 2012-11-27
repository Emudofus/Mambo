

// Generated on 11/11/2012 20:41:30
package org.mambo.protocol.client.messages;

import org.mambo.protocol.client.types.*;
import org.mambo.core.io.*;

public class PartyMemberInFightMessage extends AbstractPartyMessage {
    public static final int MESSAGE_ID = 6342;
    
    @Override
    public int getNetworkMessageId() {
        return MESSAGE_ID;
    }
    
    public byte reason;
    public int memberId;
    public int memberAccountId;
    public String memberName;
    public int fightId;
    public MapCoordinatesExtended fightMap;
    public int secondsBeforeFightStart;
    
    public PartyMemberInFightMessage() { }
    
    public PartyMemberInFightMessage(int partyId, byte reason, int memberId, int memberAccountId, String memberName, int fightId, MapCoordinatesExtended fightMap, int secondsBeforeFightStart) {
        super(partyId);
        this.reason = reason;
        this.memberId = memberId;
        this.memberAccountId = memberAccountId;
        this.memberName = memberName;
        this.fightId = fightId;
        this.fightMap = fightMap;
        this.secondsBeforeFightStart = secondsBeforeFightStart;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        super.serialize(writer);
        writer.writeByte(reason);
        writer.writeInt(memberId);
        writer.writeInt(memberAccountId);
        writer.writeString(memberName);
        writer.writeInt(fightId);
        fightMap.serialize(writer);
        writer.writeInt(secondsBeforeFightStart);
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        super.deserialize(reader);
        reason = reader.readByte();
        if (reason < 0)
            throw new RuntimeException("Forbidden value on reason = " + reason + ", it doesn't respect the following condition : reason < 0");
        memberId = reader.readInt();
        memberAccountId = reader.readInt();
        if (memberAccountId < 0)
            throw new RuntimeException("Forbidden value on memberAccountId = " + memberAccountId + ", it doesn't respect the following condition : memberAccountId < 0");
        memberName = reader.readString();
        fightId = reader.readInt();
        fightMap = new MapCoordinatesExtended();
        fightMap.deserialize(reader);
        secondsBeforeFightStart = reader.readInt();
    }
    
}
