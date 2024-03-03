package org.example.services;

import org.example.entities.ITrain;

import java.util.List;

public interface IMergeTrainService {
    List<ITrain> getTrainList();
    void getAllBogiesAfterHyb();
    void printMergedTrain();
}
