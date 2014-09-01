

# les vecteurs qui contiennent le nombre de chaque type.
vOrigine0<-c()
vOrigine1<-c()
vOrigine2<-c()
vOrigine3<-c()
vOrigine4<-c()

# les vecteurs qui contiennent les valeurs de fitness du meilleur individu, du moins bon et de la moyenne.
vBestFitness<-c()
vWorstFitness<-c()
vMeanFitness<-c()

# Les vecteurs qui contiennent les valeurs moyennes de fitness pour chaque type d'individu.  
vMeanOrigine0<-c()
vMeanOrigine1<-c()
vMeanOrigine2<-c()
vMeanOrigine3<-c()
vMeanOrigine4<-c()


# Les vecteurs qui contiennent les variances moyennes de fitness pour chaque type d'individu.  
vVarOrigine0<-c()
vVarOrigine1<-c()
vVarOrigine2<-c()
vVarOrigine3<-c()
vVarOrigine4<-c()


# Les vecteurs qui contiennent les valeurs minimum de fitness pour chaque type d'individu.  
vMinOrigine0<-c()
vMinOrigine1<-c()
vMinOrigine2<-c()
vMinOrigine3<-c()
vMinOrigine4<-c()


# Les vecteurs qui contiennent les valeurs maximum de fitness pour chaque type d'individu.  
vMaxOrigine0<-c()
vMaxOrigine1<-c()
vMaxOrigine2<-c()
vMaxOrigine3<-c()
vMaxOrigine4<-c()


# Les vecteurs qui contiennent les valeurs moyennes de fitness pour chaque dizaine de générations.  
vMeanGen10<-c()
vMeanGen20<-c()
vMeanGen30<-c()
vMeanGen40<-c()
vMeanGen50<-c()
vMeanGen60<-c()
vMeanGen70<-c()
vMeanGen80<-c()
vMeanGen90<-c()
vMeanGen100<-c()


# Les vecteurs qui contiennent le nombre d'individu de duration number associé. 
vSurv1<-c()
vSurv2<-c()
vSurv3<-c()
vSurv4<-c()
vSurv5<-c()
vSurv6<-c()
vSurv7<-c()
vSurv8<-c()
vSurv9<-c()
vSurv10<-c()
vSurv11<-c()
vSurv12<-c()
vSurv13<-c()
vSurv14<-c()
vSurv15<-c()
vSurv16<-c()
vSurv17<-c()
vSurv18<-c()
vSurv19<-c()
vSurv20<-c()

