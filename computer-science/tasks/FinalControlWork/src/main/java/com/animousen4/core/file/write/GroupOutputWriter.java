package com.animousen4.core.file.write;


import com.animousen4.core.entites.CommandGroupResult;
import com.animousen4.core.entites.MappedGroup;

import java.io.IOException;

public class GroupOutputWriter extends OutputWriterFile<MappedGroup>{

    public GroupOutputWriter(String fileName) {
        super(fileName);
    }

    @Override
    public String convertEntityToString(MappedGroup mappedGroup) {
        var ref = new Object() {
            String res = "";
        };
        mappedGroup.getGroups().forEach(
                gr -> {
                    ref.res += gr.getGroupName() + "\n";

                    gr.getCommands().forEach(
                            command -> {
                                var promoRes = mappedGroup.getCalculatedCommands().get(command);
                                if (promoRes != null) {
                                    ref.res += new CommandGroupResult(command, promoRes) + "\n";
                                }
                            }
                    );

                }
        );

        return ref.res;
    }

}
