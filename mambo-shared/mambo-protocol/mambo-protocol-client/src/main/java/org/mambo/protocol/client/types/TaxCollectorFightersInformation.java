

// Generated on 11/11/2012 20:41:40
package org.mambo.protocol.client.types;

import org.mambo.protocol.client.*;
import org.mambo.core.io.*;

public class TaxCollectorFightersInformation implements SerializerInterface, DeserializerInterface {
    public static final short TYPE_ID = 169;
    
    
    public short getTypeId() {
        return TYPE_ID;
    }
    
    public int collectorId;
    public CharacterMinimalPlusLookInformations[] allyCharactersInformations;
    public CharacterMinimalPlusLookInformations[] enemyCharactersInformations;
    
    public TaxCollectorFightersInformation() { }
    
    public TaxCollectorFightersInformation(int collectorId, CharacterMinimalPlusLookInformations[] allyCharactersInformations, CharacterMinimalPlusLookInformations[] enemyCharactersInformations) {
        this.collectorId = collectorId;
        this.allyCharactersInformations = allyCharactersInformations;
        this.enemyCharactersInformations = enemyCharactersInformations;
    }
    
    @Override
    public void serialize(DataWriterInterface writer) {
        writer.writeInt(collectorId);
        writer.writeUnsignedShort(allyCharactersInformations.length);
        for (CharacterMinimalPlusLookInformations entry : allyCharactersInformations) {
            entry.serialize(writer);
        }
        writer.writeUnsignedShort(enemyCharactersInformations.length);
        for (CharacterMinimalPlusLookInformations entry : enemyCharactersInformations) {
            entry.serialize(writer);
        }
    }
    
    @Override
    public void deserialize(DataReaderInterface reader) {
        collectorId = reader.readInt();
        int limit = reader.readUnsignedShort();
        allyCharactersInformations = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            allyCharactersInformations[i] = new CharacterMinimalPlusLookInformations();
            allyCharactersInformations[i].deserialize(reader);
        }
        limit = reader.readUnsignedShort();
        enemyCharactersInformations = new CharacterMinimalPlusLookInformations[limit];
        for (int i = 0; i < limit; i++) {
            enemyCharactersInformations[i] = new CharacterMinimalPlusLookInformations();
            enemyCharactersInformations[i].deserialize(reader);
        }
    }
    
}
