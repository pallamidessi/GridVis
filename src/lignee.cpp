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
  int gen;
  float fitness;
  int parent1;
  int parent2;
  int origine;
  float gain_fitness;
  int survival;
} Individu;


int main(int argc, char** argv)
{ 
      try{
      if(argc != 3)
	throw std::string("invalid use");
      std::string src_file_name = argv[1];
      std::string dest_file_name = argv[2];
      
      
      std::list<Individu> lIndividu; 

     
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
      while(firstGen)
	{ 
	  src_file >> type;
	  if(type == "Individu")
	  {
	      /* Parsing Individu line */ 
	    std::string semicolon, tmp1, tmp2, tmp3;
	    std::string sNoGen, sId, sFitness, sGainFitness;
	    int noGen, id;
	    float fitness,gainFitness;
	    src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId >> id >> tmp2 >> sFitness >> fitness >> tmp3 >> sGainFitness >> gainFitness;

	      Individu mIndividu;
	      mIndividu.id = id;
	      mIndividu.gen=noGen;
	      mIndividu.fitness = fitness;
	      mIndividu.parent1 = 0;
	      mIndividu.parent2 = 0;
	      mIndividu.origine = 0;
	      mIndividu.gain_fitness = 0;
	      mIndividu.survival=0;

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
	  if(!firstGen) 
	    {
	      firstGen = true;
	    }
	  else
	    {
	      src_file >> type;
	    }
	  if(type == "Member")
	    {
	      std::string semicolon, sId; int id;
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
	       
	    std::string semicolon, tmp1, tmp2, tmp3;
	    std::string sNoGen, sId, sFitness, sGainFitness;
	    int noGen, id;
	    float fitness, gainFitness;
	    src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId >> id >> tmp2 >> sFitness >> fitness >> tmp3 >> sGainFitness >> gainFitness;
      
	      /* search the individu and update the fitness value, survival value and gainFtness value */
	    bool isFind = false;
	    for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
	      if( (*cur).id == id) 
		{
		  (*cur).fitness = fitness;
		  (*cur).gen = noGen;
		  (*cur).gain_fitness = gainFitness;
		  isFind = true;
		}

	      if(!isFind)
		throw std::string("can't find individu");
	    }
	  

	  else if(type == "Cross" || type == "Both")
	    {
	    
	      std::string semicolon, tmp1, tmp2, tmp3;
	      std::string sNoGen, sId_parent1, sId_parent2, sId_son;
	      int noGen, id_parent1, id_parent2, id_son;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 ;
	      src_file >> sId_parent1 >> id_parent1 >> tmp2 >> sId_parent2 >> id_parent2 >> tmp3 >> sId_son >> id_son;
      
	      Individu son;
	      son.id = id_son;
	      son.fitness = 0;
	      son.gain_fitness = 0;
	      son.survival = 0;
	      if(type=="Cross") son.origine=2;
	      else son.origine=3;
	      son.parent1 = id_parent1;
	      son.parent2 = id_parent2;
	      lIndividu.push_back(son);

	    }
	  else if(type == "Mutation" || type == "Clone")
	    {
	      
	      std::string semicolon, tmp1, tmp2;
	      std::string sNoGen, sId_parent, sId_mute;
	      int noGen, id_parent, id_mute;
	      src_file >> semicolon >> sNoGen >> noGen >> tmp1 >> sId_parent >> id_parent >> tmp2 >> sId_mute >> id_mute;
	   
	      Individu indMute;
	      indMute.id = id_mute;
	      indMute.fitness = 0;
	      indMute.gain_fitness =0;
	      indMute.survival = 0;
	      if(type == "Mutation") indMute.origine = 1;
	      else indMute.origine = 4;
	      indMute.parent1 = id_parent;
	      indMute.parent2 = 0;
	      lIndividu.push_back(indMute);

	    }
	  else
	    {
	       src_file.ignore(NB_CHAR_MAX_PER_LINE,'\n');
	    }

	}
      src_file.close();
	      
      

     


      /* ------------------------------------------------- */
      /* -- WRITING OUTPUT GRAPHML FILE TO COMPARE FAMILIES -- */
      /* ------------------------------------------------- */
	
      
      std::ofstream dest_file(dest_file_name.c_str(), std::ios::out | std::ios::trunc);
      if(!dest_file)
	throw std::string("can't open file \"" + dest_file_name + "\"");
        
      dest_file <<"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns \n http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n<graph edgedefault=\"directed\">" << std::endl;
      dest_file << "<key id=\"id\" for=\"node\" attr.name=\"id\" attr.type=\"int\"/>" << std::endl;
      dest_file << "<key id=\"gen\" for=\"node\" attr.name=\"gen\" attr.type=\"int\"/>" << std::endl;
      dest_file << "<key id=\"fitness\" for=\"node\" attr.name=\"fitness\" attr.type=\"double\"/>" << std::endl;
      dest_file << "<key id=\"gain_fitness\" for=\"node\" attr.name=\"gain_fitness\" attr.type=\"double\"/>" << std::endl;
      dest_file << "<key id=\"survival\" for=\"node\" attr.name=\"survival\" attr.type=\"int\"/>" << std::endl;
      dest_file << "<key id=\"origine\" for=\"node\" attr.name=\"origine\" attr.type=\"int\"/>" << std::endl;
      
      printf("je passe1");
      for(std::list<Individu>::iterator cur = lIndividu.begin(); cur != lIndividu.end(); cur++)
	{ printf("je passe");
	  dest_file << "<node id=\"n" << (*cur).id << "\">"<<std::endl;
	  dest_file << "<data key=\"id\">"<<std::endl;
	  dest_file << (*cur).id << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file << "<data key=\"gen\">"<<std::endl;
	  dest_file << (*cur).gen << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file << "<data key=\"fitness\">"<<std::endl;
	  dest_file << (*cur).fitness << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file << "<data key=\"gain_fitness\">"<<std::endl;
	  dest_file << (*cur).gain_fitness << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file << "<data key=\"survival\">"<<std::endl;
	  dest_file << (*cur).survival << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file << "<data key=\"origine\">"<<std::endl;
	  dest_file << (*cur).origine << std::endl;
	  dest_file <<"</data>"<<std::endl;
	  dest_file <<"</node>"<<std::endl;
	  dest_file <<"<edge source=\"n"<<(*cur).id<<"\" target=\"n"<<(*cur).parent1<<"\">"<<std::endl;
	  dest_file <<"</edge>"<<std::endl;
	  if((*cur).origine==2 || (*cur).origine==3)
	    {
	      dest_file <<"<edge source=\"n"<<(*cur).id<<"\" target=\"n"<<(*cur).parent2<<"\">"<<std::endl;
	      dest_file <<"</edge>"<<std::endl;
		}
	}
	   printf("je passe2");
      dest_file << "</graph>" <<std::endl;
      dest_file << "</graphml>" << std::endl;

      
      }
  catch(const std::string& error)
    {
      std::cout << "Error : " << error << std::endl;
      std::cout << "Use: lignee <src file> <dest file>" << std::endl;
      return 1;
      } 
  return 0;
}