# ici on fait trente expériences
for(j in 1:30){
setwd(paste("chemin_de_l_experience/experiment",j,sep=""))
tab<-read.csv("nom_du_fichier_stats.csv",header=TRUE,sep=";",dec=".")
print(summary(tab))
print(sort(table(tab$ORIGINE),decreasing=TRUE))

# On remplit chaque vecteur.  

if( is.finite(min(tab$FITNESS))) vBestFitness<-c(vBestFitness,min(tab$FITNESS))
if( is.finite(max(tab$FITNESS))) vWorstFitness<-c(vWorstFitness,max(tab$FITNESS))
if( is.finite(mean(tab$FITNESS))) vMeanFitness<-c(vMeanFitness,mean(tab$FITNESS))

if( is.finite(length(tab$ORIGINE[tab$ORIGINE==1])) && is.numeric(length(tab$ORIGINE[tab$ORIGINE==1]))  && !is.nan(length(tab$ORIGINE[tab$ORIGINE==1])) ) vOrigine1<-c(vOrigine1,length(tab$ORIGINE[tab$ORIGINE==1]))  
if( is.finite(length(tab$ORIGINE[tab$ORIGINE==2])) && is.numeric(length(tab$ORIGINE[tab$ORIGINE==2]))  && !is.nan(length(tab$ORIGINE[tab$ORIGINE==2])) ) vOrigine2<-c(vOrigine2,length(tab$ORIGINE[tab$ORIGINE==2]))  
if( is.finite(length(tab$ORIGINE[tab$ORIGINE==3])) && is.numeric(length(tab$ORIGINE[tab$ORIGINE==3]))  && !is.nan(length(tab$ORIGINE[tab$ORIGINE==3])) ) vOrigine3<-c(vOrigine3,length(tab$ORIGINE[tab$ORIGINE==3]))  
if( is.finite(length(tab$ORIGINE[tab$ORIGINE==4])) && is.numeric(length(tab$ORIGINE[tab$ORIGINE==4]))  && !is.nan(length(tab$ORIGINE[tab$ORIGINE==4])) ) vOrigine4<-c(vOrigine4,length(tab$ORIGINE[tab$ORIGINE==4])) 
if( is.finite(length(tab$ORIGINE[tab$ORIGINE==0])) && is.numeric(length(tab$ORIGINE[tab$ORIGINE==0]))  && !is.nan(length(tab$ORIGINE[tab$ORIGINE==0])) ) vOrigine0<-c(vOrigine0,length(tab$ORIGINE[tab$ORIGINE==0]))  






print(mean(tab$GAINFITNESS[tab$ORIGINE==0]))
if( is.numeric(mean(tab$GAINFITNESS[tab$ORIGINE==0])) && !is.nan(mean(tab$GAINFITNESS[tab$ORIGINE==0])) ) vMeanOrigine0<-c(vMeanOrigine0 , mean(tab$GAINFITNESS[tab$ORIGINE==0]))
if( is.numeric(var(tab$GAINFITNESS[tab$ORIGINE==0])) && !is.nan(var(tab$GAINFITNESS[tab$ORIGINE==0])) ) vVarOrigine0<-c(vVarOrigine0 , var(tab$GAINFITNESS[tab$ORIGINE==0]))
print(max(tab$GAINFITNESS[tab$ORIGINE==0]))
if( is.finite(max(tab$GAINFITNESS[tab$ORIGINE==0])) && is.numeric(max(tab$GAINFITNESS[tab$ORIGINE==0])) && !is.nan(max(tab$GAINFITNESS[tab$ORIGINE==0])) ) vMaxOrigine0<-c(vMaxOrigine0,max(tab$GAINFITNESS[tab$ORIGINE==0]))
print(min(tab$GAINFITNESS[tab$ORIGINE==0]))
if( is.finite(min(tab$GAINFITNESS[tab$ORIGINE==0])) && is.numeric(min(tab$GAINFITNESS[tab$ORIGINE==0])) && !is.nan(min(tab$GAINFITNESS[tab$ORIGINE==0])) ) vMinOrigine0<-c(vMinOrigine0,min(tab$GAINFITNESS[tab$ORIGINE==0]))
      
print(mean(tab$GAINFITNESS[tab$ORIGINE==1]))
if( is.numeric(mean(tab$GAINFITNESS[tab$ORIGINE==1])) && !is.nan(mean(tab$GAINFITNESS[tab$ORIGINE==1])) ) vMeanOrigine1<-c(vMeanOrigine1,mean(tab$GAINFITNESS[tab$ORIGINE==1]))
if( is.numeric(var(tab$GAINFITNESS[tab$ORIGINE==1])) && !is.nan(var(tab$GAINFITNESS[tab$ORIGINE==1])) ) vVarOrigine1<-c(vVarOrigine1,var(tab$GAINFITNESS[tab$ORIGINE==1]))

print(max(tab$GAINFITNESS[tab$ORIGINE==1]))
if( is.finite(max(tab$GAINFITNESS[tab$ORIGINE==1])) && is.numeric(max(tab$GAINFITNESS[tab$ORIGINE==1])) && !is.nan(max(tab$GAINFITNESS[tab$ORIGINE==1])) ) vMaxOrigine1<-c(vMaxOrigine1,max(tab$GAINFITNESS[tab$ORIGINE==1]))
print(min(tab$GAINFITNESS[tab$ORIGINE==1]))
if( is.finite(min(tab$GAINFITNESS[tab$ORIGINE==1])) && is.numeric(min(tab$GAINFITNESS[tab$ORIGINE==1])) && !is.nan(min(tab$GAINFITNESS[tab$ORIGINE==1])) ) vMinOrigine1<-c(vMinOrigine1,min(tab$GAINFITNESS[tab$ORIGINE==1]))
      
print(mean(tab$GAINFITNESS[tab$ORIGINE==2]))
if( is.finite(mean(tab$GAINFITNESS[tab$ORIGINE==2])) && is.numeric(mean(tab$GAINFITNESS[tab$ORIGINE==2])) && !is.nan(mean(tab$GAINFITNESS[tab$ORIGINE==2])) ) vMeanOrigine2<-c(vMeanOrigine2,mean(tab$GAINFITNESS[tab$ORIGINE==2]))
if( is.finite(var(tab$GAINFITNESS[tab$ORIGINE==2])) && is.numeric(var(tab$GAINFITNESS[tab$ORIGINE==2])) && !is.nan(var(tab$GAINFITNESS[tab$ORIGINE==2])) ) vVarOrigine2<-c(vVarOrigine2,var(tab$GAINFITNESS[tab$ORIGINE==2]))
print(max(tab$GAINFITNESS[tab$ORIGINE==2]))
if( is.finite(max(tab$GAINFITNESS[tab$ORIGINE==2])) && is.numeric(max(tab$GAINFITNESS[tab$ORIGINE==2])) && !is.nan(max(tab$GAINFITNESS[tab$ORIGINE==2])) ) vMaxOrigine2<-c(vMaxOrigine2,max(tab$GAINFITNESS[tab$ORIGINE==2]))
print(min(tab$GAINFITNESS[tab$ORIGINE==2]))
if( is.finite(min(tab$GAINFITNESS[tab$ORIGINE==2])) && is.numeric(min(tab$GAINFITNESS[tab$ORIGINE==2])) && !is.nan(min(tab$GAINFITNESS[tab$ORIGINE==2])) ) vMinOrigine2<-c(vMinOrigine2,min(tab$GAINFITNESS[tab$ORIGINE==2]))
     
print(mean(tab$GAINFITNESS[tab$ORIGINE==3]))
if( is.finite(mean(tab$GAINFITNESS[tab$ORIGINE==3])) && is.numeric(mean(tab$GAINFITNESS[tab$ORIGINE==3])) && !is.nan(mean(tab$GAINFITNESS[tab$ORIGINE==3])) ) vMeanOrigine3<-c(vMeanOrigine3,mean(tab$GAINFITNESS[tab$ORIGINE==3]))
if( is.finite(var(tab$GAINFITNESS[tab$ORIGINE==3])) && is.numeric(var(tab$GAINFITNESS[tab$ORIGINE==3])) && !is.nan(var(tab$GAINFITNESS[tab$ORIGINE==3])) ) vVarOrigine3<-c(vVarOrigine3,var(tab$GAINFITNESS[tab$ORIGINE==3]))
print(max(tab$GAINFITNESS[tab$ORIGINE==3]))
if( is.finite(max(tab$GAINFITNESS[tab$ORIGINE==3])) && is.numeric(max(tab$GAINFITNESS[tab$ORIGINE==3])) && !is.nan(max(tab$GAINFITNESS[tab$ORIGINE==3])) ) vMaxOrigine3<-c(vMaxOrigine3,max(tab$GAINFITNESS[tab$ORIGINE==3]))
print(min(tab$GAINFITNESS[tab$ORIGINE==3]))
if( is.finite(min(tab$GAINFITNESS[tab$ORIGINE==3])) && is.numeric(min(tab$GAINFITNESS[tab$ORIGINE==3])) && !is.nan(min(tab$GAINFITNESS[tab$ORIGINE==3])) ) vMinOrigine3<-c(vMinOrigine3,min(tab$GAINFITNESS[tab$ORIGINE==3]))

print(mean(tab$GAINFITNESS[tab$ORIGINE==4]))
if( is.finite(mean(tab$GAINFITNESS[tab$ORIGINE==4])) && is.numeric(mean(tab$GAINFITNESS[tab$ORIGINE==4])) && !is.nan(mean(tab$GAINFITNESS[tab$ORIGINE==4])) ) vMeanOrigine4<-c(vMeanOrigine4,mean(tab$GAINFITNESS[tab$ORIGINE==4]))
if( is.finite(var(tab$GAINFITNESS[tab$ORIGINE==4])) && is.numeric(var(tab$GAINFITNESS[tab$ORIGINE==4])) && !is.nan(var(tab$GAINFITNESS[tab$ORIGINE==4])) ) vVarOrigine4<-c(vVarOrigine4,var(tab$GAINFITNESS[tab$ORIGINE==4]))
print(max(tab$GAINFITNESS[tab$ORIGINE==4]))
if( is.finite(max(tab$GAINFITNESS[tab$ORIGINE==4])) && is.numeric(max(tab$GAINFITNESS[tab$ORIGINE==4])) && !is.nan(max(tab$GAINFITNESS[tab$ORIGINE==4])) ) vMaxOrigine4<-c(vMaxOrigine4,max(tab$GAINFITNESS[tab$ORIGINE==4]))
print(min(tab$GAINFITNESS[tab$ORIGINE==4]))
if( is.finite(min(tab$GAINFITNESS[tab$ORIGINE==4])) && is.numeric(min(tab$GAINFITNESS[tab$ORIGINE==4])) && !is.nan(min(tab$GAINFITNESS[tab$ORIGINE==4])) ) vMinOrigine4<-c(vMinOrigine4,min(tab$GAINFITNESS[tab$ORIGINE==4]))
      
      
for(i in 0:10){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen10<-c(vMeanGen10,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 11:20){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen20<-c(vMeanGen20,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 21:30){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen30<-c(vMeanGen30,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 31:40){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen40<-c(vMeanGen40,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 41:50){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen50<-c(vMeanGen50,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 51:60){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen60<-c(vMeanGen60,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 61:70){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen70<-c(vMeanGen70,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 71:80){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen80<-c(vMeanGen80,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 81:90){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen90<-c(vMeanGen90,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }

for(i in 91:100){
print(mean(tab$GAINFITNESS[tab$GEN==i]))
if( is.numeric(mean(tab$GAINFITNESS[tab$GEN==i])) && !is.nan(mean(tab$GAINFITNESS[tab$GEN==i])) ) vMeanGen100<-c(vMeanGen100,mean(tab$GAINFITNESS[tab$GEN==i]))   
 }


for(i in 1:20){
print(length(tab$SURVIVAL[tab$SURVIVAL==i]))
}

if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==1]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==1])) ) vSurv1<-c(vSurv1,length(tab$SURVIVAL[tab$SURVIVAL==1]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==2]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==2])) ) vSurv2<-c(vSurv2,length(tab$SURVIVAL[tab$SURVIVAL==2]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==3]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==3])) ) vSurv3<-c(vSurv3,length(tab$SURVIVAL[tab$SURVIVAL==3]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==4]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==4])) ) vSurv4<-c(vSurv4,length(tab$SURVIVAL[tab$SURVIVAL==4]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==5]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==5])) ) vSurv5<-c(vSurv5,length(tab$SURVIVAL[tab$SURVIVAL==5]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==6]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==6])) ) vSurv6<-c(vSurv6,length(tab$SURVIVAL[tab$SURVIVAL==6]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==7]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==7])) ) vSurv7<-c(vSurv7,length(tab$SURVIVAL[tab$SURVIVAL==7]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==8]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==8])) ) vSurv8<-c(vSurv8,length(tab$SURVIVAL[tab$SURVIVAL==8]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==9]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==9])) ) vSurv9<-c(vSurv9,length(tab$SURVIVAL[tab$SURVIVAL==9]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==10]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==10])) ) vSurv10<-c(vSurv10,length(tab$SURVIVAL[tab$SURVIVAL==10]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==11]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==11])) ) vSurv11<-c(vSurv11,length(tab$SURVIVAL[tab$SURVIVAL==11]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==12]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==12])) ) vSurv12<-c(vSurv12,length(tab$SURVIVAL[tab$SURVIVAL==12]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==13]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==13])) ) vSurv13<-c(vSurv13,length(tab$SURVIVAL[tab$SURVIVAL==13]))
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==14]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==14])) ) vSurv14<-c(vSurv14,length(tab$SURVIVAL[tab$SURVIVAL==14]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==15]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==15])) ) vSurv15<-c(vSurv15,length(tab$SURVIVAL[tab$SURVIVAL==15]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==16]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==16])) ) vSurv16<-c(vSurv16,length(tab$SURVIVAL[tab$SURVIVAL==16]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==17]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==17])) ) vSurv17<-c(vSurv17,length(tab$SURVIVAL[tab$SURVIVAL==17]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==18]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==18])) ) vSurv18<-c(vSurv18,length(tab$SURVIVAL[tab$SURVIVAL==18]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==19]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==19])) ) vSurv19<-c(vSurv19,length(tab$SURVIVAL[tab$SURVIVAL==19]))  
if( is.numeric(length(tab$SURVIVAL[tab$SURVIVAL==20]))  && !is.nan(length(tab$SURVIVAL[tab$SURVIVAL==20])) ) vSurv20<-c(vSurv20,length(tab$SURVIVAL[tab$SURVIVAL==20]))  


}

