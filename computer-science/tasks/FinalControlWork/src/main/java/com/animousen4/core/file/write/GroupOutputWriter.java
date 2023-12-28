package com.animousen4.core.file.write;


import com.animousen4.core.entites.CommandGroupResult;
import com.animousen4.core.entites.MappedGroup;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class GroupOutputWriter extends OutputWriterFile<MappedGroup>{

    public GroupOutputWriter(OutputStreamWriter streamWriter) {
        super(streamWriter);
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
