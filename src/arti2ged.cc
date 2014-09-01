#include <iostream>
#include <fstream>
#include <string>
#include <list>

#define NAME_SIZE_MAX 256
#define NB_CHAR_MAX_PER_LINE 256
#define ANCETRE 0
#define MUTE 1
#define CROSS 2
#define BOTH 3
#define CLONE 4


typedef struct indi 
{
  int id;
  float fitness;
  int birthgen;
  int deatgen;
  int source; /* issued from Mute or Cross or Both or Nada */
  float gainFitness;
  int survival;
  std::list<int> lfams;
  std::list<int> lfamc;
} Individu;

typedef struct fam
{
  int ged_id_cross;
  int id_parent1;
  int id_parent2;
  int date;
  std::list<int> id_son;
} Cross;

typedef struct mute
{
  int ged_id_mute;
  int id_parent;
  int id_mute;
  int date;
} Mutation;



void debug_display_list_indi(std::list<Individu> l)
{
  std::cout << "debug_display_list_indi" << std::endl;
  for(std::list<Individu>::iterator cur = l.begin(); cur != l.end(); cur++)
  std::cout << "id : " << (*cur).id << std::endl;
}

int main(int argc, char** argv)
{ 
  try
    {

      if(argc != 3)
	throw std::string("invalid use");

      std::string src_file_name = argv[1];
      std::string dest_file_name = argv[2];

      /* Limit size to avoid bad input from the user :-) */
      if(src_file_name.size() > NAME_SIZE_MAX || dest_file_name.size() > NAME_SIZE_MAX )
	throw std::string("name file too big");

      std::list<Individu> lIndividu;
      std::list<Cross> lCross;
      std::list<Mutation> lMutation;
      int acc_family = 1; /* to identify each family in the GEDCOM file */


      /* ------------------------------------------------- */
      /* ------ PARSING INPUT FILE ----------------------- */
      /* ------------------------------------------------- */

      /* Parsing algorithm :                               */
      /* 1) parse the first few line individu              */
      /*   warn to a single line, which was use            */
      /*   to find the end of the first generation         */
      /* 2) parse the end of the file                      */

      /* first reading to parse individu */
      std::ifstream src_file(src_file_name.c_str(), std::ios::in);
      if(!src_file)
	throw std::string("can't open file \"" + src_file_name + "\"");


      /* step 1) */
      /* insert the first generation in lIndividu */
      std::string type;
      bool firstGen = true;
      int id;
      while(firstGen)
	{
	  src_file >> type;

	  if(type == "Individu")
	    {
	      /* Parsing Individu line */ 
	      std::string semicolon, tmp1, tmp2, tmp3;
	      std::string sNoGen, sId, sFitness, sGainFitness;
	      int noGen;
	      float fitness,gainFitness;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId >> id >> tmp2 >> sFitness >> fitness >> tmp3 >> sGainFitness >> gainFitness;

	      Individu mIndividu;
	      mIndividu.id = id;
	      mIndividu.fitness = fitness;
	      mIndividu.birthgen = noGen;
	      mIndividu.deatgen = noGen;
	      mIndividu.source = ANCETRE;
	      mIndividu.gainFitness = gainFitness;
	      mIndividu.survival = 0;

	      lIndividu.push_back(mIndividu);
	      
	    }
	  else
	    { 
	      firstGen = false;
	    }
	}
      
      /* End of step 1) */

      /*debug_display_list_indi(lIndividu);*/

      /* step 2) */
      /* parse the end of the file */
      while(!src_file.eof())
	{

	  if(!firstGen) /*in this case the begining of the line was read before */
	    {
	      firstGen = true;
	    }
	  else
	    {
	      src_file >> type;
	    }

	  if(type == "Member")
	    {
	      std::string semicolon, sId;
	      int id;
	      src_file >> semicolon >> sId >> id;
	      bool isFind = false;
	      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
		if( (*cur).id == id) 
		  {
		    (*cur).survival ++;
		    isFind = true;
		  }

	      if(!isFind)
		throw std::string("can't find individu");
	    }

	  if(type == "Individu")
	    {
	      /* Parsing Individu line */ 
	      std::string semicolon, tmp1, tmp2, tmp3;
	      std::string sNoGen, sId, sFitness, sGainFitness;
	      int noGen;
	      float fitness, gainFitness;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId >> id >> tmp2 >> sFitness >> fitness >> tmp3 >> sGainFitness >> gainFitness;

	      /* search the individu and update the fitness value, survival value and gainFtness value */
	      bool isFind = false;
	      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
		if( (*cur).id == id) 
		  {
		    (*cur).fitness = fitness;
		    (*cur).gainFitness = gainFitness;
		    (*cur).survival = 0;
		    isFind = true;
		  }

	      if(!isFind)
		throw std::string("can't find individu");
	    }
	  else if(type == "Cross" || type == "Both")
	    {
	      /* Parsing Cross line */
	      std::string semicolon, tmp1, tmp2, tmp3;
	      std::string sNoGen, sId_parent1, sId_parent2, sId_son;
	      int noGen, id_parent1, id_parent2, id_son;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 ;
	      src_file >> sId_parent1 >> id_parent1 >> tmp2 >> sId_parent2 >> id_parent2 >> tmp3 >> sId_son >> id_son;

	      /* search if there is a family with same parents and same generation */
	      bool isFind = false;
	      int id_cross;
	      for(std::list<Cross>::iterator cur = lCross.begin(); cur != lCross.end(); cur++)
		//if( (*cur).date == noGen && isFind == false &&
		//  ( ( (*cur).id_parent1 == id_parent1 && (*cur).id_parent2 == id_parent2)
		//||( (*cur).id_parent1 == id_parent2 && (*cur).id_parent2 == id_parent1 ) ) )
		if( (*cur).date == noGen && isFind == false && (*cur).id_parent1==id_parent1 && (*cur).id_parent2==id_parent2 )
		  {
		    (*cur).id_son.push_back(id_son);
		    isFind = true;
		    id_cross = (*cur).ged_id_cross;
		  }

	      /* else isFind == false : create a new family */
	      if(isFind == false)
		{
		  Cross mCross;
		  mCross.ged_id_cross = acc_family;
		  id_cross = acc_family;
		  mCross.date = noGen;

		  /* update parents */
		  mCross.id_parent1 = id_parent1;
		  mCross.id_parent2 = id_parent2;
		  mCross.id_son.push_back(id_son);
		  lCross.push_back(mCross);
		  acc_family++;
		}

	      /* find parent 1 and update family connexion */
	      isFind = false;
	      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
		if( (*cur).id == id_parent1) 
		  {
		    (*cur).deatgen = noGen;
		    (*cur).lfams.push_back(id_cross);
		    isFind = true;
		  }
	      if(!isFind)
		throw std::string("in cross-over, invalid parent");
	
	      /* find parent2 and update family connexion */
	      isFind = false;
	      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
		if( (*cur).id == id_parent2) 
		  {
		    (*cur).deatgen = noGen;
		    (*cur).lfams.push_back(id_cross);
		    isFind = true;
		  }
	      if(!isFind)
		throw std::string("in cross-over, invalid parent");

	      /* create son and insert family connexion */
	      /* TODO : fix the bug if parents and child are the same */
	      Individu son;
	      son.id = id_son;
	      son.fitness = 0;
	      son.birthgen = noGen;
	      son.deatgen = noGen;
	      if (type == "Cross" )  son.source = CROSS;
	      if (type == "Both") son.source = BOTH;
	      son.lfamc.push_back(id_cross);
	      lIndividu.push_back(son);

	    }
	  else if(type == "Mutation" || type == "Clone")
	    {
	      /* Parsing Mutation line */
	      std::string semicolon, tmp1, tmp2;
	      std::string sNoGen, sId_parent, sId_mute;
	      int noGen, id_parent, id_mute;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId_parent >> id_parent >> tmp2 >> sId_mute >> id_mute;

	      /* create a new mutation */
	      Mutation mMutation;
	      mMutation.ged_id_mute = acc_family;
	      mMutation.date = noGen;
	      mMutation.id_parent = id_parent;
	      mMutation.id_mute = id_mute;

	      lMutation.push_back(mMutation);
	      acc_family++;

	      /* create individu and insert family */
	      Individu indMute;
	      indMute.id = id_mute;
	      indMute.fitness = 0;
	      indMute.birthgen = noGen;
	      indMute.deatgen = noGen;
	      if(type=="Mutation") indMute.source = MUTE;
	      if(type=="Clone") indMute.source = CLONE;
	      indMute.lfamc.push_back(mMutation.ged_id_mute);

	      lIndividu.push_back(indMute);

	      /* search parent and update family connexion */
	      bool isFind = false;
	      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
		if( (*cur).id == id_parent) 
		  {
		    (*cur).deatgen = noGen;
		    (*cur).lfams.push_back(mMutation.ged_id_mute);
		    isFind = true;
		  }
	      if(!isFind)
		throw std::string("in mutation, invalid parent");
	    }
	  else
	    {
	      /* if the line is unregonized, we forget it and parse the next */
	      src_file.ignore(NB_CHAR_MAX_PER_LINE,'\n');
	    }

	}
      src_file.close();
      /* end of step 2) */

      /*debug_display_list_indi(lIndividu);*/


      /* ------------------------------------------------- */
      /* ------ WRITING OUTPUT FILE ---------------------- */
      /* ------------------------------------------------- */
      std::ofstream dest_file(dest_file_name.c_str(), std::ios::out | std::ios::trunc);
      if(!dest_file)
	throw std::string("can't open file \"" + dest_file_name + "\"");
       
      
      /* Write the header of the GEDCOM file */
      dest_file << "0 HEAD" << std::endl;
      dest_file << "1 SOUR ArtiFract" << std::endl;
      dest_file << "1 FILE " << dest_file_name << std::endl;
      dest_file << "1 CHAR ANSI" << std::endl;
      int indit=0;
     
      printf("%d",id);
      int lien[id+1];
      /* write the individu */
      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
	{
	  dest_file << "0 @I" << indit << "@ INDI" << std::endl;
	  lien[(*cur).id]=indit;
	  indit++;
      
	  dest_file << "1 NAME Individu" <<(*cur).id<<std::endl;
	  
	  //dest_file << "id" << (*cur).id << "_gen" << (*cur).birthgen<< std::endl;

	  dest_file << "1 FITNESS " << (*cur).fitness <<std::endl;
	  dest_file << "1 GAINFITNESS " << (*cur).gainFitness <<std::endl;

	  dest_file << "1 GENERATION " << (*cur).birthgen <<std::endl;

	  dest_file << "1 BIRT" << std::endl;
	  dest_file << "2 DATE " << (*cur).birthgen << std::endl;
	  dest_file << "1 DEAT" << std::endl;
	  dest_file << "2 DATE " << (*cur).deatgen<< std::endl;
	  dest_file << "1 SURVIVAL " << (*cur).survival<< std::endl;

	  if((*cur).source == CROSS||(*cur).source == BOTH)
	    dest_file << "1 SEX F" << std::endl;
	  else if((*cur).source == MUTE||(*cur).source == CLONE)
	    dest_file << "1 SEX M" << std::endl;
	  if((*cur).source == BOTH)
	    dest_file << "1 ORIGINE Both" << std::endl;
	  else if((*cur).source == CLONE)
	    dest_file << "1 ORIGINE Clone" << std::endl;
	  else if((*cur).source == MUTE)
	    dest_file << "1 ORIGINE Mutation" << std::endl;
	  else if((*cur).source == CROSS)
	    dest_file << "1 ORIGINE Crossover" << std::endl;	  

	  for(std::list<int>::iterator it = (*cur).lfams.begin(); it != (*cur).lfams.end(); it++)
	    dest_file << "1 FAMS @F" << (*it) << "@" << std::endl;

	  for(std::list<int>::iterator it = (*cur).lfamc.begin(); it != (*cur).lfamc.end(); it++)
	    dest_file << "1 FAMC @F" << (*it) << "@" << std::endl;
	}

      /* write the family */
      for(std::list<Cross>::iterator cur = lCross.begin(); cur != lCross.end(); cur++)
	{
	  dest_file << "0 @F" << (*cur).ged_id_cross << "@ FAM" << std::endl;
	  dest_file << "1 HUSB @I" << lien[(*cur).id_parent1] << "@" << std::endl;
	  dest_file << "1 HUSB @I" << lien[(*cur).id_parent2] << "@" << std::endl;
	  dest_file << "1 MARR" << std::endl;
	  dest_file << "2 DATE " << (*cur).date <<std::endl;
	  for(std::list<int>::iterator i = (*cur).id_son.begin(); i != (*cur).id_son.end(); i++)
	    dest_file << "1 CHIL @I" << lien[(*i)] << "@" << std::endl;
	}
      for(std::list<Mutation>::iterator cur = lMutation.begin(); cur != lMutation.end(); cur++)
	{
	  dest_file << "0 @F" << (*cur).ged_id_mute << "@ FAM" << std::endl;
	  dest_file << "1 WIFE @I" << lien[(*cur).id_parent] << "@" << std::endl;
	  dest_file << "1 WIFE @I" << lien[(*cur).id_parent] << "@" << std::endl;
	  dest_file << "1 MARR" << std::endl;
	  dest_file << "2 DATE " << (*cur).date<< std::endl;
	  dest_file << "1 CHIL @I" << lien[(*cur).id_mute] << "@" << std::endl;
	}

      dest_file << "0 TRLR" << std::endl;
      dest_file.close();
    }
  catch(const std::string& error)
    {
      std::cout << "Error : " << error << std::endl;
      std::cout << "Use: artie2ged <src file> <dest file>" << std::endl;
      return 1;
    }
  return 0;
}