# Un peu d'affichage sur la population

 print(paste("le nombre moyen d\'ancetres est :", mean(vOrigine0)))
 print(paste("le nombre moyen de mutations est :", mean(vOrigine1)))
 print(paste("le nombre moyen de crossovers est :", mean(vOrigine2)))
 print(paste("le nombre moyen de boths est :", mean(vOrigine3)))
 print(paste("le nombre moyen de clones est :", mean(vOrigine4)))

 vOrigine<-c(mean(vOrigine0),mean(vOrigine1),mean(vOrigine2),mean(vOrigine3),mean(vOrigine4))


vStatOrigine<-c(100*mean(vOrigine0)/(mean(vOrigine0)+mean(vOrigine1)+mean(vOrigine2)+mean(vOrigine3)+mean(vOrigine4)),100*mean(vOrigine1)/(mean(vOrigine0)+mean(vOrigine1)+mean(vOrigine2)+mean(vOrigine3)+mean(vOrigine4)),100*mean(vOrigine2)/(mean(vOrigine0)+mean(vOrigine1)+mean(vOrigine2)+mean(vOrigine3)+mean(vOrigine4)),100*mean(vOrigine3)/(mean(vOrigine0)+mean(vOrigine1)+mean(vOrigine2)+mean(vOrigine3)+mean(vOrigine4)),100*mean(vOrigine4)/(mean(vOrigine0)+mean(vOrigine1)+mean(vOrigine2)+mean(vOrigine3)+mean(vOrigine4)))

