/*
 * CIndividual.h
 *
 *  Created on: 23 juin 2009
 *      Author: maitre
 */

#ifndef CINDIVIDUAL_H_
#define CINDIVIDUAL_H_

class CRandomGenerator;
#include <iostream>

class CIndividual {
public:
	bool valid;
    bool isImmigrant;
    int generationOfCreation;
	float fitness;
	/***********/
	int ident;
	char origine;
	int parent1;
	int parent2;
	int survival;
	float gainFitness;
	/***********/
	static CRandomGenerator* rg;
public:
	CIndividual();
	//CIndividual(const CIndividual& indiv);
	virtual ~CIndividual();
	virtual float evaluate() = 0;
	virtual void printOn(std::ostream& O) const = 0;
	virtual unsigned mutate(float pMutationPerGene) = 0;
	virtual CIndividual* crossover(CIndividual** p2) = 0;
	virtual CIndividual* clone() = 0;

    virtual std::string serialize() = 0;
    virtual void deserialize(std::string EASEA_Line) = 0;

	virtual void boundChecking() = 0;

	static unsigned getCrossoverArrity(){ return 2; }
	float getFitness(){ return this->fitness; }
    
    int getGenerationOfCreation(){ return this->generationOfCreation; }
    int getAge(int currentGeneration){ return currentGeneration-this->generationOfCreation+1; } //+1 or else newly created will have an age of 0


};

#endif /* CINDIVIDUAL_H_ */
