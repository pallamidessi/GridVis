*********************====****\\****//****====***********************************
*********************||*******\\**//*****||*************************************
*********************||********\\//******||*************************************
*********************|===******//\\******|===***********************************
*********************||*******//***\\****||*************************************
*********************====****//*****\\***====***********************************



La version de easea dans easeaMultiIlsandsOneMachine a �t� modifi�. Il g�n�re � chaque fois un fichier de G�n�alogie.

Pour visualiser ce fichier de g�n�alogie avec G�n�aQuilt, il faut utiliser arti2ged nom_src nom_dest.ged .

Pour visualiser ce fichier avec Graphdice, il faut utiliser lignee nom_src nom_dest.graphml . 

Pour visualiser toute le population avec R, il faut utiliser popstats nom_src nom_dest.csv .

Pour extraire l'arbre g�n�alogique du meilleur individu, il faut utiliser bassinstats nom_src nom_stats.csv nom_gen.txt . Le fichier nom_stats.csv peut �tre visualiser avec R alors que le fichier nom_gen.txt est un fichier de g�n�alogie qui regroupe uniquement les informations sur l'arbre g�n�alogique du meilleur individu et qui peut �tre r�utilis� par les deux premiers points.


Pour extraire l'arbre g�n�alogique du meilleur individu en ne guardant � chaque fois que le meilleur parent, il faut utiliser ligneestats nom_src nom_stats.csv nom_gen.txt . Le fichier nom_stats.csv peut �tre visualiser avec R alors que le fichier nom_gen.txt est un fichier de g�n�alogie qui regroupe uniquement les informations sur l'arbre g�n�alogique du meilleur individu et qui peut �tre r�utilis� par les deux premiers points.

Ces fichiers ont �t� r�alis� pour un probl�me de mimimization et demandent de l�gers changements pour un probl�me de maximisation.

Pour utiliser R regarder ReadMeR.txt


________________________________________________________________________________
Une question ?? un probl�me ?? ===> hgilbert@ensta.fr
-------------------------------------------------------------------------------- 