print(paste("le gainfitness moyen des ancetres est de :", mean(vMeanOrigine0)))
print(paste("le gainfitness moyen des mutations est de :", mean(vMeanOrigine1)))
print(paste("le gainfitness moyen des crossovers est de :", mean(vMeanOrigine2)))
print(paste("le gainfitness moyen des boths est de :", mean(vMeanOrigine3)))
print(paste("le gainfitness moyen des clones est de :", mean(vMeanOrigine4)))

vMeanOrigine<-c(mean(vMeanOrigine0),mean(vMeanOrigine1),mean(vMeanOrigine2),mean(vMeanOrigine3),0)

vVarOrigine<-c(mean(vVarOrigine0),mean(vVarOrigine1),mean(vVarOrigine2),mean(vVarOrigine3),mean(vVarOrigine4))

print(paste("le gainfitness min des ancetres est de :", mean(vMinOrigine0)))
print(paste("le gainfitness min des mutations est de :", mean(vMinOrigine1)))
print(paste("le gainfitness min des crossovers est de :", mean(vMinOrigine2)))
print(paste("le gainfitness min des boths est de :", mean(vMinOrigine3)))
print(paste("le gainfitness min des clones est de :", mean(vMinOrigine4)))

vMinOrigine<-c(mean(vMinOrigine0),mean(vMinOrigine1),mean(vMinOrigine2),mean(vMinOrigine3),0)

