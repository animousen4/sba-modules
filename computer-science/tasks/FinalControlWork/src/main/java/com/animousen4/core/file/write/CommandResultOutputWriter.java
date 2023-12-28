package com.animousen4.core.file.write;


import com.animousen4.core.entites.*;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class CommandResultOutputWriter extends OutputWriterFile<MappedGroup>{
    public CommandResultOutputWriter(OutputStreamWriter streamWriter) {
        super(streamWriter);
    }



    @Override
    public String convertEntityToString(MappedGroup mappedGroup) {

        String res = "";

        ArrayList<OutResEntity> outResEntities = new ArrayList<>();

        mappedGroup.getCalculatedCommands().forEach((key, value) -> outResEntities.add(new OutResEntity(
                key, value.getPoints(), value.getDraws() + value.getWins() + value.getLoses()
        )));

        outResEntities.sort((o1, o2) -> {
            if (o1.getPoints() == o2.getPoints()) {
                return o2.getGames() - o1.getGames();
            }
            return o2.getPoints() - o1.getPoints();
        });

        for (OutResEntity ent : outResEntities) {
            res = res.concat(ent.getName().concat("\t").concat(String.valueOf(ent.getPoints())).concat("\t").concat(String.valueOf(ent.getGames())).concat("\n"));
        }
        return res;
    }

}
