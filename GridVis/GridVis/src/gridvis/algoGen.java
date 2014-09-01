package gridvis;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class algoGen {
int nbWorker;
int taillePop;
int nbGen;
ArrayList<Integer []> pop;
int[][] dist;
float txMut;
float txCross;
Integer[] best;

algoGen(int[][] distances, int tPop,int nbW, int nG, float txM, float txC)
{
	nbWorker = nbW;
	taillePop=tPop;
	dist=distances;
	nbGen=nG;
	txMut=txM;
	txCross=txC;
	best=new Integer[nbWorker];
	for(int i=0;i<nbWorker;i++) best[i]=i;
	
	initPop();
	Random r = new Random();
	Random r2 = new Random();
	for(int k=0;k<nbGen;k++)
	{
		for(int l=0;l<taillePop;l++)
		{
			float prob = ((float)r.nextInt(1000))/((float)1000);
			if(prob < txMut) Mutation(pop.get(l));
			prob = ((float)r.nextInt(1000))/((float)1000);
			if(prob < txCross) 
			{
				int ind2 = r2.nextInt(taillePop);
				Cross(pop.get(l),pop.get(ind2));
			}
		}
		
		while(pop.size()>taillePop)
		{
			tournament();
		}
		
		getbest();
	}
	
}

void getbest()
{
  Integer[] tmp = new Integer [nbWorker];
  tmp=pop.get(0);
  for(int k=0;k<taillePop;k++)
  {
	  if(fitness(pop.get(k))<fitness(tmp)) tmp=pop.get(k);
  }
  if(fitness(tmp)<fitness(best)) best=tmp;
}


void initPop()
{
	pop=new ArrayList<Integer[]>();
	ArrayList<Integer> nombres=new ArrayList<Integer>();
	for(int l=0;l<taillePop;l++){
		Integer[] ind=new Integer [nbWorker];
		for(int k=0;k<nbWorker;k++) nombres.add(k);
		Random r = new Random();
		for(int i=0;i<nbWorker;i++)
			{
			int valeur =  r.nextInt(nombres.size());
			ind[i]=nombres.get(valeur);
			nombres.remove(valeur);
			}
	pop.add(ind);
	if(l==0){
	
	}
	}
}

void Mutation(Integer[] individu)
{  
	Integer[] ind_mute=new Integer [nbWorker];
	for(int i=0;i<nbWorker;i++)
	{
		ind_mute[i]=individu[i];
	}
	Random r = new Random();
	for(int i=0;i<nbWorker;i++)
	{
		int valeur = r.nextInt(10);
		if(valeur==0) swap(ind_mute,i,(i+1)%nbWorker);
	}
	pop.add(ind_mute);
}

void swap(Integer[] v,int i,int j)
{
	int tmp = v[i];
	v[i]=v[j];
	v[j]=tmp;
}

void Cross(Integer[] parent1,Integer[] parent2)
{
	Integer[] ind_fils=new Integer [nbWorker];
	Random r = new Random();
	int valeur = r.nextInt(nbWorker);
	for(int i=0;i<valeur;i++)
	{
		ind_fils[i]=parent1[i];
	}
	for(int i=valeur;i<nbWorker;i++)
	{
		ind_fils[i]=parent2[i];
	}
	
	Integer[] isPermut=new Integer [nbWorker];
	ArrayList<Integer> mauvaisIndices = new ArrayList<Integer>();
	for(int k=0;k<nbWorker;k++) isPermut[k]=0;
	for(int k=0;k<nbWorker;k++) {
		if(isPermut[ind_fils[k]] == 0) isPermut[ind_fils[k]] =1;
		else mauvaisIndices.add(k);
	}
	
	int k =0;
	while(mauvaisIndices.size()>0)
	{
		while(isPermut[k]==1) k++;
		ind_fils[mauvaisIndices.get(0)]=k;
		isPermut[k]=1;
		mauvaisIndices.remove(0);
	}
	
	pop.add(ind_fils);
}

int fitness(Integer[] individu)
{
	int fitness=0;
	for(int i=0;i<nbWorker-1;i++)
	{
		fitness+= dist[individu[i]][individu[i+1]];
	}
	return fitness;
}

void tournament()
{
	Random r = new Random();
	int fighter1 = r.nextInt(pop.size());
	int fighter2 = r.nextInt(pop.size());
	
	if(fitness(pop.get(fighter1))>fitness(pop.get(fighter2)))
		pop.remove(fighter1);
	else
		pop.remove(fighter2);
	
}

Integer[] get_best()
{
	return best;	
}

}