print(paste("le gainfitness max des ancetres est de :", mean(vMaxOrigine0)))
print(paste("le gainfitness max des mutations est de :", mean(vMaxOrigine1)))
print(paste("le gainfitness max des crossovers est de :", mean(vMaxOrigine2)))
print(paste("le gainfitness max des boths est de :", mean(vMaxOrigine3)))
print(paste("le gainfitness max des clones est de :", mean(vMaxOrigine4)))

vMaxOrigine<-c(mean(vMaxOrigine0),mean(vMaxOrigine1),mean(vMaxOrigine2),mean(vMaxOrigine3),0)

print(paste("le gainfitness moyen entre les generations 0 et 10 est de:", mean(vMeanGen10)))
print(paste("le gainfitness moyen entre les generations 11 et 20 est de:", mean(vMeanGen20)))
print(paste("le gainfitness moyen entre les generations 21 et 30 est de:", mean(vMeanGen30)))
print(paste("le gainfitness moyen entre les generations 31 et 40 est de:", mean(vMeanGen40)))
print(paste("le gainfitness moyen entre les generations 41 et 50 est de:", mean(vMeanGen50)))
print(paste("le gainfitness moyen entre les generations 51 et 60 est de:", mean(vMeanGen60)))
print(paste("le gainfitness moyen entre les generations 61 et 70 est de:", mean(vMeanGen70)))
print(paste("le gainfitness moyen entre les generations 71 et 80 est de:", mean(vMeanGen80)))
print(paste("le gainfitness moyen entre les generations 81 et 90 est de:", mean(vMeanGen90)))
print(paste("le gainfitness moyen entre les generations 91 et 100 est de:", mean(vMeanGen100)))

vMeanGen<-c(mean(vMeanGen10),mean(vMeanGen20),mean(vMeanGen30),mean(vMeanGen40),mean(vMeanGen50),mean(vMeanGen60),mean(vMeanGen70),mean(vMeanGen80),mean(vMeanGen90),mean(vMeanGen100))


