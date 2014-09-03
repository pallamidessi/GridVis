#ifndef CSTATS_H_
#define CSTATS_H_

class CStats{

public:
    int totalNumberOfImmigrants;
    int currentNumberOfImmigrants;

    int totalNumberOfImmigrantReproductions;
    int currentNumberOfImmigrantReproductions;

    double currentAverageFitness;
    double currentStdDev;
        
    double currentAveragePopulationAge;

public:
    CStats();
    ~CStats();
    void resetCurrentStats();
    void resetNumberOfImmigrantReproductions();
};

#endif /* CSTATS_H_ */
