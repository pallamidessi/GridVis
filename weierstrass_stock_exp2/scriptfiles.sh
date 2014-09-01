#!/bin/bash

for i in `seq 1 30`
do
./../exe/popstats experiment$i/weierstrass2929Gen.txt experiment$i/weierstrasspop.csv
./../exe/bassinstats experiment$i/weierstrass2929Gen.txt experiment$i/weierstrassbest.csv experiment$i/weierstrasspart.txt

done