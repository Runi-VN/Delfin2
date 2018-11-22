package Delfinen.logic;

import Delfinen.data.DisciplineType;
import Delfinen.data.Distance;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Camilla
 */
public class Training {

    private ArrayList<TrainingSession> trainingList;

    /**
     * The Training object creates an ArrayList the holds the TrainingSessions
     * of a specific MemberCompetitive object.
     */
    public Training() {
        trainingList = new ArrayList();
    }

    /**
     * Adds the parameter to the ArrayList of TrainingSessions trainingList
     * @param result
     */
    public void addTrainingSession(TrainingSession training) {
        trainingList.add(training);
    }

    /**
     * Returns the ArrayList of the TrainingSessions trainingList
     * @return ArrayList trainingList
     */
    public ArrayList<TrainingSession> getTrainingList() {
        return trainingList;
    }

    /**
     * This method iterates through the ArrayList trainingList an adds the 
     * TrainingSessions containing the given parameters to a temporary ArrayList.
     * This temporary ArrayList is then sorted based on the int timeInSec (see overridden
     * compareTo method in TrainingSession). The TrainingSession with the lowest 
     * timeInSec are now in index 0, which is then returned
     * @param disciplineType
     * @param distance
     * @return TrainingSession
     */
    public TrainingSession getBestTraining(DisciplineType disciplineType, Distance distance) {
        ArrayList<TrainingSession> templist = new ArrayList();
        try
        {
            for (int i = 0; i < trainingList.size(); i++) {
                if (disciplineType == (trainingList.get(i).getDiciplineType())) {
                    if (distance == (trainingList.get(i).getDistance())) {
                        templist.add(trainingList.get(i));
                    }
                }
            }
        }
        catch (NullPointerException nx)
        {
            System.out.println("getBestTraining failed");
            return null;
        }
        Collections.sort(templist);
        if (templist.size() > 0) {
            return templist.get(0);
        }
        return null;
    }

}

