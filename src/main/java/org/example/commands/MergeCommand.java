package org.example.commands;

import org.example.services.IMergeTrainService;

public class MergeCommand implements IMergeCommand {
    private IMergeTrainService mergeTrainService;
    public MergeCommand(IMergeTrainService mergeTrainService) {
        this.mergeTrainService = mergeTrainService;
    }
    @Override
    public void execute() {
        mergeTrainService.getAllBogiesAfterHyb();
        mergeTrainService.printMergedTrain();
    }
}