print(paste("le nombre d\'individu ayant survecu 1 generation est de:", mean(vSurv1)))
print(paste("le nombre d\'individu ayant survecu 2 generation est de:", mean(vSurv2)))
print(paste("le nombre d\'individu ayant survecu 3 generation est de:", mean(vSurv3)))
print(paste("le nombre d\'individu ayant survecu 4 generation est de:", mean(vSurv4)))
print(paste("le nombre d\'individu ayant survecu 5 generation est de:", mean(vSurv5)))
print(paste("le nombre d\'individu ayant survecu 6 generation est de:", mean(vSurv6)))
print(paste("le nombre d\'individu ayant survecu 7 generation est de:", mean(vSurv7)))
print(paste("le nombre d\'individu ayant survecu 8 generation est de:", mean(vSurv8)))
print(paste("le nombre d\'individu ayant survecu 9 generation est de:", mean(vSurv9)))
print(paste("le nombre d\'individu ayant survecu 10 generation est de:", mean(vSurv10)))
print(paste("le nombre d\'individu ayant survecu 11 generation est de:", mean(vSurv11)))
print(paste("le nombre d\'individu ayant survecu 12 generation est de:", mean(vSurv12)))
print(paste("le nombre d\'individu ayant survecu 13 generation est de:", mean(vSurv13)))
print(paste("le nombre d\'individu ayant survecu 14 generation est de:", mean(vSurv14)))
print(paste("le nombre d\'individu ayant survecu 15 generation est de:", mean(vSurv15)))
print(paste("le nombre d\'individu ayant survecu 16 generation est de:", mean(vSurv16)))
print(paste("le nombre d\'individu ayant survecu 17 generation est de:", mean(vSurv17)))
print(paste("le nombre d\'individu ayant survecu 18 generation est de:", mean(vSurv18)))
print(paste("le nombre d\'individu ayant survecu 19 generation est de:", mean(vSurv19)))
print(paste("le nombre d\'individu ayant survecu 20 generation est de:", mean(vSurv20)))

vSurv<-c(mean(vSurv1),mean(vSurv2),mean(vSurv3),mean(vSurv4),mean(vSurv5),mean(vSurv6),mean(vSurv7),mean(vSurv8),mean(vSurv9),mean(vSurv10),mean(vSurv11),mean(vSurv12),mean(vSurv13),mean(vSurv14),mean(vSurv15),mean(vSurv16),mean(vSurv17),mean(vSurv18),mean(vSurv19),mean(vSurv20))

vFitness<-c(mean(vBestFitness),mean(vMeanFitness),mean(vWorstFitness))


# On passe aux graphiques
# color = couleur des graphiques
# exp = nom de l'expérience globale
# ecran = écran d'affichage
# nbecran = nombre d'écran qui divisent la fenêtre.
# premier = l'expérience globale est elle la première réalisée. Dans ce cas il faut ouvrir les fenêtres d'affichage.

color <- "black"
exp <- "original"
ecran <- 1
nbecran <- 3
premier <- 1

if(premier == 1) x11(width=10,height=10)
dev.set(2)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vSurv,col=color,sub=exp)
title(main="Number of individuals according to Survival",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(3)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vOrigine,col=color,sub=exp)
title(main="Number of individuals according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(4)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vStatOrigine,col=color,sub=exp,ylim=c(0,100))
title(main="Percentage of individuals according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(5)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vMeanGen,col=color,sub=exp)
title(main="GainFitness according to the Generation Number",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(6)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vMaxOrigine,col=color,sub=exp)
title(main="GainFitness Max according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(7)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vMinOrigine,col=color,sub=exp)
title(main="GainFitness Min according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(8)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vMeanOrigine,col=color,sub=exp)
title(main="Average GainFitness according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(9)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vVarOrigine,col=color,sub=exp)
title(main="GainFitness STDV according to the Origin",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(10)
split.screen(c(1,nbecran))
screen(ecran)
barplot(vFitness,col=color,sub=exp)
title(main="Best, Mean and Worst Fitness",outer=TRUE,line=-1)

if(premier == 1) x11(width=10,height=10)
dev.set(11)
split.screen(c(1,nbecran))
screen(ecran)
barplot(mean(vBestFitness),col=color,sub=exp)
title(main="Best Fitness",outer=TRUE,line=-1)


setwd("~")
